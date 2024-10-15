using System;
using System.Collections.Generic;

namespace IoTApp.Models;

public partial class RideError
{
    public int Id { get; set; }

    public string Name { get; set; } = null!;

    public virtual ICollection<UserRideError> UserRideErrors { get; set; } = new List<UserRideError>();
}
