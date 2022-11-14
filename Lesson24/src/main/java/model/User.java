package model;

import java.util.Date;

public class User {

    private String name;
    private String password;
    private long id;
    private Date createdAt;

    public User(Long id, String name, String password, Date createdAt) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", createdAt=" + createdAt +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }
}
