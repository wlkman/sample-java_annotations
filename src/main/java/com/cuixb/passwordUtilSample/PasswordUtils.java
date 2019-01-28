package com.cuixb.passwordUtilSample;

public class PasswordUtils {
    @MyPasswordAnnotation.UseCases(id = "47", description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @MyPasswordAnnotation.UseCases(id = "48")
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
