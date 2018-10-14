package com.example.xxaemaethxx.cs354final;

public class Contact {
    int id;
    String Name;
    String Email;
    String Username;
    String Password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId () {
        return this.id;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }

    public void setPass(String pass) {
        this.Password = pass;
    }
    public String getPass() {
        return this.Password;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getUsername() {
        return this.Username;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
    public String getEmail() {
        return this.Email;
    }
}
