package lv.courses.spring;

import lv.courses.spring.database.Database;
import lv.courses.spring.entities.MyEntity;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class SpringContextConfigurationTest {

    private static Logger logger = Logger.getLogger(SpringContextConfigurationTest.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void checkSpring() {
        assertNotNull(applicationContext);
    }

    @Test
    public void checkDatabaseBean() {
        Database database = applicationContext.getBean(Database.class);
        assertNotNull(database);
        database = (Database) applicationContext.getBean("database");
        assertNotNull(database);
    }

    @Test
    public void saveEntityToDatabase() {
        Database database = applicationContext.getBean(Database.class);
        MyEntity entity = createEntity(1L, "Name_1");
        database.saveEntity(entity);
        entity = createEntity(2L, "Name_2");
        database.saveEntity(entity);

        List<MyEntity> entities = database.getAllEntities();
        for(MyEntity myEntity : entities) {
            logger.info(myEntity.toString());
        }
    }

    private MyEntity createEntity(Long pk, String name) {
        MyEntity entity = new MyEntity();
        entity.setPk(pk);
        entity.setName(name);
        return entity;
    }

}
