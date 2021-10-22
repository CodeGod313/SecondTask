package edu.epam.secondtask.observer.impl;

import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.event.TetrahedronEvent;
import edu.epam.secondtask.observer.Observer;

public class TetrahedronObserver implements Observer {
    @Override
    public void parameterChanged(TetrahedronEvent tetrahedronEvent) {
        Tetrahedron tetrahedron = tetrahedronEvent.getSource();

    }
}
