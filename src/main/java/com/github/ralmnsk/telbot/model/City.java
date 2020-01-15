package com.github.ralmnsk.telbot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="city")
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
private Long id;
    @Column(name="name")
private String name;
    @Column(name="info",columnDefinition = "TEXT")
private String info;

    public City() {
    }

    public City(Long id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public City(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
