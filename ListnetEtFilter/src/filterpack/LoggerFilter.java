package filterpack;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggerFilter
 */
@WebFilter("/*")//si on fait @WebFilter("/LoggerFilter"), il nous faut faire une declaration de filtre dans le fichier web.xml
public class LoggerFilter implements Filter {
	
	private Logger log = Logger.getLogger("LoggerFilter");

    public LoggerFilter() {
    	log.log(Level.INFO, "Création du filtre");
    }

	public void destroy() {
		log.log(Level.INFO, "Destruction du filtre");		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
			HttpServletRequest httpRequest= (HttpServletRequest) request;
			String host = httpRequest.getRemoteHost();
			String url = httpRequest.getRequestURI().toString();
			log.log(Level.INFO,"L'hôte ["+host+"] fait une requête sur ["+url+"]");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log.log(Level.INFO, "Initialisation du filtre");
	}

}
