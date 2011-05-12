package lv.courses.spring.database;

import lv.courses.spring.entities.MyEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class RealDatabase implements Database {

    private SessionFactory sessionFactory;


    public RealDatabase(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveEntity(MyEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public List<MyEntity> getAllEntities() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from MyEntity");
        return query.list();
    }

}
