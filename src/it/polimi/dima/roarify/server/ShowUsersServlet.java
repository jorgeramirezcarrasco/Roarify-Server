package it.polimi.dima.roarify.server;
import javax.servlet.http.HttpServlet;

	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import it.polimi.dima.roarify.server.dao.MessageDAO;
	import it.polimi.dima.roarify.server.dao.MessageDAOImpl;
	import it.polimi.dima.roarify.server.model.Message;

	public class ShowUsersServlet extends HttpServlet {
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			

			
			MessageDAO dao = MessageDAOImpl.getInstance();
		
			
		
			
			List<String> users = new ArrayList<String>();
			users = dao.getUsers();
			System.out.println(""+users.size());
			
			
			req.getSession().setAttribute("users", new ArrayList<String>(users));
			

		
			
			RequestDispatcher view = req.getRequestDispatcher("showUsers.jsp");
			view.forward(req, resp);
				
			
		}


	}



