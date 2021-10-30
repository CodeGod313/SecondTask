package edu.epam.secondtask.entity;

public class TetrahedronWareHouseElement {
    Double sideLength;
    Double volume;
    Double surfaceArea;

    public TetrahedronWareHouseElement(Double sideLength, Double volume, Double surfaceArea) {
        this.sideLength = sideLength;
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TetrahedronWareHouseElement that = (TetrahedronWareHouseElement) o;

        if (sideLength != null ? !sideLength.equals(that.sideLength) : that.sideLength != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        return surfaceArea != null ? surfaceArea.equals(that.surfaceArea) : that.surfaceArea == null;
    }

    @Override
    public int hashCode() {
        int result = sideLength != null ? sideLength.hashCode() : 0;
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (surfaceArea != null ? surfaceArea.hashCode() : 0);
        return result;
    }
}
