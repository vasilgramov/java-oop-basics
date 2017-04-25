package app.commands;

import app.core.managers.Manager;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public class ParticipateCommand extends AbstractCommand {

    public ParticipateCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute(String[] tokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int carId = Integer.parseInt(tokens[1]);
        int raceId = Integer.parseInt(tokens[2]);

        super.getManager().participate(carId, raceId);
        return null;
    }
}
