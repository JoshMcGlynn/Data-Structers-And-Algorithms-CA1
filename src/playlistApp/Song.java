/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistApp;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
/**
 *
 * @author joshm
 */
public class Song {
    private String title; //song title
    private String artist; //artist of song
    private String genre; //song genre
    
    //constructor initialises song with title, artist and genre
    public Song(String title, String artist, String genre){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }
    
    //Getters and Setters
    public String getTitle(){
        return title;
    }
    
    public String getArtist(){
        return artist;
    }
    
    public String getGenre(){
        return genre;
    }
    
    //checks if the song matches the search query
    public boolean matches(String query){
        query = query.toLowerCase();
        return title.toLowerCase().contains(query) || artist.toLowerCase().contains(query) || genre.toLowerCase().contains(query);  //searches all fields, title, artist and genre
    }
    
    // a toString method to get and combine the songs details and print out as string
    @Override
    public String toString(){
        return title + " by " + artist + " [" +genre + "]";
    }
    
}

    
