package edu.epam.secondtask.warehouse;

import edu.epam.secondtask.entity.TetrahedronWareHouseElement;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TetrahedronWareHouse {
    Map<UUID, TetrahedronWareHouseElement> wareHouseElementMap;
    private static TetrahedronWareHouse instance;

    private TetrahedronWareHouse() {
        this.wareHouseElementMap = new HashMap<>();
    }

    public static TetrahedronWareHouse getInstance() {
        if (instance == null) {
            instance = new TetrahedronWareHouse();
        }
        return instance;
    }

    public TetrahedronWareHouseElement remove(Object key) {
        return wareHouseElementMap.remove(key);
    }

    public TetrahedronWareHouseElement get(Object key) {
        return wareHouseElementMap.get(key);
    }

    public TetrahedronWareHouseElement put(UUID key, TetrahedronWareHouseElement value) {
        return wareHouseElementMap.put(key, value);
    }

    public void putAll(@NotNull Map<? extends UUID, ? extends TetrahedronWareHouseElement> m) {
        wareHouseElementMap.putAll(m);
    }

    public void clear() {
        wareHouseElementMap.clear();
    }

    public TetrahedronWareHouseElement replace(UUID key, TetrahedronWareHouseElement value) {
        return wareHouseElementMap.replace(key, value);
    }
}
