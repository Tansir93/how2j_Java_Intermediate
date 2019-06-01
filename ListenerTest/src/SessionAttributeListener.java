import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("sessionadd");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("sessionremoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("sessionreplaced");
    }
}
