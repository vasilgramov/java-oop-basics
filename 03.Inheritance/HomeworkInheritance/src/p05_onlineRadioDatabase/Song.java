package p05_onlineRadioDatabase;

import java.math.BigInteger;

public class Song {
    public static BigInteger allSongsSeconds = BigInteger.ZERO;

    private String artistName;
    private String songName;
    private Length songLength;
    private int seconds;
    private int minutes;

    public Song(String artistName, String songName, Length length, int minutes, int seconds) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongLength(length);
        this.setMinutes(minutes);
        this.setSeconds(seconds);

        allSongsSeconds = allSongsSeconds
                .add(new BigInteger(Integer.toString(this.getMinutes() * 60))
                .add(new BigInteger(Integer.toString(this.getSeconds()))));
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artistName = artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    public void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }

        this.songName = songName;
    }

    public Length getSongLength() {
        return this.songLength;
    }

    public void setSongLength(Length songLength) throws InvalidSongLengthException {
        if (songLength.getMinutes() < 0 && songLength.getMinutes() > 14 &&
                songLength.getSeconds() < 0 && songLength.getSeconds() > 59) {
            throw new InvalidSongLengthException("Invalid song length.");
        }

        this.songLength = songLength;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) throws InvalidSongMinutesException {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }

        this.minutes = minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int seconds) throws InvalidSongSecondsException {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }

        this.seconds = seconds;
    }
}
