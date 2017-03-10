package app.components;

public class ExpressSoftwareComponent extends SoftwareComponent {
    private static final String EXPRESS_SOFTWARE_COMPONENT_TYPE = "Express";
    private static final double EXPRESS_SOFTWARE_COMPONENT_MEMORY_INCREASE = 1.0;

    public ExpressSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, EXPRESS_SOFTWARE_COMPONENT_TYPE, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory(memory + (int)(memory * EXPRESS_SOFTWARE_COMPONENT_MEMORY_INCREASE));
    }
}
