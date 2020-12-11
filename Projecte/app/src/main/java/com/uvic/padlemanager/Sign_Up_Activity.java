package com.uvic.padlemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uvic.padlemanager.Entitats.Competidor;
import com.uvic.padlemanager.Entitats.User;
import com.uvic.padlemanager.Singleton.App_singleton;

public class Sign_Up_Activity extends AppCompatActivity {

    private int idCompetidor;
    private EditText editPassword;
    private EditText editConfirmPassword;
    private EditText editName;
    private EditText editUsername;
    private EditText editSurname;
    private EditText editPhone;
    private EditText editEmail;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);
        this.idCompetidor = App_singleton.getInstance().getList_competidors().size();
        editConfirmPassword = (EditText)findViewById(R.id.signup_confirmpassword);
        editPassword = (EditText)findViewById(R.id.signup_password);
        editName = (EditText)findViewById(R.id.signup_name);
        editSurname = (EditText)findViewById(R.id.signup_surname);
        editUsername = (EditText)findViewById(R.id.signup_username);
        editPhone = (EditText)findViewById(R.id.signup_telefon);
        editEmail = (EditText)findViewById(R.id.signup_email);
        btnSignup = (Button) findViewById(R.id.signup_signup);

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                btnSignup.setEnabled(validatePassword(editPassword.getText().toString(), editConfirmPassword.getText().toString()));
            }
        };
        editPassword.addTextChangedListener(afterTextChangedListener);
        editConfirmPassword.addTextChangedListener(afterTextChangedListener);
        editName.addTextChangedListener(afterTextChangedListener);
        editEmail.addTextChangedListener(afterTextChangedListener);
        editUsername.addTextChangedListener(afterTextChangedListener);
        editPhone.addTextChangedListener(afterTextChangedListener);
        editSurname.addTextChangedListener(afterTextChangedListener);

    }

    public boolean validatePassword(String password, String confirmPassword) {
        boolean bValidacions = true;
        if(editUsername.getText().toString().equals("")){
            bValidacions = false;
        }
        if(userExist(editUsername.getText().toString())){
           editUsername.setError("User already exist!!");
            bValidacions = false;
        }
        if(editName.getText().toString().equals("")) {
            bValidacions = false;
        }
        if(editSurname.getText().toString().equals("")){
            bValidacions = false;
        }
        if(editEmail.getText().toString().equals("")){
            bValidacions = false;
        }
        if(editPhone.getText().toString().equals("")){
            bValidacions = false;
        }
        if (!isPasswordValid(password)) {
            editPassword.setError(getString(R.string.invalid_password));
            bValidacions = false;
        }else if(!isSamePassword(password, confirmPassword)){
            editConfirmPassword.setError("The passwords must be the same.");
            bValidacions = false;
        }
        if(password.equals("")){
            bValidacions = false;
        }
        if(confirmPassword.equals("")){
            bValidacions = false;
        }

        return bValidacions;
    }


    private boolean userExist(String username){
        boolean bExist = false;
        for (User user: App_singleton.getInstance().getList_users()) {
            if(user.getUsername().equals(username)){
                bExist = true;
                break;
            }
        }
        return bExist;
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    // A placeholder password validation check
    private boolean isSamePassword(String password, String confirmPassword) {
        boolean bSame = false;
        if(password.equals(confirmPassword)){
            bSame = true;
        }else{
            bSame = false;
        }
        return bSame;
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
        App_singleton.getInstance().setUser(u);

        Intent intent = new Intent(Sign_Up_Activity.this, Usuaris.class);
        startActivity(intent);
        finish();
    }
}