package app;

import app.components.*;

import java.util.*;
import java.util.stream.Collectors;

public class TheSystem {
    private Map<String, HardwareComponent> hardwareComponents;

    private Map<String, HardwareComponent> dumpedHardwareComponents;

    public TheSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.dumpedHardwareComponents = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = new PowerHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, hardwareComponent);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = new HeavyHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, hardwareComponent);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        SoftwareComponent softwareComponent = new ExpressSoftwareComponent(name, capacity, memory);

        HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
        hardwareComponent.registerSoftwareComponent(softwareComponent);

        this.hardwareComponents.put(hardwareComponentName, hardwareComponent);
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
          SoftwareComponent softwareComponent = new LightSoftwareComponent(name, capacity, memory);

          HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
          hardwareComponent.registerSoftwareComponent(softwareComponent);

          this.hardwareComponents.put(hardwareComponentName, hardwareComponent);
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
        hardwareComponent.releaseSoftware(softwareComponentName);
    }

    public String analyze() {
        StringBuilder builder = new StringBuilder();
        builder.append("System Analysis\n")
                .append(String.format("Hardware Components: %d\n", this.hardwareComponents.size()))
                .append(String.format("Software Components: %d\n", this.getSoftwareComponents()))
                .append(String.format("Total Operational Memory: %d / %d\n", this.getMemoryInUse(), this.getMaxMemory()))
                .append(String.format("Total Capacity Taken: %d / %d", this.getCapacityInUse(), this.getMaxCapacity()));


        return builder.toString();
    }

    public String split() {
        StringBuilder builder = new StringBuilder();

        this.hardwareComponents.values().stream()
                .sorted((h1, h2) -> h2.getType().compareTo(h1.getType()))
                .forEach(h -> {
                    builder.append("Hardware Component - " + h.getName() + "\n");
                    builder.append("Express Software Components - " + h.getSoftwareComponents().stream().filter(s -> s.getType().equals("Express")).count() + "\n");
                    builder.append("Light Software Components - " + h.getSoftwareComponents().stream().filter(s -> s.getType().equals("Light")).count() + "\n");

                    builder.append(String.format("Memory Usage: %d / %d\n", h.getUsedMemory(), h.getMemory()));
                    builder.append(String.format("Capacity Usage: %d / %d\n", h.getUsedCapacity(), h.getCapacity()));

                    builder.append("Type: " + h.getType() + "\n");

                    builder.append("Software Components: ");
                    if (h.getSoftwareComponents().size() == 0) {
                        builder.append("None");
                    } else {
                        builder.append(h.getSoftwareComponents().stream().map(Component::getName).collect(Collectors.joining(", ")));
                    }

                    builder.append("\n");
                });

        return builder.toString();
    }

    public void dump(String hardwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);
            this.dumpedHardwareComponents.put(hardwareComponentName, hardwareComponent);
            this.hardwareComponents.remove(hardwareComponentName);
        }
    }

    public void restore(String hardwareComponentName) {
        if (this.dumpedHardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.dumpedHardwareComponents.get(hardwareComponentName);
            this.hardwareComponents.put(hardwareComponentName, hardwareComponent);
            this.dumpedHardwareComponents.remove(hardwareComponentName);
        }
    }

    public void destroy(String hardwareComponentName) {
        if (this.dumpedHardwareComponents.containsKey(hardwareComponentName)) {
            this.dumpedHardwareComponents.remove(hardwareComponentName);
        }
    }

    public void dumpAnalyze() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dump Analysis\n")
                .append(String.format("Power Hardware Components: %d\n", this.getCountDumpedHardwareComponents("Power")))
                .append(String.format("Heavy Hardware Components: %d\n", this.getCountDumpedHardwareComponents("Heavy")))
                .append(String.format("Express Software Components: %d\n", this.getCountDumpedSoftwareComponents("Express")))
                .append(String.format("Light Software Components: %d\n", this.getCountDumpedSoftwareComponents("Light")))
                .append(String.format("Total Dumped Memory: %d\n", this.getTotalDumpedMemory()))
                .append(String.format("Total Dumped Capacity: %d", this.getTotalDumpedCapacity()));

        System.out.println(builder.toString());
    }

    private long getCountDumpedHardwareComponents(String flag) {
        return this.dumpedHardwareComponents.values().stream()
                .filter(h -> h.getType().equals(flag))
                .count();
    }

    private long getCountDumpedSoftwareComponents(String flag) {
        long count = 0;
        for (HardwareComponent hardwareComponent : dumpedHardwareComponents.values()) {
            for (SoftwareComponent softwareComponent : hardwareComponent.getSoftwareComponents()) {
                if (softwareComponent.getType().equals(flag)) {
                    count++;
                }
            }
        }

        return count;
    }

    private int getTotalDumpedMemory() {
        int sum = 0;
        for (HardwareComponent hardwareComponent : dumpedHardwareComponents.values()) {
            sum += hardwareComponent.getUsedMemory();
        }

        return sum;
    }

    private int getTotalDumpedCapacity() {
        int sum = 0;
        for (HardwareComponent hardwareComponent : dumpedHardwareComponents.values()) {
            sum += hardwareComponent.getUsedCapacity();
        }

        return sum;
    }

    private int getSoftwareComponents() {
        int sum = 0;

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            sum += hardwareComponent.getSoftwareComponentsCount();
        }


        return sum;
    }

    private int getMemoryInUse() {
        int sum = 0;

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            sum += hardwareComponent.getUsedMemory();
        }

        return sum;
    }

    private int getMaxMemory() {
        int sum = 0;

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            sum += hardwareComponent.getMemory();
        }

        return sum;
    }

    private int getCapacityInUse() {
        int sum = 0;

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            sum += hardwareComponent.getUsedCapacity();
        }

        return sum;
    }

    private int getMaxCapacity() {
        int sum = 0;

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            sum += hardwareComponent.getCapacity();
        }

        return sum;
    }
}
