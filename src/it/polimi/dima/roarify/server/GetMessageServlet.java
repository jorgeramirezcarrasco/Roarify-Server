package it.polimi.dima.roarify.server;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.gson.Gson;

import it.polimi.dima.roarify.server.dao.MessageDAO;
import it.polimi.dima.roarify.server.dao.MessageDAOImpl;
import it.polimi.dima.roarify.server.model.Message;

public class GetMessageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String id = req.getParameter("id");
		
		MessageDAO dao = MessageDAOImpl.getInstance();
		
		Message message = dao.getById((Long.parseLong(id)));
		
		resp.setContentType("application/json");
		
		String jsonMessage = new Gson().toJson(message);
		resp.getWriter().println(jsonMessage);
		
	}	
}