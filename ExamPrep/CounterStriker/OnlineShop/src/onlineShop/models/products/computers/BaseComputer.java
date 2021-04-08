package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
import static onlineShop.common.constants.OutputMessages.*;
import static onlineShop.common.constants.ExceptionMessages.*;
public abstract class BaseComputer extends BaseProduct implements Computer {

    private final List<Component> components;
    private final List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public double getOverallPerformance() {
        double componentsAverage = components.stream().mapToDouble(Component::getOverallPerformance)
                .average().orElse(0);
        return super.getOverallPerformance() + componentsAverage;
    }

    private double getAveragePeripheralOverallPerformance() {
        return peripherals.stream().map(Peripheral::getOverallPerformance)
                .mapToDouble(Double::doubleValue).average().orElse(0.00);
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) throws IllegalAccessException {

        Component component = components.stream().
                filter(c -> c.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);
                if (component == null) {
                    throw new IllegalAccessException(String.format(NOT_EXISTING_COMPONENT
                            , componentType, getClass().getSimpleName(), getId()));
                }
                components.remove(component);
                return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) throws IllegalAccessException {
        Peripheral peripheral = peripherals.stream()
                .filter(c -> c.getClass().getSimpleName().equals(peripheralType))
                .findFirst().orElse(null);

        if (peripheral == null) {
            throw new IllegalAccessException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType, getClass().getSimpleName(), getId()));
        }
        peripherals.remove(peripheral);
        return peripheral;
    }

    @Override
    public double getPrice() {
        return super.getPrice() +
                components.stream().mapToDouble(Component::getPrice).sum()
                + peripherals.stream().mapToDouble(Peripheral::getPrice).sum();

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator());
        output.append(String.format(COMPUTER_COMPONENTS_TO_STRING, components.size()));
        output.append(System.lineSeparator());
        components.forEach(c -> output.append("  ")
                .append(c.toString())
                .append(System.lineSeparator()));
        output.append(String.format(COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), getAveragePeripheralOverallPerformance()));
        output.append(System.lineSeparator());
        peripherals.forEach(p -> output.append("  ").append(p.toString()).append(System.lineSeparator()));

        return output.toString().trim();
    }
}
