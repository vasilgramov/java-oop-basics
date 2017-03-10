package app.components;

public class HeavyHardwareComponent extends HardwareComponent {
    private static final String HEAVY_HARDWARE_COMPONENT_TYPE = "Heavy";
    private static final double HEAVY_HARDWARE_COMPONENT_MEMORY_DECREASE = 0.25;
    private static final double HEAVY_HARDWARE_COMPONENT_CAPACITY_INCREASE = 1.0;

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, HEAVY_HARDWARE_COMPONENT_TYPE, capacity, memory);
    }

    @Override
    public int getMemory() {
        return super.getMemory();
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity((int)(capacity + (capacity * HEAVY_HARDWARE_COMPONENT_CAPACITY_INCREASE)));
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory((int)(memory - (memory * HEAVY_HARDWARE_COMPONENT_MEMORY_DECREASE)));
    }
}
