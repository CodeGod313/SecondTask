package edu.epam.secondtask.factory.impl;

import edu.epam.secondtask.entity.Plane;
import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.exception.WrongPlaneParametersException;
import edu.epam.secondtask.factory.PlaneFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PlaneFactoryImpl implements PlaneFactory {
    static Logger logger = LogManager.getLogger(PlaneFactoryImpl.class);

    @Override
    public Plane createPlane(Point3D[] points) throws WrongPlaneParametersException {
        if (points.length != 3) {
            throw new WrongPlaneParametersException("Plane must contain 3 points");
        }
        Plane plane = new Plane(points);
        return plane;
    }

    @Override
    public List<Plane> createPlanesOfTetrahedronsFacets(Tetrahedron tetrahedron) throws WrongPlaneParametersException {
        Point3D[] vertexes = tetrahedron.getVertexes();
        Plane firstFace = createPlaneFromTetrahedronVertexes(vertexes, 0, 1, 2);
        Plane secondFace = createPlaneFromTetrahedronVertexes(vertexes, 1, 2, 3);
        Plane thirdFace = createPlaneFromTetrahedronVertexes(vertexes, 0, 2, 3);
        Plane fourthFace = createPlaneFromTetrahedronVertexes(vertexes, 0, 1, 3);
        List<Plane> tetrahedronsFacets = List.of(firstFace, secondFace, thirdFace, fourthFace);
        return tetrahedronsFacets;
    }

    private Plane createPlaneFromTetrahedronVertexes(Point3D[] vertexes, Integer index1, Integer index2, Integer index3) throws WrongPlaneParametersException {
        List<Point3D> pointsList = new ArrayList<>();
        pointsList.add(vertexes[index1]);
        pointsList.add(vertexes[index2]);
        pointsList.add(vertexes[index3]);
        Point3D[] pointsArray = pointsList.toArray(new Point3D[0]);
        return createPlane(pointsArray);
    }
}
