package lv.courses.spring.database;

import lv.courses.spring.entities.MyEntity;

import java.util.List;

public interface Database {

    void saveEntity(MyEntity myEntity);

    List<MyEntity> getAllEntities();

    void throwException();

}
