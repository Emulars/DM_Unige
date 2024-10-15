using System;
using System.Collections.Generic;

namespace IoTApp.Models;

public partial class DrivingSchool
{
    public int Id { get; set; }

    public string Name { get; set; } = null!;

    public string Address { get; set; } = null!;

    public virtual ICollection<Vehicle> Vehicles { get; set; } = new List<Vehicle>();
}
