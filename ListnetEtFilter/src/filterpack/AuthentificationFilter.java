package filterpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class AuthentificationFilter implements Filter {
	
    public AuthentificationFilter() { super();}

	public void destroy() { }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		String login= request.getParameter("user");
		String motpass = request.getParameter("motpasse");
		if(login.equals("Scotte") && motpass.equals("Info4")) {	
			chain.doFilter(request, response);// pass the request along the filter chain
		}
		else {
			response.setContentType("text/html");
			PrintWriter affiche= response.getWriter();
			affiche.println("<b>Sorry username or password error !</b></br>");  
		    RequestDispatcher rqdispa=request.getRequestDispatcher("/index.html");  
		    rqdispa.include(request, response);  
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
