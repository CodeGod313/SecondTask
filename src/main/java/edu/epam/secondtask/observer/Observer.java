package edu.epam.secondtask.observer;

import edu.epam.secondtask.event.TetrahedronEvent;

public interface Observer {
    void parameterChanged(TetrahedronEvent tetrahedronEvent);
}
