package lv.courses.spring.beans;

import lv.courses.spring.database.Database;
import lv.courses.spring.entities.MyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaveEntityApplication {

    @Autowired
    private Database database;


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
