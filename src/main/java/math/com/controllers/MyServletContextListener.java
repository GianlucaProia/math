package math.com.controllers;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    /** The servlet context with which we are associated. */
    private ServletContext context = null;
    Thread t1;

    @SuppressWarnings("deprecation")
	public void contextDestroyed(ServletContextEvent event) {
        t1.stop();
    	log("Context destroyed");
        this.t1 = null;
    	//this.context = null;
    }

    public void contextInitialized(ServletContextEvent event) {

    		this.t1 = new Thread(new MyClass ());
    		this.t1.start();
    	
        //this.context = event.getServletContext();
        log("Context initialized");
    }

    private void log(String message) {
        if (context != null) {
            context.log("MyServletContextListener: " + message);
        } else {
            System.out.println("MyServletContextListener: " + message);
        }
    }
}