package lv.courses.spring.beans;

import lv.courses.spring.database.Database;
import lv.courses.spring.entities.MyEntity;


public class SaveEntityApplication {

    private Database database;


    public SaveEntityApplication(Database database) {
        this.database = database;
    }


    public void save(MyEntity entity) {
        if(isEntityValid(entity)) {
            database.saveEntity(entity);
        }
        else {
            throw new IllegalArgumentException("Entity with PK is invalid!");
        }
    }

    private boolean isEntityValid(MyEntity entity) {
        return entity.getPk() == null;
    }

}
