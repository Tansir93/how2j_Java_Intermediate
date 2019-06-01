import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    public HelloServlet(){
        System.out.println("实例化");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
        super.init();

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("调用service");
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name= req.getParameter("name");
       String password= req.getParameter("password");

        resp.setContentType("text/html; charset=UTF-8");
        if(password!="root"){
            //resp.sendRedirect("/WEB-INF/fail.html");//客户端无法访问到
            req.getRequestDispatcher("/WEB-INF/fail.html").forward(req, resp);
        }

        req.getRequestDispatcher("/WEB-INF/success.html").forward(req, resp);
    }
}
