package model;

import java.util.ArrayList;

public class Dimension {
    private String name;
    private int coefficient;
    private ArrayList<Metric> metrics;

    public Dimension(String name, int coefficient) {
        this.name = name;
        this.coefficient = coefficient;
        this.metrics = new ArrayList<>();
    }

    public void addMetric(Metric metric) {
        metrics.add(metric);
    }

    public double calculateScore() {
        double weightedSum = 0;
        int totalCoeff = 0;
        for (Metric m : metrics) {
            weightedSum += m.calculateScore() * m.getCoefficient();
            totalCoeff += m.getCoefficient();
        }
        if (totalCoeff == 0) return 0;
        return weightedSum / totalCoeff;
    }

    public String getName() { return name; }
    public int getCoefficient() { return coefficient; }
    public ArrayList<Metric> getMetrics() { return metrics; }
}