package edu.epam.secondtask.factory;

import edu.epam.secondtask.entity.Plane;
import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.exception.WrongPlaneParametersException;

import java.util.List;

public interface PlaneFactory {
    Plane createPlane(Point3D[] points) throws WrongPlaneParametersException;
    List<Plane> createPlanesOfTetrahedronsFacets(Tetrahedron tetrahedron) throws WrongPlaneParametersException;
}
