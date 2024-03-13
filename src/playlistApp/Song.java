/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistApp;

/**
 *
 * @author joshm
 */
public class Song {
    private String title;
    private String artist;
    private String genre;
    
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
    
    @Override
    public String toString(){
        return title + " by " + artist + " [" +genre + "]";
    }
    
}

    
