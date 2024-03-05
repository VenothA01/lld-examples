package com.dailycoder.parkinglot.model.accounts;

public class Account {

    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void resetPassword(String newPassword){
        this.password = newPassword;
    }
}
