package it.polimi.dima.roarify.server;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.polimi.dima.roarify.server.dao.MessageDAO;
import it.polimi.dima.roarify.server.dao.MessageDAOImpl;
import it.polimi.dima.roarify.server.model.Message;

public class GetNearMessagesServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		Double lat = Double.parseDouble(req.getParameter("lat"));
		Double lon = Double.parseDouble(req.getParameter("long"));
		
		Double lonSup = lon+1;
		Double lonInf = lon-1;
		
		MessageDAO dao = MessageDAOImpl.getInstance();
		
		List <Message> messages = dao.getNearMessages(lat, lon);
		List <Message> filterMessages = new ArrayList<Message>();

		
		for(int i=0;i<messages.size();i++){
			if(messages.get(i).getLon()<=lonSup &&messages.get(i).getLon()>=lonInf ){
					filterMessages.add(messages.get(i));
				
					}
				}


		String jsonMessages = new Gson().toJson(filterMessages);
		
		resp.setContentType("application/json");
		
		resp.getWriter().println(jsonMessages);

	}	
}
