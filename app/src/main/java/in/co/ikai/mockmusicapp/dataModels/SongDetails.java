package in.co.ikai.mockmusicapp.dataModels;

public class SongDetails {
    private String songName;
    private String singerName;
    private String duration;

    // Empty constructor.
    public SongDetails() {
    }

    // Constructor with arguments.
    public SongDetails(String songName, String singerName, String duration) {
        this.songName = songName;
        this.singerName = singerName;
        this.duration = duration;
    }

    // Getters and setters.
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
