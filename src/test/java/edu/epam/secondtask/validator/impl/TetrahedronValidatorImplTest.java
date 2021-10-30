package edu.epam.secondtask.validator.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.validator.TetrahedronValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TetrahedronValidatorImplTest {

    TetrahedronValidator tetrahedronValidator;
    Tetrahedron tetrahedron;

    @BeforeAll
    public void setUp() {
        tetrahedronValidator = new TetrahedronValidatorImpl();
        Point3D vertexes[] = new Point3D[4];
        vertexes[0] = new Point3D(0., 0., 0.);
        vertexes[1] = new Point3D(1., 0., 0.);
        vertexes[2] = new Point3D(0.5, 0.866, 0.);
        vertexes[3] = new Point3D(0.5, 0.289, 0.577);
        tetrahedron = new Tetrahedron(vertexes, "HelloThere");
    }

    @Test
    void isRegular() {
        boolean actual = tetrahedronValidator.isRegular(tetrahedron);
        Assertions.assertTrue(actual);
    }
}