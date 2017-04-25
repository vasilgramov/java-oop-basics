package app.commands;

import app.core.managers.Manager;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/26/17.
 */
public class TuneCommand extends AbstractCommand {

    public TuneCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute(String[] tokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int tuneIndex = Integer.parseInt(tokens[1]);
        String tuneAddOn = tokens[2];

        super.getManager().tune(tuneIndex, tuneAddOn);
        return null;
    }
}
