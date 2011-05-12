package lv.courses.spring.database;

import lv.courses.spring.entities.MyEntity;
import java.util.List;


public class RealDatabase implements Database {

    public void saveEntity(MyEntity entity) {
        throw new RuntimeException("NOT IMPLEMENTED YET!");
    }

    public List<MyEntity> getAllEntities() {
        throw new RuntimeException("NOT IMPLEMENTED YET!");
    }

}
