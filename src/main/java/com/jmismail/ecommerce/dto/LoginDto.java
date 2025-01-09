package com.jmismail.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class LoginDto {

    @NotNull(message = "Required")
    @Email(message = "Not a valid Email")
    private String email;

    @NotNull(message = "Required")
    @Length(min = 8, message = "Should have at least 8 characters")
    private String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
