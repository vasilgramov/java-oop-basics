package app.core.iterpretators;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/25/17.
 */
public interface Interpretator {

    String interpret(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
