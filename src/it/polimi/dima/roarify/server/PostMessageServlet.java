package it.polimi.dima.roarify.server;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.http.*;

import it.polimi.dima.roarify.server.dao.MessageDAO;
import it.polimi.dima.roarify.server.dao.MessageDAOImpl;
import it.polimi.dima.roarify.server.model.Message;

public class PostMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L; //Serializes objects through HTTP.
	
	public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException{ // Uploads the content of a Post-It
		
				
		 // Checks if the parameters are or not empty.
		String text = checkNull(req.getParameter ("text"));
		String userId  = checkNull(req.getParameter("userId"));
		String userName  = checkNull(req.getParameter("userName"));
		String lat = checkNull(req.getParameter("lat"));
		String lon  = checkNull(req.getParameter("long"));
		String time = checkNull(req.getParameter("time"));
		String isParent  = checkNull(req.getParameter("isParent"));
		String parentId = checkNull(req.getParameter("parentId"));
		
		MessageDAO dao = MessageDAOImpl.getInstance();
		dao.add(text,userId,userName,Double.parseDouble(lat),Double.parseDouble(lon),time,isParent,parentId);
		
		
	}
	
	private String checkNull (String s){ 
		if (s == null){ 
			return "This field should not be empty";
		}
		return s;
	}
	
}
