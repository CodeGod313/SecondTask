package edu.epam.secondtask.filter.impl;

import edu.epam.secondtask.filter.TetrahedronFilter;

import java.util.List;

public class TetrahedronsFilterImpl implements TetrahedronFilter {

    public static final String REGEX_TETRAHEDRON = "\\s*[a-zA-Z]+\\s+\\d+\\.?\\d*\\s+\\d+\\.?\\d*\\s+\\d+\\.?\\d*\\s*";

    @Override
    public List<String> filterTetrahedrons(List<String> lines) {
        return lines.stream()
                .filter(x -> x.matches(REGEX_TETRAHEDRON))
                .toList();
    }
}
