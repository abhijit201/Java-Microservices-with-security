package com.olx.masterdata.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADV_STATUS")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    public StatusEntity() {

    }

    public StatusEntity(String name) {
        this.name = name;
    }

    public StatusEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
