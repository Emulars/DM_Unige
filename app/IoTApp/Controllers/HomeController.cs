using IoTApp.Data;
using IoTApp.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Diagnostics;
using System.Security.Claims;

namespace IoTApp.Controllers
{
    [Authorize]
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly ApplicationDbContext _context;
        private readonly CustomDbContext _Appcontext;

        public HomeController(ILogger<HomeController> logger, ApplicationDbContext context, CustomDbContext context2)
        {
            _logger = logger;
            _context = context;
            _Appcontext = context2;
        }

        public IActionResult Index()
        {
            if (User.IsInRole("Driver"))
                return RedirectToAction("Statistics");
            

            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier);
            var now = DateTime.Now;

            var boolres = HttpContext.Session.GetString("RideStarted");
            
            if (boolres == null)
            {
                var ride = _Appcontext.Rides
                    .Where(r => r.Instructor == userId && r.Prenotation <= now)
                    .OrderByDescending(r => r.Prenotation)
                    .FirstOrDefault();

                boolres = (ride != null && ride.StartRide != null && ride.EndRide == null).ToString();
                HttpContext.Session.SetString("RideStarted", boolres);
            }

            ViewBag.RideStarted = boolres;
            ViewBag.Message = HttpContext.Session.GetString("Message");
            ViewBag.IsError = HttpContext.Session.GetString("IsError");

            return View();
        }

        [HttpPost]
        public IActionResult ClearMessage()
        {
            HttpContext.Session.Remove("Message");
            HttpContext.Session.Remove("IsError");
            return Ok();
        }

        public IActionResult Statistics()
        {
            var rideId = int.Parse(HttpContext.Session.GetString("RideId") ?? "-1");

            Ride? ride;
            if (rideId == -1)
            {
                var userId = User.FindFirstValue(ClaimTypes.NameIdentifier);
                var now = DateTime.Now;

                ride = _Appcontext.Rides
                                .Where(r => (r.Instructor == userId || r.Driver == userId) && r.StartRide != null && r.EndRide != null)
                                .OrderByDescending(r => r.EndRide)
                                .FirstOrDefault();
            }
            else
            {
                ride = _Appcontext.Rides
                                .Where(r => r.Id == rideId)
                                .FirstOrDefault();
            }

            StatisticsViewModel model = new();

            if (ride != null)
            {
                var vehicleData = _Appcontext.VehicleData
                    .Where(x => x.VehicleId == ride.Vehicle && x.TimeStamp >= ride.StartRide && x.TimeStamp <= ride.EndRide)
                    .ToList();

                if (vehicleData != null && vehicleData.Any())
                {
                    model.AverageSpeed = vehicleData.Average(v => v.Speed) ?? 0;
                    model.AverageRpm = vehicleData.Average(v => v.Rpm) ?? 0;
                    model.AverageFuelConsumptionRate = vehicleData.Average(v => v.FuelConsumptionRate) ?? 0;
                    model.HasData = true;

                    var errors = _Appcontext.UserRideErrors
                    .Where(e => e.Ride == ride.Id)
                    .Include(e => e.ErrorNavigation)
                    .ToList();

                    foreach (var error in errors)
                    {
                        if (model.ErrorsByCategory.ContainsKey(error.ErrorNavigation.Name))
                        {
                            model.ErrorsByCategory[error.ErrorNavigation.Name]++;
                        }
                        else
                        {
                            model.ErrorsByCategory[error.ErrorNavigation.Name] = 1;
                        }

                        // Trovare le coordinate GPS più vicine per ogni errore
                        var closestVehicleData = vehicleData
                            .OrderBy(v => Math.Abs((v.TimeStamp - error.TimeStamp).Value.TotalSeconds))
                            .FirstOrDefault();

                        if (closestVehicleData != null)
                        {
                            model.ErrorLocations.Add(new ErrorLocation
                            {
                                Latitude = closestVehicleData.Latitude ?? 0,
                                Longitude = closestVehicleData.Longitude ?? 0,
                                ErrorType = error.ErrorNavigation.Name
                            });
                        }

                    }
                }
            }
            return View(model);
        }


        [HttpPost]
        public IActionResult StartRide(string qrCode)
        {
            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier);
            var now = DateTime.Now;

            var ride = _Appcontext.Rides
                            .Where(r => r.Instructor == userId && (r.Prenotation <= now && r.Prenotation > now.Date) && r.StartRide == null)
                            .OrderByDescending(r => r.Prenotation)
                            .FirstOrDefault();

            //Default case of error
            HttpContext.Session.SetString("IsError", "true");
            HttpContext.Session.SetString("RideStarted", "false");
            HttpContext.Session.SetString("Message", "No rides booked for this instructor");

            if (ride != null)
            {
                ride.Vehicle = int.Parse(qrCode);
                ride.StartRide = now;

                try
                {
                    _Appcontext.SaveChanges();
                    HttpContext.Session.SetString("RideId", ride.Id.ToString());
                    HttpContext.Session.SetString("IsError", "false");
                    HttpContext.Session.SetString("RideStarted", "true");
                    HttpContext.Session.SetString("Message", "Ride started successfully");
                }
                catch (Exception ex)
                {
                    _logger.LogError(ex, "Failed to start the ride.");
                    HttpContext.Session.SetString("IsError", "true");
                    HttpContext.Session.SetString("Message", "Error during starting phase");
                }
            }

            return RedirectToAction("Index");
        }

        [HttpPost]
        public IActionResult EndRide()
        {
            var userId = User.FindFirstValue(ClaimTypes.NameIdentifier);
            var now = DateTime.Now;

            var rideId = int.Parse(HttpContext.Session.GetString("RideId") ?? "-1");

            var ride = _Appcontext.Rides
                                .Where(r => r.Id == rideId)
                                .FirstOrDefault();

            HttpContext.Session.SetString("Message", "No active ride found");
            HttpContext.Session.SetString("IsError", "true");
            HttpContext.Session.SetString("RideStarted", "false");


            if (ride != null)
            {
                ride.EndRide = now;

                try
                {
                    _Appcontext.SaveChanges();
                    HttpContext.Session.SetString("Message", "Ride ended successfully");
                    HttpContext.Session.SetString("IsError", "false");
                }
                catch (Exception ex)
                {
                    _logger.LogError(ex, "Failed to end the ride.");
                    HttpContext.Session.SetString("IsError", "true");
                    HttpContext.Session.SetString("Message", "Error during ending phase");
                }
            }
            return RedirectToAction("Index");
        }

        [HttpPost]
        public IActionResult WriteError(int errorCode)
        {
            HttpContext.Session.SetString("Message", "");
            HttpContext.Session.SetString("IsError", "");

            var rideId = int.Parse(HttpContext.Session.GetString("RideId") ?? "-1");
            Ride? ride;

            if (rideId < 0)
            {
                var userId = User.FindFirstValue(ClaimTypes.NameIdentifier);
                var now = DateTime.Now;
                ride = _Appcontext.Rides
                .Where(r => r.Instructor == userId && r.StartRide != null && r.EndRide == null)
                .OrderByDescending(r => r.Prenotation)
                .FirstOrDefault();
            }
            else
            {
                 ride = _Appcontext.Rides.Where(r => r.Id == rideId).FirstOrDefault();
            }

            if (ride != null)
            {
                HttpContext.Session.SetString("RideId", ride.Id.ToString());

                var errToAdd = new UserRideError
                {
                    User = ride.Driver,
                    Ride = ride.Id,
                    Error = errorCode,
                    TimeStamp = DateTime.Now
                };

                _Appcontext.UserRideErrors.Add(errToAdd);

                try
                {
                    _Appcontext.SaveChanges();
                }
                catch (Exception ex)
                {
                    _logger.LogError(ex, "Failed to add ride error.");
                    HttpContext.Session.SetString("Message", "Failed to add ride error.");
                    HttpContext.Session.SetString("IsError", "true");
                }

            }
            else 
            {
                _logger.LogError("Failed to retrive ride by id.");
            }

            return RedirectToAction("Index");
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
