package lv.courses.spring.entities;

public class MyEntity {

    private Long pk;
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
