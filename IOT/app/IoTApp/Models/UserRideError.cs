using System;
using System.Collections.Generic;

namespace IoTApp.Models;

public partial class UserRideError
{
    public int Id { get; set; }

    public string User { get; set; } = null!;

    public int Ride { get; set; }

    public int Error { get; set; }

    public DateTime TimeStamp { get; set; }

    public virtual RideError ErrorNavigation { get; set; } = null!;

    public virtual Ride RideNavigation { get; set; } = null!;
}
