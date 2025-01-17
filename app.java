import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private static class LoginRequest {
        public String username;
        public String password;
    }
 
    private static class LoginResponse {
        public boolean success;
        public String message;
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        LoginRequest loginRequest = mapper.readValue(request.getInputStream(), LoginRequest.class);
 
        LoginResponse loginResponse = new LoginResponse();
        if ("user".equals(loginRequest.username) && "password".equals(loginRequest.password)) {
            loginResponse.success = true;
            loginResponse.message = "Login successful!";
        } else {
            loginResponse.success = false;
            loginResponse.message = "Invalid username or password.";
        }
 
        response.setContentType("application/json");
        response.getWriter().write(mapper.writeValueAsString(loginResponse));
    }
}