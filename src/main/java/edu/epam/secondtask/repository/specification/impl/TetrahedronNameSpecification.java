package edu.epam.secondtask.repository.specification.impl;

import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.repository.specification.TetrahedronSpecification;

public class TetrahedronNameSpecification implements TetrahedronSpecification {
    String name;

    public TetrahedronNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        return tetrahedron.getName().equals(name);
    }
}
