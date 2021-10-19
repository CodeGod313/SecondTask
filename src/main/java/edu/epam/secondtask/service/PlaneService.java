package edu.epam.secondtask.service;

import edu.epam.secondtask.entity.CoordinatePlane;
import edu.epam.secondtask.entity.Plane;

public interface PlaneService {
    boolean isParallel(Plane plane, CoordinatePlane coordinatePlane);
}
