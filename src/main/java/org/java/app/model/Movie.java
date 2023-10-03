package org.java.app.model;

public class Movie {
	
    private int id;
    private String title;
    private String image;
    
    
    public Movie(int id, String title, String image) {
    	setId(id);
    	setTitle(title);
    	setImage(image);
    }
    
    
    
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
     
}
