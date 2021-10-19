package edu.epam.secondtask.service.impl;

import edu.epam.secondtask.entity.CoordinatePlane;
import edu.epam.secondtask.entity.Plane;
import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.service.PlaneService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PlaneServiceImpl implements PlaneService {
    static Logger logger = LogManager.getLogger(PlaneServiceImpl.class);
    @Override
    public boolean isParallel(Plane plane, CoordinatePlane coordinatePlane) {
        Point3D[] points = plane.getPoints();
        switch (coordinatePlane){
            case XY_PLANE -> {
                return points[0].getZ() == points[1].getZ() && points[2].getZ() == points[1].getZ();
            }
            case YZ_PLANE -> {
                return points[0].getX() == points[1].getX() && points[2].getX() == points[1].getX();
            }
            case ZX_PLANE -> {
                return points[0].getY() == points[1].getY() && points[2].getY() == points[1].getY();

            }
        }
        return false;
    }
}
