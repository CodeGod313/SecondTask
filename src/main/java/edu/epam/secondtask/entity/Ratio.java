package edu.epam.secondtask.entity;

public class Ratio {
    Double numerator;
    Double denominator;

    public Ratio(Double numerator, Double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Double getNumerator() {
        return numerator;
    }

    public void setNumerator(Double numerator) {
        this.numerator = numerator;
    }

    public Double getDenominator() {
        return denominator;
    }

    public void setDenominator(Double denominator) {
        this.denominator = denominator;
    }

    public Double getAsDouble() {
        return numerator / denominator;
    }
}
