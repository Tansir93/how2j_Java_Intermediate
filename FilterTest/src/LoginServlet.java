import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");


        if(password!=null&&password.equals("root")){
            req.getSession().setAttribute("password", password);
            resp.sendRedirect("welcome.jsp");
        }
        else{
            resp.sendRedirect("login.jsp");
        }
    }
}
