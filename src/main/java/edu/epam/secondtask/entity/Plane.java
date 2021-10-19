package edu.epam.secondtask.entity;

public class Plane {
    Point3D[] points;

    public Plane(Point3D[] points) {
        this.points = points.clone();
    }

    public Point3D[] getPoints() {
        return points.clone();
    }
}
