import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String artist, albumName;
    private ArrayList<Song> songs;

    public Album(String artist, String albumName) {
        this.artist = artist;
        this.albumName = albumName;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String name, double duration) {
        if (findSong(name) == null) {
            return songs.add(new Song(name, duration));
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if(index >= 0 && index < songs.size()){
            return playlist.add(this.songs.get(index));
        }
        System.out.println("Track number " + trackNumber + " does not exist");
        return false;
    }

    public boolean addToPlayList(String name, LinkedList<Song> playlist) {
        Song checkedSong = findSong(name);
        if (checkedSong == null) {
            System.out.println("The song " + name + " does not exist");
            return false;
        }
        return playlist.add(checkedSong);
    }

    private Song findSong(String name) {
        for(Song s : this.songs) {
            if (s.getSongName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
