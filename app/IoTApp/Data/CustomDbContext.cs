using Microsoft.EntityFrameworkCore;

namespace IoTApp.Models;

public partial class CustomDbContext : DbContext
{
    public CustomDbContext()
    {
    }

    public CustomDbContext(DbContextOptions<CustomDbContext> options) : base(options)
    {
    }
    public virtual DbSet<DrivingSchool> DrivingSchools { get; set; }
    public virtual DbSet<Nation> Nations { get; set; }
    public virtual DbSet<Ride> Rides { get; set; }
    public virtual DbSet<RideError> RideErrors { get; set; }
    public virtual DbSet<UserRideError> UserRideErrors { get; set; }
    public virtual DbSet<UserName> UserNames { get; set; }
    public virtual DbSet<Vehicle> Vehicles { get; set; }
    public virtual DbSet<VehicleDatum> VehicleData { get; set; }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
{
    base.OnModelCreating(modelBuilder);
    modelBuilder.Entity<DrivingSchool>(entity =>
    {
        entity.HasKey(e => e.Id).HasName("PK__DrivingS__3214EC0706D0A1FD");

        entity.ToTable("DrivingSchool");

        entity.Property(e => e.Address).HasMaxLength(50);
        entity.Property(e => e.Name).HasMaxLength(50);
    });

    modelBuilder.Entity<Nation>(entity =>
    {
        entity.HasKey(e => e.Id).HasName("PK__Nation__3214EC07FE846229");
        entity.ToTable("Nation");
        entity.Property(e => e.Name).HasMaxLength(50);
    });

    modelBuilder.Entity<Ride>(entity =>
    {
        entity.HasKey(e => e.Id).HasName("PK__Ride__3214EC079225F504");
        entity.ToTable("Ride");
        entity.Property(e => e.Driver).HasMaxLength(450);
        entity.Property(e => e.EndRide).HasColumnType("datetime");
        entity.Property(e => e.Instructor).HasMaxLength(450);
        entity.Property(e => e.Prenotation).HasColumnType("datetime");
        entity.Property(e => e.StartRide).HasColumnType("datetime");

        entity.HasOne(d => d.DriverNavigation).WithMany(p => p.RideDriverNavigations)
            .HasForeignKey(d => d.Driver)
            .OnDelete(DeleteBehavior.ClientSetNull)
            .HasConstraintName("FK__Ride__Driver__5070F446");

        entity.HasOne(d => d.InstructorNavigation).WithMany(p => p.RideInstructorNavigations)
            .HasForeignKey(d => d.Instructor)
            .OnDelete(DeleteBehavior.ClientSetNull)
            .HasConstraintName("FK__Ride__Instructor__5165187F");

        entity.HasOne(d => d.VehicleNavigation).WithMany(p => p.Rides)
            .HasForeignKey(d => d.Vehicle)
            .HasConstraintName("FK__Ride__Vehicle__52593CB8");
    });
    
    modelBuilder.Entity<RideError>(entity =>
    {
        entity.HasKey(e => e.Id).HasName("PK__RideErro__3214EC0765C2737C");

        entity.Property(e => e.Name).HasMaxLength(50);
    });

    modelBuilder.Entity<UserRideError>(entity =>
    {
        entity.HasKey(e => e.Id).HasName("PK__UserRide__3214EC07592A6A34");

        entity.ToTable("UserRideError");

        entity.Property(e => e.TimeStamp).HasColumnType("datetime");
        entity.Property(e => e.User).HasMaxLength(450);

        entity.HasOne(d => d.ErrorNavigation).WithMany(p => p.UserRideErrors)
            .HasForeignKey(d => d.Error)
            .OnDelete(DeleteBehavior.ClientSetNull)
            .HasConstraintName("FK__UserRideE__Error__6C190EBB");

        entity.HasOne(d => d.RideNavigation).WithMany(p => p.UserRideErrors)
            .HasForeignKey(d => d.Ride)
            .OnDelete(DeleteBehavior.ClientSetNull)
            .HasConstraintName("FK__UserRideEr__Ride__6D0D32F4");
    });

        modelBuilder.Entity<UserName>(entity =>
    {
        entity.HasKey(e => e.Id).HasName("PK__UserName__3214EC0764C15AA8");
        entity.Property(e => e.Name).HasMaxLength(35);
        entity.Property(e => e.Surname).HasMaxLength(35);
        entity.Property(e => e.User).HasMaxLength(450);

        entity.HasOne(d => d.NationalityNavigation).WithMany(p => p.UserNames)
            .HasForeignKey(d => d.Nationality)
            .OnDelete(DeleteBehavior.ClientSetNull)
            .HasConstraintName("FK__UserNames__Natio__6383C8BA");

        entity.HasOne(d => d.UserNavigation).WithMany(p => p.UserNames)
            .HasForeignKey(d => d.User)
            .OnDelete(DeleteBehavior.ClientSetNull)
            .HasConstraintName("FK__UserNames__User__628FA481");
    });

    modelBuilder.Entity<Vehicle>(entity =>
    {
        entity.HasKey(e => e.Id).HasName("PK__Vehicle__3214EC073B3A25F8");

        entity.ToTable("Vehicle");

        entity.Property(e => e.PlateNumber).HasMaxLength(7);

        entity.HasOne(d => d.DrivingSchoolNavigation).WithMany(p => p.Vehicles)
            .HasForeignKey(d => d.DrivingSchool)
            .OnDelete(DeleteBehavior.ClientSetNull)
            .HasConstraintName("FK_Vehicle_DrivingSchool");
    });

    modelBuilder.Entity<VehicleDatum>(entity =>
    {
        entity.HasKey(e => e.Id).HasName("PK__VehicleD__3214EC274835E468");

        entity.Property(e => e.Id).HasColumnName("ID");
        entity.Property(e => e.BatteryVoltage).HasColumnName("Battery_voltage");
        entity.Property(e => e.FuelConsumptionRate).HasColumnName("Fuel_consumption_rate");
        entity.Property(e => e.FuelLevel).HasColumnName("Fuel_level");
        entity.Property(e => e.OilPressure).HasColumnName("Oil_pressure");
        entity.Property(e => e.OilTemperature).HasColumnName("Oil_temperature");
        entity.Property(e => e.ThrottlePos).HasColumnName("Throttle_pos");
        entity.Property(e => e.TimeStamp).HasColumnType("datetime");
        entity.Property(e => e.TransmissionTemperature).HasColumnName("Transmission_temperature");

        entity.HasOne(d => d.Vehicle).WithMany(p => p.VehicleData)
            .HasForeignKey(d => d.VehicleId)
            .HasConstraintName("FK__VehicleDa__Vehic__02FC7413");
    });

        OnModelCreatingPartial(modelBuilder);
}

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}