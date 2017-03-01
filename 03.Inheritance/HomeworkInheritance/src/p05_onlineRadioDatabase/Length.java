package p05_onlineRadioDatabase;

public class Length {
    private int minutes;
    private int seconds;

    public Length(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public int getMinutes() {
        return this.minutes;
    }
}
