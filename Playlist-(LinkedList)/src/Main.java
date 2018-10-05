import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static ArrayList<Album> albumList = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Elvis Presley", "Aloha");
        album.addSong("Aloha", 3.5);
        album.addSong("Can't help falling in love", 2.8);
        album.addSong("Jailhouse Rock", 3.7);
        album.addSong("Hound Dog", 4.0);
        album.addSong("Suspicious Mind", 4.2);
        album.addSong("Burning Love", 3.8);
        album.addSong("Unchained Melody", 4.2);
        albumList.add(album);

        album = new Album("Eminem", "Kamikaze");
        album.addSong("The Ringer",5.5);
        album.addSong("Lucky You (feat. Joyner Lucas)",4.05);
        album.addSong("Stepping Stone",5.10);
        album.addSong("Not Alike (feat. Royce Da 5'9",4.48);
        album.addSong("Fall",4.22);
        album.addSong("Good Guy (feat. Jessie Reyez",2.22);
        album.addSong("Venom",4.5);
        album.addSong("Kamikaze",3.36);
        album.addSong("Greatest",3.47);
        albumList.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albumList.get(0).addToPlayList("Unchained Melody", playList);
        albumList.get(0).addToPlayList("Burning Love", playList);
        albumList.get(0).addToPlayList("Speed Demon", playList);
        albumList.get(0).addToPlayList(5, playList);
        albumList.get(0).addToPlayList(2, playList);

        albumList.get(1).addToPlayList("Fall", playList);
        albumList.get(1).addToPlayList("Slim Shady", playList);
        albumList.get(1).addToPlayList(1, playList);
        albumList.get(1).addToPlayList(11, playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;


        ListIterator<Song> it = playlist.listIterator();
        if (playlist.isEmpty()) {
            System.out.println("No song in playlist");
            return;
        }
        else {
            System.out.println("Now playing " + it.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit  = true;
                    break;

                case 1:
                    if(!forward) {
                        if (it.hasNext()) {
                            it.next();
                        }
                        forward = true;
                    }
                    if(it.hasNext()) {
                        System.out.println("Now playing " + it.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (it.hasPrevious()) {
                            it.previous();
                        }
                        forward = false;
                    }
                    if(it.hasPrevious()){
                        System.out.println("Now playing " + it.previous().toString());
                    } else {
                        System.out.println("You are already at the start of the playlist");
                        forward = true;
                    }
                    break;

                case 3:
                    if(forward) {
                        if (it.hasPrevious()) {
                            System.out.println("Now playing " + it.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    } else {
                        if (it.hasNext()) {
                            System.out.println("Now playing " + it.next().toString());
                            forward = false;
                        } else {
                            System.out.println("We are already at the end of the playlist");
                        }
                    }
                    break;

                case 4:
                    printList(playlist);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playlist.size() > 0) {
                        it.remove();
                        if(forward) {
                            System.out.println("Now playing " + it.next().toString());
                        } else {
                            System.out.println("Now playing " + it.previous().toString());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - next song\n" +
                "2 - previous song\n" +
                "3 - replay current song\n" +
                "4 - list songs in the playlist" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> it = playlist.iterator();
        System.out.println("=================");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("=================");

    }
}
