package edu.epam.secondtask.factory.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.factory.Point3DFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Point3DFactoryImplTest {

    Point3DFactory point3DFactory;

    @BeforeAll
    public void setUp() {
        point3DFactory = new Point3DFactoryImpl();
    }

    @Test
    void createPoint3D() {
        Double x = 0.;
        Double y = 1.;
        Double z = 2.;
        Point3D expected = new Point3D(x, y, z);
        Point3D actual = point3DFactory.createPoint3D(x, y, z);
        Assertions.assertEquals(expected, actual);
    }
}