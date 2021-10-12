package edu.epam.secondtask.factory;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.exception.WrongTetrahedronParametersException;

public interface TetrahedronFactory {
    public Tetrahedron createTetrahedron(Point3D[] vertexes, String name) throws WrongTetrahedronParametersException;
}
