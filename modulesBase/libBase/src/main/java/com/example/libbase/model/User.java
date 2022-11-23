package com.example.libbase.model;

import java.io.Serializable;

/**
 * @author AlexisYin
 */
public class User implements Serializable {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
