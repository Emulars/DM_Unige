using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

[Authorize(Roles = "Admin")]
public class UserRoleManagementController : Controller
{
    private readonly UserManager<IdentityUser> _userManager;
    private readonly RoleManager<IdentityRole> _roleManager;

    public UserRoleManagementController(UserManager<IdentityUser> userManager, RoleManager<IdentityRole> roleManager)
    {
        _userManager = userManager;
        _roleManager = roleManager;
    }

    public IActionResult Index()
    {
        var users = _userManager.Users.ToList();
        ViewBag.UserManager = _userManager;
        ViewBag.Roles = _roleManager.Roles.ToList();
        return View(users);
    }

    public async Task<IActionResult> Edit(string userId)
    {
        var user = await _userManager.FindByIdAsync(userId);
        if (user == null) return NotFound();

        var userRoles = await _userManager.GetRolesAsync(user);
        var roles = _roleManager.Roles.Select(r => r.Name).ToList();

        ViewBag.Roles = roles;
        ViewBag.UserRoles = userRoles;

        return View(user);
    }

    [HttpPost]
    public async Task<IActionResult> Edit(string userId, string[] selectedRoles)
    {
        var user = await _userManager.FindByIdAsync(userId);
        if (user == null) return NotFound();

        var userRoles = await _userManager.GetRolesAsync(user);
        var result = await _userManager.RemoveFromRolesAsync(user, userRoles);

        if (!result.Succeeded) return View(user);

        result = await _userManager.AddToRolesAsync(user, selectedRoles);

        if (!result.Succeeded) return View(user);

        return RedirectToAction(nameof(Index));
    }
}
