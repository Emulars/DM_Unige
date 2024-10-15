using System;
using System.Collections.Generic;

namespace IoTApp.Models;

public partial class VehicleDatum
{
    public int Id { get; set; }

    public int? VehicleId { get; set; }

    public DateTime? TimeStamp { get; set; }

    public double? Speed { get; set; }

    public double? Rpm { get; set; }

    public double? ThrottlePos { get; set; }

    public double? BatteryVoltage { get; set; }

    public double? TransmissionTemperature { get; set; }

    public double? OilTemperature { get; set; }

    public double? OilPressure { get; set; }

    public double? FuelLevel { get; set; }

    public double? FuelConsumptionRate { get; set; }

    public double? Latitude { get; set; }

    public double? Longitude { get; set; }

    public virtual Vehicle? Vehicle { get; set; }
}
