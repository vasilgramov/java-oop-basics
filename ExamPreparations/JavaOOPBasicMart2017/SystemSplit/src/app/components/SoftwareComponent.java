package app.components;

public abstract class SoftwareComponent extends Component {

    protected SoftwareComponent(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
    }
}
