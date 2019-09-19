package com.pereverzew.model;

import lombok.Data;

@Data
public class User {
    private String login;
    private String password;
    private String info;

    public User(String login) {
        this.login = login;
    }

    public User(String login, String password, String info) {
        this.login = login;
        this.password = password;
        this.info = info;
    }
}
