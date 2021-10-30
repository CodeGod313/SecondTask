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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ratio ratio = (Ratio) o;

        if (numerator != null ? !numerator.equals(ratio.numerator) : ratio.numerator != null) return false;
        return denominator != null ? denominator.equals(ratio.denominator) : ratio.denominator == null;
    }

    @Override
    public int hashCode() {
        int result = numerator != null ? numerator.hashCode() : 0;
        result = 31 * result + (denominator != null ? denominator.hashCode() : 0);
        return result;
    }
}
