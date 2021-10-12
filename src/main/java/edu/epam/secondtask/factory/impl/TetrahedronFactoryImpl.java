package edu.epam.secondtask.factory.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.exception.WrongTetrahedronParametersException;
import edu.epam.secondtask.factory.TetrahedronFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TetrahedronFactoryImpl implements TetrahedronFactory {
    static Logger logger = LogManager.getLogger(TetrahedronFactoryImpl.class);

    @Override
    public Tetrahedron createTetrahedron(Point3D[] vertexes, String name) throws WrongTetrahedronParametersException {
        if (vertexes.length != 4) {
            throw new WrongTetrahedronParametersException("Wrong quantity of vertexes");
        }
        return new Tetrahedron(vertexes, name);
    }
}
