package edu.epam.secondtask.factory.impl;

import edu.epam.secondtask.entity.Plane;
import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.factory.PlaneFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlaneFactoryImplTest {


    PlaneFactory planeFactory;

    @BeforeAll
    public void setUp() {
        planeFactory = new PlaneFactoryImpl();
    }

    @Test
    void createPlane() {
        Point3D points[] = new Point3D[4];
        points[0] = new Point3D(1., 1., 1.);
        points[1] = new Point3D(2., 2., 2.);
        points[2] = new Point3D(3., 3., 3.);
        points[3] = new Point3D(4., 4., 4.);
        Optional<Plane> actual = planeFactory.createPlane(points);
        Optional<Plane> expected = Optional.empty();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createPlanesOfTetrahedronsFacets() {
        Point3D vertexes[] = new Point3D[4];
        vertexes[0] = new Point3D(1., 1., 1.);
        vertexes[1] = new Point3D(2., 2., 2.);
        vertexes[2] = new Point3D(3., 3., 3.);
        vertexes[3] = new Point3D(4., 4., 4.);
        Tetrahedron tetrahedron = new Tetrahedron(vertexes, "hello");
        List<Plane> expected = new ArrayList<>();
        Point3D firstPlanePoints[] = Arrays.copyOf(vertexes, 3);
        expected.add(new Plane(firstPlanePoints));
        Point3D secondPlanePoints[] = Arrays.copyOfRange(vertexes, 1, 3);
        expected.add(new Plane(secondPlanePoints));
        Point3D thirdPlanePoints[] = Arrays.copyOfRange(vertexes, 2, 3);
        expected.add(new Plane(thirdPlanePoints));
        Point3D fourthPlanePoints[] = Arrays.copyOfRange(vertexes, 0, 2);
        expected.add(new Plane(fourthPlanePoints));
        List<Plane> actual = planeFactory.createPlanesOfTetrahedronsFacets(tetrahedron);
        Assertions.assertEquals(expected, actual);
    }
}