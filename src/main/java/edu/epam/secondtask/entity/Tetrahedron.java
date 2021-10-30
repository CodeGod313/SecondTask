package edu.epam.secondtask.entity;

import edu.epam.secondtask.event.TetrahedronEvent;
import edu.epam.secondtask.observer.impl.TetrahedronObserver;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class Tetrahedron implements Observable {
    Point3D[] vertexes;
    UUID id;
    String name;
    TetrahedronObserver tetrahedronObserver = new TetrahedronObserver();

    public Tetrahedron(Point3D[] vertexes, String name) {
        this.vertexes = vertexes.clone();
        this.name = name;
        id = UUID.randomUUID();
    }

    public void setVertexes(Point3D[] vertexes) {
        this.vertexes = vertexes.clone();
    }

    public Point3D[] getVertexes() {
        return vertexes.clone();
    }

    public UUID getId() {
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
        return new StringJoiner(", ", Tetrahedron.class.getSimpleName() + "[", "]")
                .add("vertexes=" + Arrays.toString(vertexes))
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }

    @Override
    public void notifyObserver() {
        TetrahedronEvent event = new TetrahedronEvent(this);
        tetrahedronObserver.parameterChanged(event);
    }
}