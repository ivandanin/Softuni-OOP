package cresla.reactors;

public class HeatReactor extends Reactors {

    private final int heatReductionIndex;

    public HeatReactor(int id, int moduleCapacity, int heatReductionIndex) {
        super(id, moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    public int getHeatReductionIndex() {
        return this.heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + getHeatReductionIndex();
    }

}
