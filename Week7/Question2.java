import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int count;

    Playlist(int size) {
        songs = new String[size];
    }

    void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}