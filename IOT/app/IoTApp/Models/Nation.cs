using System;
using System.Collections.Generic;

namespace IoTApp.Models;

public partial class Nation
{
    public int Id { get; set; }

    public string Name { get; set; } = null!;

    public virtual ICollection<UserName> UserNames { get; set; } = new List<UserName>();
}
