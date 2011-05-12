package lv.courses.spring.database;

import lv.courses.spring.entities.MyEntity;

import java.util.ArrayList;
import java.util.List;


public class MockDatabase implements Database {

    private long pk = 0;
    private List<MyEntity> entities = new ArrayList<MyEntity>();


    public void saveEntity(MyEntity entity) {
        entity.setPk(pk++);
        entities.add(entity);
    }

    public List<MyEntity> getAllEntities() {
        return entities;
    }

    public void throwException() {
        throw new RuntimeException("DATABASE UNHANDLED EXCEPTION");
    }

}
