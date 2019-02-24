package com.smart.mvpdaggerapp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smart.mvpdaggerapp.R;
import com.smart.mvpdaggerapp.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View, View.OnClickListener {

    @Inject
    LoginActivityMVP.Presenter presenter;


    private EditText firstName;
    private EditText lastName;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

        firstName = this.findViewById(R.id.loginActivity_firstName_editText);
        lastName = this.findViewById(R.id.loginActivity_lastName_editText);
        login= this.findViewById(R.id.loginActivity_login_button);

        login.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void ShowUserNotAvailable() {
        Toast.makeText(this,"Error the user is not available" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowInputError() {
        Toast.makeText(this,"FirstName or LastName cannot be empty" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowUserSavedMessage() {
        Toast.makeText(this,"User Saved!" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String fname) {
        firstName.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        lastName.setText(lname);
    }

    @Override
    public void onClick(View view) {
        presenter.loginButtonClicked();
    }
}
