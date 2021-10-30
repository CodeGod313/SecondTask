package edu.epam.secondtask.repository;

import edu.epam.secondtask.comparator.TetrahedronIdComparator;
import edu.epam.secondtask.comparator.TetrahedronNameComparator;
import edu.epam.secondtask.entity.Tetrahedron;
import edu.epam.secondtask.repository.specification.TetrahedronSpecification;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class TetrahedronRepository {
    List<Tetrahedron> tetrahedrons;

    public boolean add(Tetrahedron tetrahedron) {
        return tetrahedrons.add(tetrahedron);
    }

    public boolean remove(Object o) {
        return tetrahedrons.remove(o);
    }

    public boolean addAll(@NotNull Collection<? extends Tetrahedron> c) {
        return tetrahedrons.addAll(c);
    }

    public void clear() {
        tetrahedrons.clear();
    }

    public Tetrahedron get(int index) {
        return tetrahedrons.get(index);
    }

    public Tetrahedron set(int index, Tetrahedron element) {
        return tetrahedrons.set(index, element);
    }

    public void add(int index, Tetrahedron element) {
        tetrahedrons.add(index, element);
    }

    public Tetrahedron remove(int index) {
        return tetrahedrons.remove(index);
    }

    public List<Tetrahedron> query(TetrahedronSpecification specification){
        return tetrahedrons
                .stream()
                .filter(x->specification.specify(x))
                .toList();
    }
    List<Tetrahedron> sortById(){
        return tetrahedrons
                .stream()
                .sorted(new TetrahedronIdComparator())
                .toList();
    }
    List<Tetrahedron> sortByName(){
        return tetrahedrons
                .stream()
                .sorted(new TetrahedronNameComparator())
                .toList();
    }
}
