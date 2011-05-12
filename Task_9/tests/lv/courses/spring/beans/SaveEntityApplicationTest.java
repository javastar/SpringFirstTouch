package lv.courses.spring.beans;

import lv.courses.spring.database.Database;
import lv.courses.spring.entities.MyEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class SaveEntityApplicationTest {

    private SaveEntityApplication app = new SaveEntityApplication();

    @Mock private Database dbMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(app, "database", dbMock);
    }

    @Test
    public void save() {
        MyEntity entity = new MyEntity();
        app.save(entity);
        Mockito.verify(dbMock, times(1)).saveEntity(entity);
    }

}
