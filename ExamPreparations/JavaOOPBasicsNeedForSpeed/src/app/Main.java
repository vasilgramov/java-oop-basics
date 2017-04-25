package app;

import app.core.Engine;
import app.core.iterpretators.CommandInterpretator;
import app.core.iterpretators.Interpretator;
import app.core.managers.Manager;
import app.core.managers.RaceManager;
import app.io.readers.ConsoleReader;
import app.io.readers.Reader;
import app.io.writers.ConsoleWriter;
import app.io.writers.Writer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladix on 4/25/17.
 */
public class Main {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Manager manager = new RaceManager();
        Interpretator interpretator = new CommandInterpretator(manager);
        Runnable engine = new Engine(reader, writer, interpretator);

        engine.run();
    }
}
