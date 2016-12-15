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

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import it.polimi.dima.roarify.server.dao.MessageDAO;
import it.polimi.dima.roarify.server.dao.MessageDAOImpl;
import it.polimi.dima.roarify.server.model.Message;

public class ShowMessagesServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		

		
		MessageDAO dao = MessageDAOImpl.getInstance();
	
		
	
		
		List<Message> messages = new ArrayList<Message>();
		messages = dao.listMessages();
		System.out.println(""+messages.size());
		
		
		req.getSession().setAttribute("messages", new ArrayList<Message>(messages));
		

	
		
		RequestDispatcher view = req.getRequestDispatcher("showMessages.jsp");
		view.forward(req, resp);
			
		
	}


}
