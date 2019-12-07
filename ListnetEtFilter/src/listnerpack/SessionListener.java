package listnerpack;

import javax.servlet.annotation.WebListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	
	private int counterVisiter = 0;

    /**
     * Default constructor. 
     */
    public SessionListener() {    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	synchronized(this){
    		counterVisiter++;
    		System.out.println("Le nombre de visiteur est :"+counterVisiter);
    	}
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public synchronized void sessionDestroyed(HttpSessionEvent se)  { 
    		counterVisiter-- ;
    		System.out.println("Le nombre de visiteur est :"+counterVisiter);
    }
	
}
