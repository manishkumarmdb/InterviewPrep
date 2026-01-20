package org.example.securityjwt.controller;

import org.example.securityjwt.dto.LoginRequest;
import org.example.securityjwt.dto.LoginResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Hardcoded credentials for testing (replace with database in production)
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user123";

    @GetMapping("/login-form")
    public String loginForm() {
        return """
                <!DOCTYPE html>
                <html>
                <head><title>Login</title></head>
                <body>
                <h1>Login</h1>
                <form action="/api/auth/login" method="POST" enctype="application/x-www-form-urlencoded">
                    <label>Username:</label>
                    <input type="text" name="username" required><br><br>
                    <label>Password:</label>
                    <input type="password" name="password" required><br><br>
                    <button type="submit">Login</button>
                </form>
                <hr>
                <h3>Test Credentials:</h3>
                <p><strong>Admin:</strong> admin / admin123</p>
                <p><strong>User:</strong> user / user123</p>
                </body>
                </html>
                """;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        if (ADMIN_USERNAME.equals(request.getUsername()) && ADMIN_PASSWORD.equals(request.getPassword())) {
            return new LoginResponse(
                    true,
                    "Login successful",
                    "ADMIN",
                    "admin-token-placeholder"
            );
        } else if (USER_USERNAME.equals(request.getUsername()) && USER_PASSWORD.equals(request.getPassword())) {
            return new LoginResponse(
                    true,
                    "Login successful",
                    "USER",
                    "user-token-placeholder"
            );
        } else {
            return new LoginResponse(
                    false,
                    "Invalid username or password",
                    null,
                    null
            );
        }
    }

    @PostMapping("/register")
    public LoginResponse register(@RequestBody LoginRequest request) {
        return new LoginResponse(
                true,
                "User registered successfully",
                "USER",
                null
        );
    }
}
