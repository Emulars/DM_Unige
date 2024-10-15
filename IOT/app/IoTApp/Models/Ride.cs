using System;
using System.Collections.Generic;

namespace IoTApp.Models;

public partial class Ride
{
    public int Id { get; set; }

    public string Driver { get; set; } = null!;

    public string Instructor { get; set; } = null!;

    public int? Vehicle { get; set; }

    public DateTime Prenotation { get; set; }

    public DateTime? StartRide { get; set; }

    public DateTime? EndRide { get; set; }

    public virtual AspNetUser DriverNavigation { get; set; } = null!;

    public virtual AspNetUser InstructorNavigation { get; set; } = null!;

    public virtual ICollection<UserRideError> UserRideErrors { get; set; } = new List<UserRideError>();

    public virtual Vehicle? VehicleNavigation { get; set; }
}
