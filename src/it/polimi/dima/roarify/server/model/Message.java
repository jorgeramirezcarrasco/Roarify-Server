package it.polimi.dima.roarify.server.model;

import java.io.Serializable;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String text;
	private Double lat;
	private Double lon;
	private String userId;
	
	public Message(String title, String text, Double lat, Double lon,  String userId){
		
		this.title = title; 
		this.text = text;
		this.lat = lat;
		this.lon = lon;
		this.userId = userId;
		
	}
	
	public Long getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public String getText(){
		return text;		
	}
	public Double getLon(){
		return lon;
	}
	public Double getLat(){
		return lat;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setText(String text){
		this.text= text;
	}
	public void setLat(Double lat){
		this.lat = lat;
	}
	public void setLon(Double lon){
		this.lon = lon;
	}
	public String getUserId(){
		return userId;		
	}
	public void setUserId(String userId){
		this.userId= userId;
	}
}
