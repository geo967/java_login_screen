package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText userName,password;
    ImageButton createAccountButton;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        userName=findViewById(R.id.username_editText);
        password=findViewById(R.id.password_editText);
        loginButton=findViewById(R.id.login_button);
        createAccountButton=findViewById(R.id.create_account_button);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,CreateNewAccountActivity.class);
                startActivity(intent);

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials(userName.getText().toString().trim(),password.getText().toString().trim());
            }
        });
    }

    public void checkCredentials(String userName,String password){
        Database db=new Database();
        HashMap<String,String> hm;
        hm=db.getLoginDetails();
        String obtainedPassword=hm.get(userName);
        if(password.equals(obtainedPassword)){

            Intent intent=new Intent(LoginActivity.this,FirstActivity.class);
            startActivity(intent);
        }
        else {
            showSnackBar();
        }
    }

    public void showSnackBar(){
        relativeLayout=findViewById(R.id.relative_layout);
        Snackbar snackbar=Snackbar.make(relativeLayout,"Invalid Credentials",Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}