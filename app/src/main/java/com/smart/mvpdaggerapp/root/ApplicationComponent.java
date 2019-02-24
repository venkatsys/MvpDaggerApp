package com.smart.mvpdaggerapp.root;

import com.smart.mvpdaggerapp.login.BaseActivity;
import com.smart.mvpdaggerapp.login.LoginActivity;
import com.smart.mvpdaggerapp.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class , LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
