package edu.epam.secondtask.service.impl;

import edu.epam.secondtask.entity.*;
import edu.epam.secondtask.exception.WrongPlaneParametersException;
import edu.epam.secondtask.exception.WrongTetrahedronParametersException;
import edu.epam.secondtask.factory.PlaneFactory;
import edu.epam.secondtask.factory.impl.PlaneFactoryImpl;
import edu.epam.secondtask.service.PlaneService;
import edu.epam.secondtask.service.RegularTetrahedronService;

import java.util.List;

public class RegularTetrahedronServiceImpl implements RegularTetrahedronService {


    @Override
    public Double countSurfaceArea(Tetrahedron tetrahedron) {
        return Math.pow(countSideLength(tetrahedron), 2) * Math.sqrt(3);
    }

    @Override
    public Double countVolume(Tetrahedron tetrahedron) {
        return Math.pow(countSideLength(tetrahedron), 2) / 6. / Math.sqrt(2);
    }

    @Override
    public Double countSideLength(Tetrahedron tetrahedron) {
        Point3D[] vertexes = tetrahedron.getVertexes();
        Point3D vertexOne = vertexes[0];
        Point3D vertexTwo = vertexes[1];
        Double firstSquare = Math.pow(vertexOne.getX() - vertexTwo.getX(), 2);
        Double secondSquare = Math.pow(vertexOne.getY() - vertexTwo.getY(), 2);
        Double thirdSquare = Math.pow(vertexOne.getZ() - vertexTwo.getZ(), 2);
        return Math.sqrt(firstSquare + secondSquare + thirdSquare);
    }

    @Override
    public Ratio countValuesRatioOfIntersectedByCoordinatePlaneTetrahedron(Tetrahedron tetrahedron, CoordinatePlane coordinatePlane) throws WrongPlaneParametersException, WrongTetrahedronParametersException {
        //TODO: change realisation
        PlaneFactory planeFactory = new PlaneFactoryImpl();
        List<Plane> facets = planeFactory.createPlanesOfTetrahedronsFacets(tetrahedron);
        PlaneService planeService = new PlaneServiceImpl();
        List<Plane> parallelPlaneList = facets.stream().filter(x -> planeService.isParallel(x, coordinatePlane)).toList();
        if (parallelPlaneList.size() != 1) {
            throw new WrongTetrahedronParametersException("Any tetrahedron face is parallel to coordinate plane");
        }
        Plane parallelPlane = parallelPlaneList.get(0);
        Point3D[] pointsOfParallelPlane = parallelPlane.getPoints();
        Point3D vertexOfParallelPlane = null;
        Point3D[] pointsOfTetrahedron = tetrahedron.getVertexes();
        for (int i = 0; i < pointsOfTetrahedron.length; i++) {
            for (int j = 0; j < pointsOfParallelPlane.length; j++) {
                if (!pointsOfTetrahedron[i].equals(pointsOfParallelPlane[j])) {
                    vertexOfParallelPlane = pointsOfTetrahedron[i];
                }
            }
        }
        switch (coordinatePlane) {
            case XY_PLANE -> {
                if (vertexOfParallelPlane.getZ() < pointsOfParallelPlane[0].getZ()) {
                    throw new WrongTetrahedronParametersException("The plane does not intersect the tetrahedron");
                }

            }
        }
    }
}
