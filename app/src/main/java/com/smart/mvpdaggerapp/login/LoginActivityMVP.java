package com.smart.mvpdaggerapp.login;

public interface LoginActivityMVP {

    interface View{
        String getFirstName();
        String getLastName();

        void ShowUserNotAvailable();
        void ShowInputError();
        void ShowUserSavedMessage();

        void setFirstName(String fname);
        void setLastName(String lname);
    }

    interface Presenter{
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }

    interface Model{
        void createUser(String fname, String lname);
        User getUser();
    }
}
