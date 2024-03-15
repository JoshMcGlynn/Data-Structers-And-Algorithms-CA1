/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package playlistApp;

/**
 *
 * @author joshm
 */
public class playlistApp {

    /**
     * @param args the command line arguments
     */    public static void main(String[] args) {
         
           GUI myGUI = new GUI();
           myGUI.setVisible(true);
         
           musicManager manager = new musicManager();
           
           Song song1 = new Song("Song Title 1", "Artist 1", "Genre A");
           manager.addSongToLiked(song1);
           
           manager.moveLastLikedSongToGenrePlaylist();
           
           manager.printAllPlaylists();
    }
    
}
