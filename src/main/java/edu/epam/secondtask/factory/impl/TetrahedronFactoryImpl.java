package edu.epam.secondtask.factory.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.exception.WrongTetrahedronParametersException;
import edu.epam.secondtask.factory.Point3DFactory;
import edu.epam.secondtask.factory.TetrahedronFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class TetrahedronFactoryImpl implements TetrahedronFactory {
    static Logger logger = LogManager.getLogger(TetrahedronFactoryImpl.class);
    //TODO: add logs

    @Override
    public Tetrahedron createTetrahedron(Point3D[] vertexes, String name) throws WrongTetrahedronParametersException {
        if (vertexes.length != 4) {
            throw new WrongTetrahedronParametersException("Wrong quantity of vertexes");
        }
        if (name == null || name == "") {
            throw new WrongTetrahedronParametersException("Wrong name");
        }
        return new Tetrahedron(vertexes, name);
    }

    @Override
    public Tetrahedron createTetrahedronFromStrings(List<String> strings) throws WrongTetrahedronParametersException {
        if (strings.size() != 13) {
            throw new WrongTetrahedronParametersException("Not enough params");
        }
        String name = strings.get(0);
        Point3DFactory point3DFactory = new Point3DFactoryImpl();
        List<Double> doublesList = strings
                .stream()
                .map(x -> Double.parseDouble(x))
                .toList();
        Point3D[] vertexes = new Point3D[4];
        for (int i = 0; i < 4; i++) {
            vertexes[i] = point3DFactory.createPoint3D(
                    doublesList.get(i * 3),
                    doublesList.get(i * 3 + 1),
                    doublesList.get(i * 3) + 2);
        }
        return createTetrahedron(vertexes, name);
    }
}
