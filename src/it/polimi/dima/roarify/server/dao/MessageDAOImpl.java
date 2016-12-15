package it.polimi.dima.roarify.server.dao;

import java.util.List;
import java.util.ArrayList;


import it.polimi.dima.roarify.server.model.Message;
import it.polimi.dima.roarify.server.dao.EMFService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class MessageDAOImpl implements MessageDAO {
	
	private static MessageDAOImpl instance;
	
	private MessageDAOImpl(){}
	
	public static MessageDAOImpl getInstance(){
		if(instance ==null){
			instance = new MessageDAOImpl();
		}
		return instance;
	}

	@Override
	public void add(String title, String text, Double lat, Double lon, String userId) {
		synchronized(this){
			EntityManager em = EMFService.get().createEntityManager();
			Message message = new Message(title, text, lat, lon, userId);
			em.persist(message);
			em.close();
		}

	}

	@Override
	public void remove(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Message message = em.find(Message.class, id);
			em.remove(message);
		} finally {
			em.close();
		}

	}

	@Override
	public Message getById(long id) {
		EntityManager em = EMFService.get().createEntityManager();

		 Message message = null;
		 try{
		  	 message = em.find(Message.class, id);
		 } finally {
			 em.close();
		 }
		  
		 return message;
	}

	@Override
	public List<Message> getNearMessages(Double lat, Double lon) {
		Double latSup = lat+1;
		Double latInf = lat-1;
	
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select n from Message n where n.lat >= :latInf AND n.lat <= :latSup");
		q.setParameter("latSup", latSup);
		q.setParameter("latInf", latInf);
		List<Message> messages= q.getResultList();
		if(messages == null){
			messages = new ArrayList<Message>();
		}
		
		return messages;
	}

	@Override
	public List<Message> getUserMessages(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select n from Message n where n.userId = :userId");
		q.setParameter("userId", userId);
		List<Message> messages= q.getResultList();
		if(messages == null){
			messages = new ArrayList<Message>();
		}
		
		return messages;
	}

	@Override
	public void editMessage(long id, String title, String text) {
		EntityManager em = EMFService.get().createEntityManager();

		EntityTransaction tx = em.getTransaction();
		try {
		        tx.begin();
		        Message message = em.find(Message.class, id);
		        message.setTitle(title);
		        message.setText(text);
		        em.persist(message);
		        tx.commit();
		} finally {
		        if (tx.isActive()) {
		                tx.rollback();
		        }
		}

	}

	@Override
	public List<Message> listMessages() {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select n from Message n");
	
		List<Message> notes= q.getResultList();
		if(notes == null){
			notes = new ArrayList<Message>();
		}
		
		return notes;
	}

	@Override
	public List<String> getUsers() {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select distinct n.userId from Message n");
	
		List<String> users= q.getResultList();
		if(users == null){
			users = new ArrayList<String>();
		}
		
		return users;
	}


}
