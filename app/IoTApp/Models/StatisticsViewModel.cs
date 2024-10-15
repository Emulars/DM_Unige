namespace IoTApp.Models
{
    public class StatisticsViewModel
    {
        public double AverageSpeed { get; set; }
        public double AverageRpm { get; set; }
        public double AverageFuelConsumptionRate { get; set; }
        public bool HasData { get; set; }

        public Dictionary<string, int> ErrorsByCategory { get; set; } = new Dictionary<string, int>();
        public List<ErrorLocation> ErrorLocations { get; set; } = new List<ErrorLocation>();
    }

    public class ErrorLocation
    {
        public double Latitude { get; set; }
        public double Longitude { get; set; }
        public string? ErrorType { get; set; }
    }


}
