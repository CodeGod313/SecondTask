package edu.epam.secondtask.service;

import edu.epam.secondtask.entity.CoordinatePlane;
import edu.epam.secondtask.entity.Ratio;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.exception.WrongTetrahedronParametersException;

public interface RegularTetrahedronService {
    Double countSurfaceArea(Tetrahedron tetrahedron);

    Double countVolume(Tetrahedron tetrahedron);

    Double countSideLength(Tetrahedron tetrahedron);

    Ratio countValuesRatioOfIntersectedByCoordinatePlaneTetrahedron(Tetrahedron tetrahedron, CoordinatePlane coordinatePlane) throws WrongTetrahedronParametersException;
}
