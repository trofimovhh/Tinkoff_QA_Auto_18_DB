package ru.fintech.qa.homework.utils.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public final class Animal {
    @Id
    private int id;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "\"type\"")
    private int type;
    @Column(name = "sex")
    private int sex;
    @Column(name = "place")
    private int place;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(final int type) {
        this.type = type;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(final int sex) {
        this.sex = sex;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(final int place) {
        this.place = place;
    }
}

//    executeUpdate("CREATE TABLE public.animal (\n"
//                          + "\tid int4 NOT NULL,\n"
//                          + "\t\"name\" varchar NULL,\n"
//                          + "\tage int4 NULL,\n"
//                          + "\t\"type\" int4 NULL,\n"
//                          + "\tsex int4 NULL,\n"
//                          + "\tplace int4 NULL,\n"
//                          + "\tCONSTRAINT animal_pk PRIMARY KEY (id),\n"
//                          + "\tCONSTRAINT animal_fk FOREIGN KEY (\"type\") REFERENCES public.\"types\"(id),\n"
//                          + "\tCONSTRAINT animal_fk_1 FOREIGN KEY (sex) REFERENCES public.sex(id),\n"
//                          + "\tCONSTRAINT animal_fk_2 FOREIGN KEY (place) REFERENCES public.places(id) DEFERRABLE\n"
//                          + ");");