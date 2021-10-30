package edu.epam.secondtask.repository.specification.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.repository.specification.TetrahedronSpecification;

import java.util.Arrays;

public class TetrahedronPointSpecification implements TetrahedronSpecification {
    Point3D point;

    public TetrahedronPointSpecification(Point3D point) {
        this.point = point;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        Point3D[] points = tetrahedron.getVertexes();
        return Arrays.stream(points)
                .filter(x -> x.equals(point))
                .findAny()
                .isPresent();
    }
}
