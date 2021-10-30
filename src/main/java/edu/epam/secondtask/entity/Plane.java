package edu.epam.secondtask.entity;

import java.util.Arrays;

public class Plane {
    Point3D[] points;

    public Plane(Point3D[] points) {
        this.points = points.clone();
    }

    public Point3D[] getPoints() {
        return points.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        return Arrays.equals(points, plane.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }
}
