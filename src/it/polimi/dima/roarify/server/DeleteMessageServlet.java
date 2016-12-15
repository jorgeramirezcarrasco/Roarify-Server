package it.polimi.dima.roarify.server;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.polimi.dima.roarify.server.dao.MessageDAO;
import it.polimi.dima.roarify.server.dao.MessageDAOImpl;
import it.polimi.dima.roarify.server.model.Message;



public class DeleteMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String id = req.getParameter("id");
		
		MessageDAO dao = MessageDAOImpl.getInstance();
		
		dao.remove(Long.parseLong(id));
		
	}
	
	

	
}
