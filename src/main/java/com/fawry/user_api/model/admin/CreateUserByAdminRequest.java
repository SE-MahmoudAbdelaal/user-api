package com.fawry.user_api.model.admin;

import com.fawry.user_api.entity.enums.Gender;
import com.fawry.user_api.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserByAdminRequest {

    @NotNull(message = "First name is required")
    @Size(max = 50, message = "First name must be less than or equal to 50 characters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(max = 50, message = "Last name must be less than or equal to 50 characters")
    private String lastName;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "\\d{10,15}", message = "Phone number should be between 10 and 15 digits")
    private String phone;

    @Size(max = 255, message = "Photo URL must be less than or equal to 255 characters")
    private String photo;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    private String password;

    @NotNull(message = "Role is required")
    private Role role;

    @NotNull(message = "Gender is required")
    private Gender gender;

}