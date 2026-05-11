package model;

public class Metric {
    private String name;
    private int coefficient;
    private String direction;
    private double rangeMin;
    private double rangeMax;
    private String unit;
    private double value;

    public Metric(String name, int coefficient, String direction,
                  double rangeMin, double rangeMax, String unit) {
        this.name = name;
        this.coefficient = coefficient;
        this.direction = direction;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.unit = unit;
        this.value = 0;
    }

    public double calculateScore() {
        double rawScore;
        if (direction.equalsIgnoreCase("Higher is better")) {
            rawScore = 1 + (value - rangeMin) / (rangeMax - rangeMin) * 4;
        } else {
            rawScore = 5 - (value - rangeMin) / (rangeMax - rangeMin) * 4;
        }
        rawScore = Math.max(1.0, Math.min(5.0, rawScore));
        return Math.round(rawScore * 2) / 2.0;
    }

    public String getDirectionSymbol() {
        return direction.equalsIgnoreCase("Higher is better") ? "Higher ↑" : "Lower ↓";
    }

    public String getRangeString() {
        return (int) rangeMin + "–" + (int) rangeMax;
    }

    public String getName() { return name; }
    public int getCoefficient() { return coefficient; }
    public String getDirection() { return direction; }
    public double getRangeMin() { return rangeMin; }
    public double getRangeMax() { return rangeMax; }
    public String getUnit() { return unit; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
}
