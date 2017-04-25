package app.commands;

import app.core.managers.Manager;
import app.models.races.Race;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public class OpenCommand extends AbstractCommand {


    private static final String RACES_PATH = "app.models.races.";
    private static final String RACE ="Race";

    public OpenCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute(String[] tokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // open {id} {type} {length} {route} {prizePool}
        int id = Integer.parseInt(tokens[1]);
        String type = tokens[2];
        Class<?> raceClass = Class.forName(RACES_PATH + type + RACE);
        // int length, String route, int prizePool
        Constructor<?> constructor = raceClass.getDeclaredConstructor(int.class, String.class, int.class);
        Race race = ((Race) constructor.newInstance(
                Integer.parseInt(tokens[3]),
                tokens[4],
                Integer.parseInt(tokens[5])));

        super.getManager().openRace(id, race);
        return null;
    }
}
