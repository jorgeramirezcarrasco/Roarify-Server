package it.polimi.dima.roarify.server.dao;

import java.util.List;

import it.polimi.dima.roarify.server.model.Message;

public interface MessageDAO {
	

	public void add(String text,String userId, String userName, Double lat, Double lon,String time);
	public void remove(long id);
	public Message getById(long id);
	public List<Message> getNearMessages(Double lat, Double lon);
	public List<Message> getUserMessages(String userId);
	public void editMessage(long id, String text, String time);
	public List<Message> listMessages();
	public List<String> getUsers();

}