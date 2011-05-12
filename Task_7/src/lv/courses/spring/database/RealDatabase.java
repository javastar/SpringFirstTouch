package lv.courses.spring.database;

import lv.courses.spring.entities.MyEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;


public class RealDatabase implements Database {

    private HibernateTemplate hibernateTemplate;

    public RealDatabase(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void saveEntity(MyEntity entity) {
        hibernateTemplate.save(entity);
    }

    public List<MyEntity> getAllEntities() {
        return hibernateTemplate.find("from MyEntity");
    }

    public void throwException() {
        throw new RuntimeException("DATABASE UNHANDLED EXCEPTION");
    }

}
