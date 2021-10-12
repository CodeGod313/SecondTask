package edu.epam.secondtask.factory;

import edu.epam.secondtask.entity.Point3D;

public interface Point3DFactory {
    public Point3D createPoint3D(Double x, Double y, Double z);
}
