import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineNumberListener implements HttpSessionListener {
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext application = se.getSession().getServletContext();

        Integer number=(Integer)application.getAttribute("number");
        if(number==null){
            number=1;
        }
        number++;
        application.setAttribute("number",number);
        System.out.println("离线一位用户");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext application = se.getSession().getServletContext();

        Integer number=(Integer)application.getAttribute("number");
        if(number==null){
            number=0;
        }
        number++;
        application.setAttribute("number",number);
        System.out.println("在线一位用户");
    }
}
