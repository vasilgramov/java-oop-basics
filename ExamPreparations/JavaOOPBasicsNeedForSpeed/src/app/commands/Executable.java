package app.commands;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public interface Executable {

    String execute(String[] tokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
