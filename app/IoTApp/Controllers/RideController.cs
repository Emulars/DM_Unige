using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using IoTApp.Models;
using IoTApp.Data;
using IoTApp.Controllers;

[Authorize(Roles = "Admin, Instructor")]
public class RideController : Controller
{
    private readonly ILogger<HomeController> _logger;
    private readonly CustomDbContext _context;
    private readonly UserManager<IdentityUser> _userManager;
    private readonly RoleManager<IdentityRole> _roleManager;

    public RideController(ILogger<HomeController> logger, CustomDbContext context, UserManager<IdentityUser> userManager, RoleManager<IdentityRole> roleManager)
    {
        _logger = logger;
        _context = context;
        _userManager = userManager;
        _roleManager = roleManager;
    }

    // GET: Ride/Create
    public async Task<IActionResult> Create()
    {
        var instructors = await _userManager.GetUsersInRoleAsync("Instructor");
        var drivers = await _userManager.GetUsersInRoleAsync("Driver");

        ViewData["Instructors"] = instructors.Select(u => new { u.Id, u.Email }).ToList();
        ViewData["Drivers"] = drivers.Select(u => new { u.Id, u.Email }).ToList();

        ViewBag.Message = HttpContext.Session.GetString("Message");
        ViewBag.IsError = HttpContext.Session.GetString("IsError");

        HttpContext.Session.Remove("Message");
        HttpContext.Session.Remove("IsError");

        return View();
    }

    // POST: Ride/Create
    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Create(Ride ride)
    {
        HttpContext.Session.SetString("IsError", "false");
        HttpContext.Session.SetString("Message", "Ride create successfully");

        try
        {
            _context.Rides.Add(ride);
            await _context.SaveChangesAsync();
        }
        catch (Exception ex)
        {
            _logger.LogError(ex, "Failed to create the ride.");
            HttpContext.Session.SetString("IsError", "true");
            HttpContext.Session.SetString("Message", "Error during ride creation");
        }
        return RedirectToAction("Create", "Ride");
    }
}
