package p05_onlineRadioDatabase;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0;

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] songArgs = in.nextLine().split(";");
            String artistName = songArgs[0];
            String songName = songArgs[1];
            String[] lengthArgs = songArgs[2].split(":");
            int minutes = Integer.parseInt(lengthArgs[0]);
            int seconds = Integer.parseInt(lengthArgs[1]);

            Length length = new Length(minutes, seconds);

            Song song = null;
            try {
                song = new Song(artistName, songName, length, minutes, seconds);
                System.out.println("Song Added.");
                count++;
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Songs added: " + count);

        BigInteger hours = Song.allSongsSeconds.mod(new BigInteger("3600"));
        Song.allSongsSeconds = Song.allSongsSeconds.subtract(hours.multiply(new BigInteger("3600")));

        BigInteger minutes = Song.allSongsSeconds.mod(new BigInteger("60"));
        Song.allSongsSeconds = Song.allSongsSeconds.subtract(minutes.multiply(new BigInteger("60")));

        BigInteger seconds = Song.allSongsSeconds;

        String hoursToPrint = hours.equals("0") ? "0" : hours.toString();
        String minutesToPrint = minutes.equals("0") ? "0" : minutes.toString();
        String secondsToPrint = seconds.equals("0") ? "0" : seconds.toString();

        System.out.println(String.format("Playlist length: %sh %sm %ss", hoursToPrint, minutesToPrint, secondsToPrint));
    }
}
