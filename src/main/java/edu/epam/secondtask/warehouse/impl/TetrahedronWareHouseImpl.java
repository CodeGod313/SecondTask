package edu.epam.secondtask.warehouse.impl;

import edu.epam.secondtask.entity.TetrahedronWareHouseElement;
import edu.epam.secondtask.warehouse.TetrahedronWareHouse;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TetrahedronWareHouseImpl implements TetrahedronWareHouse {
    Map<UUID, TetrahedronWareHouseElement> wareHouseElementMap;
    private static TetrahedronWareHouse instance;

    private TetrahedronWareHouseImpl() {
        this.wareHouseElementMap = new HashMap<>();
    }

    public static TetrahedronWareHouse getInstance(){
        if(instance == null){
            instance = new TetrahedronWareHouseImpl();
        }
        return instance;
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

    public boolean remove(Object key, Object value) {
        return wareHouseElementMap.remove(key, value);
    }

    public TetrahedronWareHouseElement replace(UUID key, TetrahedronWareHouseElement value) {
        return wareHouseElementMap.replace(key, value);
    }
}
