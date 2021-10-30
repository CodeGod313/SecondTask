package edu.epam.secondtask.service.impl;

import edu.epam.secondtask.entity.*;
import edu.epam.secondtask.exception.WrongTetrahedronParametersException;
import edu.epam.secondtask.factory.PlaneFactory;
import edu.epam.secondtask.factory.impl.PlaneFactoryImpl;
import edu.epam.secondtask.service.PlaneService;
import edu.epam.secondtask.service.RegularTetrahedronService;

import java.util.List;
import java.util.Optional;

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
    public Ratio countValuesRatioOfIntersectedByCoordinatePlaneTetrahedron(Tetrahedron tetrahedron, CoordinatePlane coordinatePlane) throws WrongTetrahedronParametersException {
        PlaneFactory planeFactory = new PlaneFactoryImpl();
        List<Plane> facets = planeFactory.createPlanesOfTetrahedronsFacets(tetrahedron);
        PlaneService planeService = new PlaneServiceImpl();
        List<Plane> parallelPlaneList = facets.stream().filter(x -> planeService.isParallel(x, coordinatePlane)).toList();
        if (parallelPlaneList.size() != 1) {
            throw new WrongTetrahedronParametersException("Any tetrahedron face is parallel to coordinate plane");
        }
        Plane parallelPlane = parallelPlaneList.get(0);
        Point3D[] pointsOfParallelPlane = parallelPlane.getPoints();
        Point3D oppositeVertexOfParallelPlane = null;
        Point3D[] pointsOfTetrahedron = tetrahedron.getVertexes();
        for (int i = 0; i < pointsOfTetrahedron.length; i++) {
            for (int j = 0; j < pointsOfParallelPlane.length; j++) {
                if (!pointsOfTetrahedron[i].equals(pointsOfParallelPlane[j])) {
                    oppositeVertexOfParallelPlane = pointsOfTetrahedron[i];
                }
            }
        }
        Point3D firstIntersectionPoint = intersectionLineAndPlane(coordinatePlane, pointsOfParallelPlane[0], oppositeVertexOfParallelPlane).get();
        if (firstIntersectionPoint == null) {
            throw new WrongTetrahedronParametersException("Coordinate plane does not intersect tetrahedron");
        }
        Point3D secondIntersectionPoint = intersectionLineAndPlane(coordinatePlane, pointsOfParallelPlane[1], oppositeVertexOfParallelPlane).get();
        //counting side length of triangle at the base
        Double firstSquare = Math.pow(firstIntersectionPoint.getX() - secondIntersectionPoint.getX(), 2);
        Double secondSquare = Math.pow(firstIntersectionPoint.getY() - secondIntersectionPoint.getY(), 2);
        Double thirdSquare = Math.pow(firstIntersectionPoint.getZ() - secondIntersectionPoint.getZ(), 2);
        Double sideLengthOfTriangle = Math.sqrt(firstSquare + secondSquare + thirdSquare);
        Double surfaceAreaOfTriangleAtTheBase = Math.pow(sideLengthOfTriangle, 2) * Math.sqrt(3) / 4.;
        Double heightOfNewTetrahedron = null;
        switch (coordinatePlane) {
            case YZ_PLANE -> {
                heightOfNewTetrahedron = Math.abs(oppositeVertexOfParallelPlane.getX());
            }
            case ZX_PLANE -> {
                heightOfNewTetrahedron = Math.abs(oppositeVertexOfParallelPlane.getY());
            }
            case XY_PLANE -> {
                heightOfNewTetrahedron = Math.abs(oppositeVertexOfParallelPlane.getZ());
            }
        }
        Double volumeOfNewTetrahedron = heightOfNewTetrahedron * surfaceAreaOfTriangleAtTheBase;
        Double volumeOfBaseTetrahedron = countVolume(tetrahedron);
        return new Ratio(volumeOfNewTetrahedron, volumeOfBaseTetrahedron);
    }

    private Optional<Point3D> intersectionLineAndPlane(CoordinatePlane coordinatePlane, Point3D firstLinePoint, Point3D secondLinePoint) {
        Double firstDenominatorOfCanonicalEquation = secondLinePoint.getX() - firstLinePoint.getX();
        Double secondDenominatorOfCanonicalEquation = secondLinePoint.getY() - firstLinePoint.getY();
        Double thirdDenominatorOfCanonicalEquation = secondLinePoint.getZ() - firstLinePoint.getZ();
        Double matrixOfEquation[][] = new Double[3][3];
        // first equation
        matrixOfEquation[0][0] = secondDenominatorOfCanonicalEquation;
        matrixOfEquation[0][1] = -firstDenominatorOfCanonicalEquation;
        matrixOfEquation[0][2] = 0.;
        // second equation
        matrixOfEquation[1][0] = 0.;
        matrixOfEquation[1][1] = -thirdDenominatorOfCanonicalEquation;
        matrixOfEquation[1][2] = secondDenominatorOfCanonicalEquation;
        // third equation (of coordinate plane)
        switch (coordinatePlane) {
            case XY_PLANE -> {
                matrixOfEquation[2][0] = 0.;
                matrixOfEquation[2][1] = 0.;
                matrixOfEquation[2][2] = 1.;
            }
            case YZ_PLANE -> {
                matrixOfEquation[2][0] = 1.;
                matrixOfEquation[2][1] = 0.;
                matrixOfEquation[2][2] = 0.;
            }
            case ZX_PLANE -> {
                matrixOfEquation[2][0] = 0.;
                matrixOfEquation[2][1] = 1.;
                matrixOfEquation[2][2] = 0.;
            }
        }
        Double determinant = countDeterminant(matrixOfEquation);
        if (determinant == 0.) {
            return Optional.empty();
        }
        Double firstLinePointX = firstLinePoint.getX();
        Double firstLinePointY = firstLinePoint.getY();
        Double firstLinePointZ = firstLinePoint.getZ();
        Double constantOfFirstEquation = -secondDenominatorOfCanonicalEquation * firstLinePointX + firstDenominatorOfCanonicalEquation * firstLinePointY;
        Double constantOfSecondEquation = -secondDenominatorOfCanonicalEquation * firstLinePointZ + thirdDenominatorOfCanonicalEquation * firstLinePointY;
        //building matrices using Сramer method for each coordinate
        Double matrixForXCoordinate[][] = matrixOfEquation.clone();
        matrixForXCoordinate[0][0] = constantOfFirstEquation;
        matrixForXCoordinate[0][1] = constantOfSecondEquation;
        matrixForXCoordinate[0][2] = 0.;
        Double intersectionPointX = countDeterminant(matrixForXCoordinate);

        Double matrixForYCoordinate[][] = matrixOfEquation.clone();
        matrixForXCoordinate[1][0] = constantOfFirstEquation;
        matrixForXCoordinate[1][1] = constantOfSecondEquation;
        matrixForXCoordinate[1][2] = 0.;
        Double intersectionPointY = countDeterminant(matrixForXCoordinate);

        Double matrixForZCoordinate[][] = matrixOfEquation.clone();
        matrixForXCoordinate[2][0] = constantOfFirstEquation;
        matrixForXCoordinate[2][1] = constantOfSecondEquation;
        matrixForXCoordinate[2][2] = 0.;
        Double intersectionPointZ = countDeterminant(matrixForXCoordinate);
        return Optional.of(new Point3D(intersectionPointX, intersectionPointY, intersectionPointZ));
    }

    private Double countDeterminant(Double matrix[][]) {
        Double determinant = matrix[0][0] * matrix[1][1] * matrix[2][2];
        determinant += matrix[0][1] * matrix[1][2] * matrix[2][0];
        determinant += matrix[0][2] * matrix[1][0] * matrix[2][1];
        determinant -= matrix[0][2] * matrix[1][1] * matrix[0][2];
        determinant -= matrix[0][0] * matrix[1][2] * matrix[2][1];
        determinant -= matrix[0][1] * matrix[1][0] * matrix[2][2];
        return determinant;
    }
}
