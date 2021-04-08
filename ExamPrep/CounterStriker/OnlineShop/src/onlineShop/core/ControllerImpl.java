package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.*;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    Map<Integer, Computer> computers;
    Map<Integer, Peripheral> peripherals;
    Map<Integer, Component> components;

    public ControllerImpl() {
        this.computers = new LinkedHashMap<>();
        this.peripherals = new LinkedHashMap<>();
        this.components = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        Computer computer;

        switch (computerType) {
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalStateException(INVALID_COMPUTER_TYPE);
        }
        computers.put(id, computer);
        return String.format(ADDED_COMPUTER, computer.getId());
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {
        checkIfIdExists(computerId);

        if (peripherals.containsKey(computerId)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        computers.get(computerId).addPeripheral(peripheral);
        peripherals.put(computerId, peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer,
                               String model, double price, double overallPerformance, int generation) {

        checkIfIdExists(computerId);

        if (components.containsKey(computerId)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        computers.get(computerId).addComponent(component);
        components.put(id, component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) throws IllegalAccessException {
        checkIfIdExists(computerId);
        Computer computer = computers.get(computerId);
        Peripheral peripheral = computer.removePeripheral(peripheralType);
        peripherals.remove(peripheral.getId());

        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String removeComponent(String componentType, int computerId) throws IllegalAccessException {
        checkIfIdExists(computerId);
        Computer computer = computers.get(computerId);
        Component component = computer.removeComponent(componentType);
        components.remove(component.getId());

        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        checkIfIdExists(id);
        Computer computer = computers.get(id);
        computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer;
        computer = computers.values().stream().filter(c -> c.getPrice() <= budget)
                .max(Comparator.comparingDouble(Computer::getPrice)).orElse(null);

        if (computer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        return buyComputer(computer.getId());
    }

    @Override
    public String getComputerData(int id) {
        checkIfIdExists(id);
        Computer computer = computers.get(id);
        return computer.toString();
    }

    private void checkIfIdExists(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }
}
