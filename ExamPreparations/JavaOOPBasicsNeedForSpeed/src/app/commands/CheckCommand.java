package app.commands;

import app.core.managers.Manager;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public class CheckCommand extends AbstractCommand {

    public CheckCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute(String[] tokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int id = Integer.parseInt(tokens[1]);

        return super.getManager().check(id);
    }
}
