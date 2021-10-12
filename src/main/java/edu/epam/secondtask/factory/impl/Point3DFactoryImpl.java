package edu.epam.secondtask.factory.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.factory.Point3DFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Point3DFactoryImpl implements Point3DFactory {
    static Logger logger = LogManager.getLogger(Point3DFactoryImpl.class);

    @Override
    public Point3D createPoint3D(Double x, Double y, Double z) {
        return new Point3D(x, y, z);
    }
}
