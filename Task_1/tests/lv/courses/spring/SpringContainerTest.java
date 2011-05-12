package lv.courses.spring;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.assertNotNull;


@RunWith(JUnit4.class)
public class SpringContainerTest {

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

}
