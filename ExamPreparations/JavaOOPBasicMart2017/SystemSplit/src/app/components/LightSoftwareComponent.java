package app.components;

public class LightSoftwareComponent extends SoftwareComponent {
    private static final String LIGHT_SOFTWARE_COMPONENT_TYPE = "Light";
    private static final double LIGHT_SOFTWARE_COMPONENT_TYPE_CAPACITY_INCREASE = 0.50;
    private static final double LIGHT_SOFTWARE_COMPONENT_TYPE_MEMORY_DECREASE = 0.50;

    public LightSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, LIGHT_SOFTWARE_COMPONENT_TYPE, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity((int)(capacity + (capacity * LIGHT_SOFTWARE_COMPONENT_TYPE_CAPACITY_INCREASE)));
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory((int)(memory - (memory * LIGHT_SOFTWARE_COMPONENT_TYPE_MEMORY_DECREASE)));
    }
}
