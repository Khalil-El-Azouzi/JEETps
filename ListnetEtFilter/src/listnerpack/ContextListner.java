package listnerpack;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListner
 *
 */
@WebListener
public class ContextListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListner() {

    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	sce.getServletContext().log("###### Arrêt de l'application ######");

    }
    
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	sce.getServletContext().log("###### Lancement de l'application ######");
    }
	
}
