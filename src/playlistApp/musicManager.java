/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistApp;

/**
 *
 * @author joshm
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class musicManager {
    private Stack<Song> likedSongs; //list to hold user's liked songs
    private Queue<Song> rapPlaylist;
    private Queue<Song> jazzPlaylist;


    //constructor to initialise musicManager with empty lists for liked songs and list of playlists
    public musicManager(){
        likedSongs = new Stack<>();
        rapPlaylist = new LinkedList<>();
        jazzPlaylist = new LinkedList<>();
    }
    
    //Adds a song to liked songs list
    public void addSongToLiked(Song song) {
        likedSongs.push(song);
    }
    
    
    
    public List<Song> getLikedSongs() {
        return this.likedSongs; // This returns the list of liked songs
    }
    
    public Queue<Song> getRapPlaylist(){
        return rapPlaylist;
    }
    
    public Queue<Song> getJazzPlaylist(){
        return jazzPlaylist;
    }
    
    //moves the last liked song to the corresponding genre playlist
    public void moveLastLikedSongToGenrePlaylist() {
        if (!likedSongs.empty()) {
            Song lastLikedSong = likedSongs.pop();
            String genre = lastLikedSong.getGenre().trim().toLowerCase();
            switch (genre){
                case "rap":
                    rapPlaylist.add(lastLikedSong);
                    break;
                case "jazz":
                    jazzPlaylist.add(lastLikedSong);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "The genre " + genre + " does not have a playlist");
                    //this will put the song back into the liked songs stack if a playlist could not be found for it 
                    likedSongs.push(lastLikedSong);
                    break;
            }
        }
    }
    //searches for songs matching the query across all liked songs, and looks for matches in title, artist or genre
    public List<Song> searchSongs(String query) {
        return likedSongs.stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(query) ||
                        song.getArtist().equalsIgnoreCase(query) ||
                        song.getGenre().equalsIgnoreCase(query))
                .collect(Collectors.toList());
    }
    
    //remove song from rap playlist
    public void removeSongFromRapPlaylist(){
        if(!rapPlaylist.isEmpty()){
            rapPlaylist.remove(); //removes the head of the queue
        }else{
            JOptionPane.showMessageDialog(null, "The rap playlist is already empty.");
        }
    }
    
    //remove song from jazz playlist
    public void removeSongFromJazzPlaylist(){
        if(!jazzPlaylist.isEmpty()){
            jazzPlaylist.remove();
        }else{
            JOptionPane.showMessageDialog(null, "The jazz playlist is already empty");
        }
    }
    
    public void clearRapPlaylist(){
        rapPlaylist.clear();
    }
    
    public void clearJazzPlaylist(){
        jazzPlaylist.clear();
    }
    
    
}