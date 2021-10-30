package edu.epam.secondtask.validator.impl;

import edu.epam.secondtask.entity.Point3D;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.validator.TetrahedronValidator;

public class TetrahedronValidatorImpl implements TetrahedronValidator {
    @Override
    public boolean isRegular(Tetrahedron tetrahedron) {
        Point3D points[] = tetrahedron.getVertexes();
        Double firstSideLength = countSideLength(points[0], points[1]);
        Double secondSideLength = countSideLength(points[1], points[2]);
        Double thirdSideLength = countSideLength(points[0], points[2]);
        Double fourthSideLength = countSideLength(points[2], points[3]);
        return firstSideLength.equals(secondSideLength) && secondSideLength.equals(thirdSideLength) && thirdSideLength.equals(fourthSideLength);
    }

    private Double countSideLength(Point3D firstPoint, Point3D secondPoint) {
        Double firstSquare = Math.pow(firstPoint.getX() - secondPoint.getX(), 2);
        Double secondSquare = Math.pow(firstPoint.getY() - secondPoint.getY(), 2);
        Double thirdSquare = Math.pow(firstPoint.getZ() - secondPoint.getZ(), 2);
        return Math.sqrt(firstSquare + secondSquare + thirdSquare);
    }
}
