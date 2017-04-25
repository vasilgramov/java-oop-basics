package app.commands;

import app.core.managers.Manager;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/26/17.
 */
public class ParkCommand extends AbstractCommand {

    public ParkCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute(String[] tokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int carId = Integer.parseInt(tokens[1]);

        super.getManager().park(carId);
        return null;
    }
}
