using System;
using System.Collections.Generic;

namespace IoTApp.Models;

public partial class UserName
{
    public int Id { get; set; }

    public string User { get; set; } = null!;

    public string Name { get; set; } = null!;

    public string Surname { get; set; } = null!;

    public DateOnly Birthday { get; set; }

    public int Nationality { get; set; }

    public virtual Nation NationalityNavigation { get; set; } = null!;

    public virtual AspNetUser UserNavigation { get; set; } = null!;
}
