package edu.epam.secondtask.event;

import edu.epam.secondtask.entity.Tetrahedron;

import java.util.EventObject;

public class TetrahedronEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TetrahedronEvent(Object source) {
        super(source);
    }

    @Override
    public Tetrahedron getSource() {
        return (Tetrahedron) super.getSource();
    }
}
