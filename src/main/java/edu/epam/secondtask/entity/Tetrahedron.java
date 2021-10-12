package edu.epam.secondtask.entity;

import edu.epam.secondtask.exception.WrongTetrahedronParametersException;

import java.util.Arrays;
import java.util.Objects;

public class Tetrahedron {
    Point3D[] vertexes;
    static Long idGenerationSeed = 0l;
    Long id;
    String name;

    public Tetrahedron(Point3D[] vertexes, String name) {
        this.vertexes = vertexes.clone();
        this.name = name;
        id = idGenerationSeed++;
    }

    public Point3D[] getVertexes() {
        return vertexes.clone();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return Arrays.equals(vertexes, that.vertexes) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(vertexes);
        return result;
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "vertexes=" + Arrays.toString(vertexes) +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}