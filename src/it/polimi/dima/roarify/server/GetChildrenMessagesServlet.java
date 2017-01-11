package it.polimi.dima.roarify.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.polimi.dima.roarify.server.dao.MessageDAO;
import it.polimi.dima.roarify.server.dao.MessageDAOImpl;
import it.polimi.dima.roarify.server.model.Message;

public class GetChildrenMessagesServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String id = (req.getParameter("id")).toString();

		
		MessageDAO dao = MessageDAOImpl.getInstance();
		
		List <Message> messages = dao.getChildrenMessages(id);
		

		String jsonMessages = new Gson().toJson(messages);
		
		resp.setContentType("application/json");
		
		resp.getWriter().println(jsonMessages);

	}	
}
