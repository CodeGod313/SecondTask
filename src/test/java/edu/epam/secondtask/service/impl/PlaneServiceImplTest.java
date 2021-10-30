package edu.epam.secondtask.service.impl;

import edu.epam.secondtask.entity.CoordinatePlane;
import edu.epam.secondtask.entity.Plane;
import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.service.PlaneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlaneServiceImplTest {
    PlaneService planeService;

    @BeforeAll
    public void setUp() {
        planeService = new PlaneServiceImpl();
    }

    @Test
    void isParallel() {
        Point3D points[] = new Point3D[3];
        points[0] = new Point3D(1., 2., 8.);
        points[1] = new Point3D(1., 6., 9.);
        points[2] = new Point3D(1., 7., 4.);
        Plane plane = new Plane(points);
        boolean actual = planeService.isParallel(plane, CoordinatePlane.YZ_PLANE);
        Assertions.assertTrue(actual);
    }
}