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

public class musicManager {
    private List<Song> likedSongs; //list to hold user's liked songs
    private List<Playlist> playlists; //List of different playlists


    //constructor to initialise musicManager with empty lists for liked songs and list of playlists
    public musicManager(){
        this.likedSongs = new ArrayList<>();
        this.playlists = new ArrayList<>();
        this.playlists.add(new Playlist("Rap"));
        this.playlists.add(new Playlist("Pop"));
    }
    
    //Adds a song to liked songs list
    public void addSongToLiked(Song song) {
        likedSongs.add(song);
    }
    
    //adds a song to a genre specific playlist. If the playlist with the given name exists, the song will be added to it
    public void addSongToGenrePlaylist(Song song, String genreName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(genreName)) {
                playlist.addSong(song);
                break;
            }
        }
    }
    
    //moves the last liked song to the corresponding genre playlist
    public void moveLastLikedSongToGenrePlaylist() {
        if (!likedSongs.isEmpty()) {
            Song lastLikedSong = likedSongs.remove(likedSongs.size() - 1);
            addSongToGenrePlaylist(lastLikedSong, lastLikedSong.getGenre());
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
    
    //removes a song from a specified playlist 
    public void removeSongFromPlaylist(Song song, String playlistName) {
        //find playlist by name
        Playlist playlist = findPlaylistByName(playlistName);
        if (playlist != null) {
            //if found, remove from playlist
            playlist.removeSong(song);
        }
    }
    
    //finds a playlist by name
    public Playlist findPlaylistByName(String name) {
        for (Playlist playlist : playlists) {
            //check if playlists name matches the given name
            if (playlist.getName().equalsIgnoreCase(name)) {
                return playlist; //return the matching playlist
            }
        }
        return null; //return null if nothing is found
    }
    
    //prints all playlists and their songs to the console
    public void printAllPlaylists() {
        for (Playlist playlist : playlists) {
            //print each playlist's details
            System.out.println(playlist);
        }
    }
    
}