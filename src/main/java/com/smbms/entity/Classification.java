package com.smbms.entity;

public class Classification {
    private Integer id;

    private String name;

    public Classification(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Classification() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}