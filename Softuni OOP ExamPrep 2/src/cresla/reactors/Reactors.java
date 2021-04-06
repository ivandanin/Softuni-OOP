package cresla.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class Reactors implements Reactor {

    private final int id;
    private final ModuleContainer moduleContainer;

    protected Reactors(int id, int moduleCapacity) {
        this.id = id;
        this.moduleContainer = new ModuleContainer(100);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public long getTotalEnergyOutput() {
        return moduleContainer.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return moduleContainer.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
       return this.moduleContainer.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getClass().getSimpleName())
                .append(" - ").append(getId()).append(System.lineSeparator())
                .append("Energy output: ").append(getTotalEnergyOutput()).append(System.lineSeparator())
                .append("Heat Absorbing: ").append(getTotalHeatAbsorbing()).append(System.lineSeparator())
                .append("Modules: ").append(getModuleCount());

        return output.toString();
    }
}
