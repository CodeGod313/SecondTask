package edu.epam.secondtask.filter.impl;

import edu.epam.secondtask.filter.TetrahedronFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TetrahedronsFilterImplTest {

    TetrahedronFilter tetrahedronsFilter;

    @BeforeAll
    public void setUp() {
        tetrahedronsFilter = new TetrahedronsFilterImpl();
    }

    @Test
    void filterTetrahedrons() {
        List<String> data = List.of("HelloThere 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1", "HelloThere 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2");
        List<String> expected = List.of("HelloThere 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1");
        List<String> actual = tetrahedronsFilter.filterTetrahedrons(data);
        Assertions.assertEquals(expected, actual);
    }
}