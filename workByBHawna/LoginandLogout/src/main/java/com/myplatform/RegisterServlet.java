
package com.myplatform;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String confirmPassword =
            request.getParameter("confirmPassword");

        String terms = request.getParameter("terms");

        // Empty field validation
        if (name == null || email == null ||
            mobile == null || gender == null ||
            password == null || confirmPassword == null ||
            name.trim().isEmpty() ||
            email.trim().isEmpty() ||
            mobile.trim().isEmpty() ||
            password.isEmpty() ||
            confirmPassword.isEmpty()) {

            showMessage(response,
                "Please fill all required fields.", false);
            return;
        }

        name = name.trim();
        email = email.trim().toLowerCase();
        mobile = mobile.trim();

        // Name validation
        if (name.length() > 100) {
            showMessage(response, "Name is too long.", false);
            return;
        }

        // Email validation
        if (!Pattern.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                email)) {

            showMessage(response,
                "Please enter a valid email address.", false);
            return;
        }

        // Mobile validation
        if (!Pattern.matches("[0-9]{10,15}", mobile)) {
            showMessage(response,
                "Please enter a valid mobile number.", false);
            return;
        }

        // Gender validation
        if (!gender.equals("Male") &&
            !gender.equals("Female") &&
            !gender.equals("Other")) {

            showMessage(response,
                "Please select a valid gender.", false);
            return;
        }

        // Password validation
        if (password.length() < 8 ||
            password.length() > 128) {

            showMessage(response,
                "Password must be 8 to 128 characters.", false);
            return;
        }

        // Confirm password
        if (!password.equals(confirmPassword)) {
            showMessage(response,
                "Password and Confirm Password do not match.",
                false);
            return;
        }

        // Terms validation
        if (!"accepted".equals(terms)) {
            showMessage(response,
                "Please accept Terms and Conditions.", false);
            return;
        }

        String sql =
            "INSERT INTO register " +
            "(full_name, email, mobile, gender, password) " +
            "VALUES (?, ?, ?, ?, ?)";

        try {
            String hashedPassword =
                PasswordUtil.hashPassword(password);

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps =
                     con.prepareStatement(sql)) {

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, mobile);
                ps.setString(4, gender);
                ps.setString(5, hashedPassword);

                int result = ps.executeUpdate();

                if (result > 0) {
                    showMessage(response,
                        "Account created successfully!",
                        true);
                } else {
                    showMessage(response,
                        "Registration failed. Please try again.",
                        false);
                }
            }

        } catch (SQLException e) {

            if ("23000".equals(e.getSQLState())) {
                showMessage(response,
                    "This email is already registered.",
                    false);
            } else {
                log("Database registration error", e);

                showMessage(response,
                    "Database error. Please check your connection.",
                    false);
            }

        } catch (Exception e) {

            log("Password hashing error", e);

            showMessage(response,
                "Something went wrong. Please try again.",
                false);
        }
    }

    private void showMessage(
            HttpServletResponse response,
            String message,
            boolean success) throws IOException {

        String color = success ? "#198754" : "#dc3545";

        String safeMessage = escapeHtml(message);

        response.getWriter().println(
            "<!DOCTYPE html>" +
            "<html><head>" +
            "<meta charset='UTF-8'>" +
            "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
            "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>" +
            "<title>MyPlatform</title></head>" +
            "<body class='bg-light'>" +
            "<div class='container mt-5'>" +
            "<div class='card shadow p-4 mx-auto' style='max-width:500px'>" +
            "<h3 style='color:" + color + "'>" +
            safeMessage + "</h3>" +
            (success
                ? "<a href='login.html' class='btn btn-primary mt-3'>Login Now</a>"
                : "<a href='register.html' class='btn btn-primary mt-3'>Go Back</a>") +
            "</div></div></body></html>"
        );
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }
}
