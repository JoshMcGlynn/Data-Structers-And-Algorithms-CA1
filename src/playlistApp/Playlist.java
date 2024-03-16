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
    }
    
    //adds a song to the END of the playlist
    public void addSong(Song song){
        songs.addLast(song);
    }
    
    //removes a song from the playlist
    public void removeSong(Song song){
        songs.remove(song);
    }
    
    
    //gets playlist name
    public String getName(){
        return name;
    }
    
    //gets playlist song count
    public int getSongCount(){
        return songs.size();
    }
    
    
    //prints all songs in the playlist to the console 
    public void printSongs() {
        songs.forEach(song -> System.out.println(song.toString()));
    }
    
    
    
}

