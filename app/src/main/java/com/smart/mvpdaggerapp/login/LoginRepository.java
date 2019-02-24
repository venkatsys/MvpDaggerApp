package com.smart.mvpdaggerapp.login;

public interface LoginRepository {
    User getUser();
    void saveUser(User user);
}
