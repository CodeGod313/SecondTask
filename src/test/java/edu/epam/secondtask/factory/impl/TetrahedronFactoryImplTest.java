package edu.epam.secondtask.factory.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.exception.WrongTetrahedronParametersException;
import edu.epam.secondtask.factory.Point3DFactory;
import edu.epam.secondtask.factory.TetrahedronFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TetrahedronFactoryImplTest {

    TetrahedronFactory tetrahedronFactory;
    Point3D vertexes[];

    @BeforeAll
    public void setUp() {
        tetrahedronFactory = new TetrahedronFactoryImpl();
        vertexes = new Point3D[4];
        vertexes[0] = new Point3D(1., 1., 1.);
        vertexes[1] = new Point3D(2., 1., 1.);
        vertexes[2] = new Point3D(3., 1., 1.);
        vertexes[3] = new Point3D(4., 1., 1.);
    }

    @Test
    void createTetrahedron() throws WrongTetrahedronParametersException {
        String name = "HelloThere";
        Tetrahedron expected = new Tetrahedron(vertexes, name);
        Tetrahedron actual = tetrahedronFactory.createTetrahedron(vertexes, name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createTetrahedronFromStrings() {
    }
}