import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("add");
    }
    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("removed");
    }
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("replaced");
    }
}
