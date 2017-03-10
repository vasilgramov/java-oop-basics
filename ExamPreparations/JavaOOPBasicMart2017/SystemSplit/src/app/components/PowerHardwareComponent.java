package app.components;

public class PowerHardwareComponent extends HardwareComponent {
    private static final String POWER_HARDWARE_COMPONENT_TYPE = "Power";
    private static final double POWER_HARDWARE_COMPONENT_CAPACITY_DECREASE = 0.75;
    private static final double POWER_HARDWARE_COMPONENT_MEMORY_INCREASE = 0.75;

    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, POWER_HARDWARE_COMPONENT_TYPE, capacity , memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity((int)(capacity - (capacity * POWER_HARDWARE_COMPONENT_CAPACITY_DECREASE)));
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory((int)(memory + (memory * POWER_HARDWARE_COMPONENT_MEMORY_INCREASE)));
    }
}
