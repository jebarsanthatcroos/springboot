package org.example.springboot.model;

public class user {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public user(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    private  String email;
}
