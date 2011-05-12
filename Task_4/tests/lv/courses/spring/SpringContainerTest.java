package lv.courses.spring;

import lv.courses.spring.beans.SaveEntityApplication;
import lv.courses.spring.database.Database;
import lv.courses.spring.entities.MyEntity;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.fail;


@RunWith(JUnit4.class)
public class SpringContainerTest {

    private static Logger  logger = Logger.getLogger(SpringContainerTest.class);

    private static ApplicationContext applicationContext;


    @BeforeClass
    public static void loadSpring() {
        applicationContext =
            new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
    }

    @Test
    public void checkSpring() {
        assertNotNull(applicationContext);
    }

    @Test
    public void checkDatabaseBean() {
        Database database = applicationContext.getBean(Database.class);
        assertNotNull(database);
        database = (Database) applicationContext.getBean("mockDatabase");
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


    @Test
    public void saveEntityWithApplication() {
        SaveEntityApplication application = applicationContext.getBean(SaveEntityApplication.class);
        MyEntity entity = createEntity(1L, "Name_1");

        try {
            application.save(entity);
            fail();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        entity.setPk(null);
        application.save(entity);
    }


    private MyEntity createEntity(Long pk, String name) {
        MyEntity entity = new MyEntity();
        entity.setPk(pk);
        entity.setName(name);
        return entity;
    }

}
