
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse) servletResponse;

        String uri = httpRequest.getRequestURI();
        if (uri.endsWith("login.jsp") || uri.endsWith("login")) {
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }
        String username=(String) httpRequest.getSession().getAttribute("password");
        if(username==null){
            httpResponse.sendRedirect("login");
            return;
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
