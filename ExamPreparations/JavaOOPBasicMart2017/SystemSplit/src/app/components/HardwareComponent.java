package app.components;

import java.util.*;

public abstract class HardwareComponent extends Component {
    private int usedMemory;
    private int usedCapacity;
    private Map<String, SoftwareComponent> softwareComponents;

    protected HardwareComponent(String name, String type, int capacity, int memory) {
        super(name, type, capacity, memory);

        this.softwareComponents = new LinkedHashMap<>();
    }

    public int getUsedMemory() {
        return this.usedMemory;
    }

    private void setUsedMemory(int usedMemory) {
        this.usedMemory = usedMemory;
    }

    public int getUsedCapacity() {
        return this.usedCapacity;
    }

    private void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent) {
        if (this.canRegisterSoftwareComponent(softwareComponent)) {
            this.softwareComponents.put(softwareComponent.getName(), softwareComponent);
            this.setUsedCapacity(this.getUsedCapacity() + softwareComponent.getCapacity());
            this.setUsedMemory(this.getUsedMemory() + softwareComponent.getMemory());
        }
    }

    public Collection<SoftwareComponent> getSoftwareComponents() {
        return this.softwareComponents.values();
    }

    public void releaseSoftware(String softwareComponentName) {
        SoftwareComponent softwareComponent = this.softwareComponents.get(softwareComponentName);

        this.setUsedMemory(this.getUsedMemory() - softwareComponent.getMemory());
        this.setUsedCapacity(this.getUsedCapacity() - softwareComponent.getCapacity());

        this.softwareComponents.remove(softwareComponentName);
    }

    public int getSoftwareComponentsCount() {
        return this.softwareComponents.size();
    }

    private boolean canRegisterSoftwareComponent(SoftwareComponent softwareComponent) {
        int leftCapacity = super.getCapacity() - this.getUsedCapacity();
        int leftMemory = super.getMemory() - this.getUsedMemory();

        return leftCapacity >= softwareComponent.getCapacity() &&
                leftMemory >= softwareComponent.getMemory();
    }
}
