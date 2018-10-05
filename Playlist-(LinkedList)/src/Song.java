public class Song {
    private String SongName;
    private double duration;

    public Song(String name, double duration) {
        this.SongName = name;
        this.duration = duration;
    }

    public String getSongName() {
        return SongName;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return this.SongName + ": " + this.duration;
    }
}
