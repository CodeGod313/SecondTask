package edu.epam.secondtask.observer.impl;

import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.entity.TetrahedronWareHouseElement;
import edu.epam.secondtask.event.TetrahedronEvent;
import edu.epam.secondtask.observer.Observer;
import edu.epam.secondtask.service.RegularTetrahedronService;
import edu.epam.secondtask.service.impl.RegularTetrahedronServiceImpl;
import edu.epam.secondtask.validator.TetrahedronValidator;
import edu.epam.secondtask.validator.impl.TetrahedronValidatorImpl;
import edu.epam.secondtask.warehouse.TetrahedronWareHouse;

public class TetrahedronObserver implements Observer {
    @Override
    public void parameterChanged(TetrahedronEvent tetrahedronEvent) {
        Tetrahedron tetrahedron = tetrahedronEvent.getSource();
        TetrahedronWareHouse tetrahedronWareHouse = TetrahedronWareHouse.getInstance();
        TetrahedronValidator tetrahedronValidator = new TetrahedronValidatorImpl();
        if (!tetrahedronValidator.isRegular(tetrahedron)) {
            tetrahedronWareHouse.remove(tetrahedron.getId());
            return;
        }
        RegularTetrahedronService regularTetrahedronService = new RegularTetrahedronServiceImpl();
        Double volume = regularTetrahedronService.countVolume(tetrahedron);
        Double surfaceArea = regularTetrahedronService.countSurfaceArea(tetrahedron);
        Double sideLength = regularTetrahedronService.countSideLength(tetrahedron);
        TetrahedronWareHouseElement tetrahedronWareHouseElement = new TetrahedronWareHouseElement(sideLength, volume, surfaceArea);
        tetrahedronWareHouse.replace(tetrahedron.getId(), tetrahedronWareHouseElement);
    }
}
