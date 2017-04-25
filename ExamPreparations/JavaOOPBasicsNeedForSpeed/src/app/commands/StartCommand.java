package app.commands;

import app.core.managers.Manager;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public class StartCommand extends AbstractCommand {

    public StartCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute(String[] tokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int raceId = Integer.parseInt(tokens[1]);

        return super.getManager().startRace(raceId);
    }
}
