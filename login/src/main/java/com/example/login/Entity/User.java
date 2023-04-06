package com.example.login.Entity;

import jakarta.persistence.*;

@Entity
@Table(name= "user")
public class User {

    @Id
    @Column(name = "User_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "User_name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name= "password")
    private String password;
    public User(int id, String name, String email, String password){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public User(){
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

