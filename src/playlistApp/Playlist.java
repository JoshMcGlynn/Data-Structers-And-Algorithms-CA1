/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistApp;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import javax.swing.JOptionPane;
/**
 *
 * @author joshm
 */

public class Playlist {
    private String name; //playlist name
    private LinkedList<Song> songs; //linked list to hold songs in playlist
    private boolean isRepeat; //indicates if playlist is set to repeat
    
    //constructor initialises playlist with name and empty list of songs
    public Playlist(String name){
        this.name = name;
        this.songs = new LinkedList<>();
        this.isRepeat = false;
    }
    
    //adds a song to the END of the playlist
    public void addSong(Song song){
        songs.addLast(song);
    }
    
    //removes a song from the playlist
    public void removeSong(Song song){
        songs.remove(song);
    }
    
    public boolean isRepeat(){
        return isRepeat;
    }
    
    //toggles the repeat flag for the playlist
    public void toggleRepeat(){
        this.isRepeat = !this.isRepeat;
    }
    
    public void setRepeat(boolean repeat){
        isRepeat = repeat;
    }
    
    //gets playlist name
    public String getName(){
        return name;
    }
    
    //gets playlist song count
    public int getSongCount(){
        return songs.size();
    }
    
    
    //searches for a song by title in the playlist 
    public Song searchSongByTitle(String title) {
    return songs.stream()
        .filter(song -> song.getTitle().equalsIgnoreCase(title))
        .findFirst()
        .orElse(null);
    }

    //prints all songs in the playlist to the console 
    public void printSongs() {
        songs.forEach(song -> System.out.println(song.toString()));
    }
    
    
    //returns the playlist in String, including song details, whether or not repeat is enabled and the total song count
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(name).append("\n");
        for (Song song : songs){
            sb.append(song).append("\n");
        }
        sb.append("Repeat: ").append(isRepeat ? "On" : "Off").append("\n");
        sb.append("Total Songs: ").append(getSongCount());
        return sb.toString();
    }
    
    
}

