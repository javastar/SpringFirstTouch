package lv.courses.spring.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ENTITIES")
public class MyEntity {

    @Id
    @GeneratedValue
    @Column(name="PK")
    private Long pk;

    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "MyEntity[pk=" + pk + " name=" + name + "]";
    }

}
