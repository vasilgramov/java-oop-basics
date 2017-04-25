package app.commands;

import app.core.managers.Manager;

/**
 * Created by vladix on 4/25/17.
 */
public abstract class AbstractCommand implements Executable {

    private Manager manager;

    protected AbstractCommand(Manager manager) {
        this.manager = manager;
    }

    protected Manager getManager() {
        return this.manager;
    }
}
