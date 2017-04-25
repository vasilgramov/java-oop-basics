package app.core;

import app.core.iterpretators.Interpretator;
import app.core.managers.Manager;
import app.io.readers.Reader;
import app.io.writers.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private Interpretator interpretator;

    public Engine(Reader reader, Writer writer, Interpretator interpretator) {
        this.reader = reader;
        this.writer = writer;
        this.interpretator = interpretator;
    }

    @Override
    public void run() {

        try {
            String line = this.reader.readLine();
            while (!"Cops Are Here".equals(line)) {
                String result = this.interpretator.interpret(line);
                this.writer.writeLine(result);

                line = this.reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
