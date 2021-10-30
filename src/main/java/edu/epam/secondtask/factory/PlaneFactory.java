package edu.epam.secondtask.factory;

import edu.epam.secondtask.entity.Plane;
import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;

import java.util.List;
import java.util.Optional;

public interface PlaneFactory {
    Optional<Plane> createPlane(Point3D[] points);

    List<Plane> createPlanesOfTetrahedronsFacets(Tetrahedron tetrahedron);
}
