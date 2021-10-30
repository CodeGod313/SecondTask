package edu.epam.secondtask.service.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.service.RegularTetrahedronService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.PipedOutputStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RegularTetrahedronServiceImplTest {

    RegularTetrahedronService regularTetrahedronService;
    Tetrahedron tetrahedron;

    @BeforeAll
    public void setUp() {
        regularTetrahedronService = new RegularTetrahedronServiceImpl();
        Point3D vertexes[] = new Point3D[4];
        vertexes[0] = new Point3D(0., 0., 0.);
        vertexes[1] = new Point3D(1., 0., 0.);
        vertexes[2] = new Point3D(0.5, 0.866, 0.);
        vertexes[3] = new Point3D(0.5, 0.289, 0.577);
        tetrahedron = new Tetrahedron(vertexes, "HelloThere");
    }

    @Test
    void countSurfaceArea() {
        Double expected = 1.732;
        Double actual = regularTetrahedronService.countSurfaceArea(tetrahedron);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void countSideLength() {
        Double expected = 1.;
        Double actual = regularTetrahedronService.countSideLength(tetrahedron);
        Assertions.assertEquals(expected, actual, 0.001);
    }
}