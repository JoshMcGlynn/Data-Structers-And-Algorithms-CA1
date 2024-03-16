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
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class musicManager {
    private Stack<Song> likedSongs; //stack to hold user's liked songs  -  https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
    private Queue<Song> rapPlaylist; //Queue for rap playlist  -  https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html  - https://www.programiz.com/java-programming/queue
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
    
    
    
    public Stack<Song> getLikedSongs() {
        return likedSongs; // This returns the list of liked songs
    }
    
    //gets the rap playlist queue
    public Queue<Song> getRapPlaylist(){
        return rapPlaylist;
    }
    
    //gets the jazz playlist queue
    public Queue<Song> getJazzPlaylist(){
        return jazzPlaylist;
    }
    
    //moves the last liked song to the corresponding genre playlist  -  -  https://www.delftstack.com/howto/java/stack-pop-push-java/
    public void moveLastLikedSongToGenrePlaylist() {
        if (!likedSongs.empty()) {
            Song lastLikedSong = likedSongs.pop();
            String genre = lastLikedSong.getGenre().trim().toLowerCase(); //trims the white space also as it was causing errors
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
    
    //function to search across playlists instead of only through liked songs 
    public void searchPlaylist(Queue<Song> playlist, String query, List<Song> results){
        for (Song song : playlist){
            if (song.matches(query)){
                results.add(song);
            }
        }
    }
    
    //searches for songs that match the given query from the user  
    public List<Song> searchSongs(String query) {
        List<Song> results = new ArrayList<>();
        for (Song song : likedSongs){
            if(song.matches(query)){
                results.add(song);
            }
        }
        //continues search in rap and jazz playlists
        searchPlaylist(rapPlaylist, query, results);
        searchPlaylist(jazzPlaylist, query, results);
        return results;
    }
    
    //remove song from rap playlist
    public void removeSongFromRapPlaylist(){
        if(!rapPlaylist.isEmpty()){
            rapPlaylist.remove(); 
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
    
    //clear entire playlists
    public void clearRapPlaylist(){
        rapPlaylist.clear();
    }
    
    public void clearJazzPlaylist(){
        jazzPlaylist.clear();
    }
    
    
}