using System.ComponentModel.DataAnnotations;
using System.Text.RegularExpressions;

namespace IoTApp.Utility
{

    public class LetterAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            if (value != null)
            {
                var stringValue = value.ToString();
                var regex = new Regex(@"^[a-zA-Z]+$");

                if (!regex.IsMatch(stringValue))
                {
                    return new ValidationResult("The field must contain only letters.");
                }
            }
            return ValidationResult.Success;
        }
    }
}
