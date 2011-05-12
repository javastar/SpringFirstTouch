package lv.courses.spring.database;

import lv.courses.spring.entities.MyEntity;

import java.util.ArrayList;
import java.util.List;

public class MockDatabase implements Database {

    private long pk = 0;
    private List<MyEntity> myEntities = new ArrayList<MyEntity>();


    public void saveEntity(MyEntity myEntity) {
        myEntity.setPk(pk++);
        myEntities.add(myEntity);
    }

    public List<MyEntity> getAllEntities() {
        return myEntities;
    }

}
