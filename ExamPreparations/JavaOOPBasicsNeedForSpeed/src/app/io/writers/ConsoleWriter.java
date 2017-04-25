package app.io.writers;

/**
 * Created by vladix on 4/25/17.
 */
public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        if (line != null) {
            System.out.println(line);
        }
    }

}
