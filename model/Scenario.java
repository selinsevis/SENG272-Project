package model;

import java.util.ArrayList;

public class Scenario {
    private String name;
    private String mode;
    private String qualityType;
    private ArrayList<Dimension> dimensions;

    public Scenario(String name, String mode, String qualityType) {
        this.name = name;
        this.mode = mode;
        this.qualityType = qualityType;
        this.dimensions = new ArrayList<>();
    }

    public void addDimension(Dimension dimension) {
        dimensions.add(dimension);
    }

    public Dimension getWeakestDimension() {
        if (dimensions.isEmpty()) return null;
        Dimension weakest = dimensions.get(0);
        for (Dimension d : dimensions) {
            if (d.calculateScore() < weakest.calculateScore()) {
                weakest = d;
            }
        }
        return weakest;
    }

    public String getName() { return name; }
    public String getMode() { return mode; }
    public String getQualityType() { return qualityType; }
    public ArrayList<Dimension> getDimensions() { return dimensions; }

    @Override
    public String toString() { return name; }
}
