package edu.epam.secondtask.comparator;

import edu.epam.secondtask.entity.Tetrahedron;

import java.util.Comparator;

public class TetrahedronIdComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
