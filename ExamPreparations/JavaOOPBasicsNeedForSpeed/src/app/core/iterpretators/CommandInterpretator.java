package app.core.iterpretators;

import app.commands.Executable;
import app.core.managers.Manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public class CommandInterpretator implements Interpretator {

    public static final String COMMAND = "Command";
    public static final String COMMANDS_PATH = "app.commands.";

    private Manager manager;

    public CommandInterpretator(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String interpret(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = line.split("\\s+");
        String commandType = Character.toUpperCase(tokens[0].charAt(0)) + tokens[0].substring(1);

        Class<?> commandClass = Class.forName(COMMANDS_PATH + commandType + COMMAND);
        Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor(Manager.class);
        Executable executable = ((Executable) declaredConstructor.newInstance(this.manager));

        String result = executable.execute(tokens);

        return result;
    }

}
