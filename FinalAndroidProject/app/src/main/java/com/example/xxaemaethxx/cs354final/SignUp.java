package com.example.xxaemaethxx.cs354final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Username;
    private EditText Password;
    private EditText ConfPassword;
    private Button SignUp;



    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name = (EditText) findViewById(R.id.etName);
        Email = (EditText) findViewById(R.id.etEmail);
        Username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        ConfPassword = (EditText) findViewById(R.id.etConfPassword);
        SignUp = (Button) findViewById(R.id.btnSignUp);
    }

    // stores Strings from text fields into variables
    String sName = Name.getText().toString();
    String sEmail = Email.getText().toString();
    String sUsername = Username.getText().toString();
    String sPassword = Password.getText().toString();

        public void buttonPressed (View view){
            if (Password.getText().toString().equals(ConfPassword.getText().toString())) {
                //insert details into database
                Contact c = new Contact();
                c.setName(sName);
                c.setEmail(sEmail);
                c.setUsername(sUsername);
                c.setPassword(sPassword);

                helper.insertContact(c);
            } else {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            }
        }
    }

