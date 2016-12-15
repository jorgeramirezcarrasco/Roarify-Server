package it.polimi.dima.roarify.server;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.polimi.dima.roarify.server.dao.MessageDAO;
import it.polimi.dima.roarify.server.dao.MessageDAOImpl;
import it.polimi.dima.roarify.server.model.Message;

public class UpdateMessageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String idMessage = checkNull(req.getParameter("id"));
		String title = checkNull(req.getParameter("title")); 
		String text = checkNull(req.getParameter ("text"));
		long id = Long.parseLong(idMessage);
		MessageDAO dao = MessageDAOImpl.getInstance();
		dao.editMessage(id, title, text);

		
	}
	
	private String checkNull (String s){ 
		if (s == null){ 
			return "This field should not be empty";
		}
		return s;
	}

}
