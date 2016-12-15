package it.polimi.dima.roarify.server;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	
	
	
private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String admin = "admin";
		String name = checkNull(req.getParameter("name"));
		String password= checkNull(req.getParameter("password"));
		String menserror = req.getParameter("option");
		
		if (name.equals("admin")&&password.equals("lannister") ){

			req.getSession().setAttribute("alert", false);	
			RequestDispatcher view = req.getRequestDispatcher("RoarifyApp.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	else{
			
			if(name.equals("")){
				req.getSession().setAttribute("alert", false);	
				
			}else{
				
				req.getSession().setAttribute("alert", true);	
			}
			
			
			RequestDispatcher view = req.getRequestDispatcher("Login.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	private String checkNull(String s) {
		if (s== null){
			return "";
		}
		return s;
	}

	
	
	

}
