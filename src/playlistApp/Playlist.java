/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playlistApp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author joshm
 */
public class Playlist {
    private String name;
    private List<Song> songs;
    private boolean isRepeat;
    
    public Playlist(String name){
        this.name = name;
        this.songs = new ArrayList<>();
        this.isRepeat = false;
    }
    
    public void addSong(Song song){
        songs.add(song);
    }
    
    public void removeSong(Song song){
        songs.remove(song);
    }
    
    public void setRepeat(boolean repeat){
        isRepeat = repeat;
    }
    
    public int getSongCount(){
        return songs.size();
    }
    
    
    
}

