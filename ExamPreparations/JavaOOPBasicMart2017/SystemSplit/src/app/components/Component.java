package app.components;

public abstract class Component {
    private String name;
    private String type;
    private int capacity;
    private int memory;

    protected Component(String name, String type) {
        this(name, type, -1, -1);
    }

    protected Component(String name, String type, int capacity, int memory) {
        this.setName(name);
        this.setType(type);
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return this.capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMemory() {
        return this.memory;
    }

    protected void setMemory(int memory) {
        this.memory = memory;
    }
}
