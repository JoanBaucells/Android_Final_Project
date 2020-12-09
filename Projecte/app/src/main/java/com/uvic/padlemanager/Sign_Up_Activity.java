package com.uvic.padlemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.uvic.padlemanager.Entitats.Competidor;
import com.uvic.padlemanager.Entitats.User;
import com.uvic.padlemanager.Singleton.App_singleton;
import com.uvic.padlemanager.ui.login.LoginActivity;

public class Sign_Up_Activity extends AppCompatActivity {

    private int idCompetidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);
        this.idCompetidor = App_singleton.getInstance().getList_competidors().size();
    }

    public void signUp(View view){
        User u;
        Competidor c;
        EditText username = (EditText)findViewById(R.id.signup_username);
        EditText password = (EditText) findViewById(R.id.signup_password);
        EditText email = (EditText) findViewById(R.id.signup_email);
        EditText name = (EditText)findViewById(R.id.signup_name);
        EditText cognom = (EditText)findViewById(R.id.signup_surname);
        EditText phone = (EditText)findViewById(R.id.signup_telefon);

        u = new User(username.getText().toString(), password.getText().toString(), "User");
        c = new Competidor(name.getText().toString(), cognom.getText().toString(), phone.getText().toString(), email.getText().toString(), this.idCompetidor+1);

        App_singleton.getInstance().addUser(u);
        App_singleton.getInstance().addCompetidor(c);

        Intent intent = new Intent(Sign_Up_Activity.this, Usuaris.class);
        startActivity(intent);
        finish();
    }
}