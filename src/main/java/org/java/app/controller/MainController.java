package org.java.app.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.java.app.model.Movie;
import org.java.app.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;


@Controller
public class MainController {
	
	 @GetMapping("/")
     public String index(Model model) {
        
        String name = "Davide";
        String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.";
        
        model.addAttribute("name", name);
        model.addAttribute("description", description);

        return "home";
     }
 
 
	 private List<Movie> getBestMovies() {
		 
	    List<Movie> movies = new ArrayList<>();
	    
	    movies.add(new Movie(1, "Terminator", "no-image.jpg"));
	    movies.add(new Movie(2, "Ad Astra", "no-image.jpg"));
	    movies.add(new Movie(3, "Interstellar", "no-image.jpg"));
	    movies.add(new Movie(4, "Il sopravvissuto" , "no-image.jpg"));
	    
	    return movies;
	 }

	 private List<Song> getBestSongs() {
		 
	    List<Song> songs = new ArrayList<>();
	    
	    songs.add(new Song(1, "Hey Ya" , "no-image.jpg"));
	    songs.add(new Song(2, "I'm outta love" , "no-image.jpg"));
	    songs.add(new Song(3, "Sex bomb" , "no-image.jpg"));
	    songs.add(new Song(7, "It's my life" , "no-image.jpg"));
	    
	    return songs;
	 }
	
	
	

	 @GetMapping("/movies")
	 public String getMovies(Model model) {
		 
	    List<Movie> movies = getBestMovies();
	     
	    model.addAttribute("movies", movies);
	    
	    return "movies";
	 }
	 

	 @GetMapping("/songs")
	 public String getSongs(Model model) {
		 
	    List<Song> songs = getBestSongs();
	    model.addAttribute("songs", songs);
	    
	    return "songs";
	 }
	 
	 
	 @GetMapping("/movies/{id}")
	    public String getMovieTitle(@PathVariable int id, Model model) {
	        List<Movie> movies = getBestMovies();
	        
	        
	        Movie selectedMovie = null;
	        for (Movie movie : movies) {
	            if (movie.getId() == id) {
	                selectedMovie = movie;
	                break;
	            }
	        }
	           	
        	model.addAttribute("selectedMovie", selectedMovie);
        	 
	        return "movieShow";
	    }
	 
	 @GetMapping("/songs/{id}")
	    public String getSongTitle(@PathVariable int id, Model model) {
	        List<Song> songs = getBestSongs();
	        
	        
	        Song selectedSong = null;
	        for (Song song : songs) {
	            if (song.getId() == id) {
	            	selectedSong = song;
	                break;
	            }
	        }
	           	
     	model.addAttribute("selectedSong", selectedSong);
     	 
	        return "songShow";
	    }
	 
	  

}
