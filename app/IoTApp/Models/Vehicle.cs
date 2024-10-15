using System;
using System.Collections.Generic;

namespace IoTApp.Models;

public partial class Vehicle
{
    public int Id { get; set; }

    public string? PlateNumber { get; set; }

    public int DrivingSchool { get; set; }

    public virtual DrivingSchool DrivingSchoolNavigation { get; set; } = null!;

    public virtual ICollection<Ride> Rides { get; set; } = new List<Ride>();

    public virtual ICollection<VehicleDatum> VehicleData { get; set; } = new List<VehicleDatum>();
}
