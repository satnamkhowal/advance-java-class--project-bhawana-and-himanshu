
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Dummy User Data
        String name = "Admin User";
        String email = "admin@gmail.com";
        String mobile = "9876543210";
        String role = "Administrator";
        String gender = "Male";

        // Dummy Dashboard Statistics
        int totalStudents = 150;
        int totalCourses = 12;
        int totalProjects = 45;
        int totalUsers = 120;

        // HTML Start
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");

        out.println("<head>");

        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

        out.println("<title>MyPlatform Dashboard</title>");

        // CSS
        out.println("<style>");

        out.println("*{margin:0;padding:0;box-sizing:border-box;}");

        out.println("body{");
        out.println("font-family:Arial,sans-serif;");
        out.println("background:#EFF6FF;");
        out.println("color:#344054;");
        out.println("}");

        // Navbar
        out.println(".navbar{");
        out.println("background:#155EEF;");
        out.println("color:white;");
        out.println("padding:20px 5%;");
        out.println("display:flex;");
        out.println("justify-content:space-between;");
        out.println("align-items:center;");
        out.println("}");

        out.println(".navbar h2{font-size:24px;}");

        out.println(".navbar a{");
        out.println("background:white;");
        out.println("color:#155EEF;");
        out.println("padding:10px 20px;");
        out.println("text-decoration:none;");
        out.println("border-radius:6px;");
        out.println("font-weight:bold;");
        out.println("}");

        // Main Container
        out.println(".container{");
        out.println("width:90%;");
        out.println("max-width:1200px;");
        out.println("margin:40px auto;");
        out.println("}");

        // Welcome Section
        out.println(".welcome{");
        out.println("background:white;");
        out.println("padding:30px;");
        out.println("border-radius:12px;");
        out.println("margin-bottom:30px;");
        out.println("}");

        out.println(".welcome h1{");
        out.println("color:#155EEF;");
        out.println("margin-bottom:10px;");
        out.println("}");

        out.println(".welcome p{color:#667085;}");

        // Dashboard Cards
        out.println(".cards{");
        out.println("display:grid;");
        out.println("grid-template-columns:repeat(4,1fr);");
        out.println("gap:20px;");
        out.println("}");

        out.println(".card{");
        out.println("background:white;");
        out.println("padding:25px;");
        out.println("border-radius:12px;");
        out.println("box-shadow:0 5px 15px rgba(0,0,0,0.05);");
        out.println("transition:0.3s;");
        out.println("}");

        out.println(".card:hover{");
        out.println("transform:translateY(-5px);");
        out.println("}");

        out.println(".card h3{");
        out.println("font-size:15px;");
        out.println("color:#667085;");
        out.println("}");

        out.println(".card h1{");
        out.println("font-size:32px;");
        out.println("color:#155EEF;");
        out.println("margin-top:15px;");
        out.println("}");

        // Profile Section
        out.println(".profile{");
        out.println("background:white;");
        out.println("padding:30px;");
        out.println("border-radius:12px;");
        out.println("margin-top:30px;");
        out.println("}");

        out.println(".profile h2{");
        out.println("color:#155EEF;");
        out.println("margin-bottom:20px;");
        out.println("}");

        out.println(".profile p{");
        out.println("margin:15px 0;");
        out.println("font-size:16px;");
        out.println("}");

        // Footer
        out.println(".footer{");
        out.println("text-align:center;");
        out.println("padding:25px;");
        out.println("color:#667085;");
        out.println("}");

        // Responsive CSS
        out.println("@media(max-width:768px){");
        out.println(".cards{grid-template-columns:repeat(2,1fr);}");
        out.println("}");

        out.println("@media(max-width:480px){");
        out.println(".cards{grid-template-columns:1fr;}");
        out.println(".navbar h2{font-size:18px;}");
        out.println(".container{width:92%;}");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        // Body Start
        out.println("<body>");

        // Navbar
        out.println("<div class='navbar'>");

        out.println("<h2>MyPlatform</h2>");

        out.println("<a href='login.html'>Logout</a>");

        out.println("</div>");

        // Main Container
        out.println("<div class='container'>");

        // Welcome
        out.println("<div class='welcome'>");

        out.println("<h1>Welcome, " + name + "!</h1>");

        out.println("<p>Welcome to your dashboard. "
                + "Here you can manage your platform.</p>");

        out.println("</div>");

        // Statistics
        out.println("<div class='cards'>");

        out.println("<div class='card'>");
        out.println("<h3>Total Students</h3>");
        out.println("<h1>" + totalStudents + "</h1>");
        out.println("</div>");

        out.println("<div class='card'>");
        out.println("<h3>Total Courses</h3>");
        out.println("<h1>" + totalCourses + "</h1>");
        out.println("</div>");

        out.println("<div class='card'>");
        out.println("<h3>Total Projects</h3>");
        out.println("<h1>" + totalProjects + "</h1>");
        out.println("</div>");

        out.println("<div class='card'>");
        out.println("<h3>Total Users</h3>");
        out.println("<h1>" + totalUsers + "</h1>");
        out.println("</div>");

        out.println("</div>");

        // User Profile
        out.println("<div class='profile'>");

        out.println("<h2>My Profile</h2>");

        out.println("<p><b>Name:</b> " + name + "</p>");

        out.println("<p><b>Email:</b> " + email + "</p>");

        out.println("<p><b>Mobile:</b> " + mobile + "</p>");

        out.println("<p><b>Gender:</b> " + gender + "</p>");

        out.println("<p><b>Role:</b> " + role + "</p>");

        out.println("</div>");

        // Footer
        out.println("<div class='footer'>");

        out.println("<p>&copy; 2026 MyPlatform. All Rights Reserved.</p>");

        out.println("</div>");

        out.println("</div>");

        // HTML End
        out.println("</body>");
        out.println("</html>");

    }
}
	