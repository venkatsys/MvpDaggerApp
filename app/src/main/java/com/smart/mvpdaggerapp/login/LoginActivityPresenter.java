package com.smart.mvpdaggerapp.login;

import android.support.annotation.Nullable;

public class LoginActivityPresenter  implements LoginActivityMVP.Presenter {

    @Nullable
    private  LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;


    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if(view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.ShowInputError();
            } else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.ShowUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if(user == null) {
            if (view != null) {
                view.ShowUserNotAvailable();
            }
        } else {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }
    }
}
