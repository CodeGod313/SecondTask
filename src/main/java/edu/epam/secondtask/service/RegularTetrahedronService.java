package edu.epam.secondtask.service;

import edu.epam.secondtask.entity.CoordinatePlane;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.exception.WrongPlaneParametersException;
import edu.epam.secondtask.exception.WrongTetrahedronParametersException;

public interface RegularTetrahedronService {
    Double countSurfaceArea(Tetrahedron tetrahedron);
    Double countVolume(Tetrahedron tetrahedron);
    Double countSideLength(Tetrahedron tetrahedron);
    Double countValuesRatioOfIntersectedByCoordinatePlaneTetrahedron(Tetrahedron tetrahedron, CoordinatePlane coordinatePlane) throws WrongPlaneParametersException, WrongTetrahedronParametersException;
}
