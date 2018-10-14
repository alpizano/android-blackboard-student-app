package com.example.xxaemaethxx.cs354final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private Button SignUp;
    private TextView Info;
    private int counter = 5;

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instance variables
        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);

        Login = (Button) findViewById(R.id.btnLogin);
        SignUp = (Button) findViewById(R.id.btnSignUp);
        Info = (TextView) findViewById(R.id.tvInfo);

        Info.setText("Number of attempts remaining: 5");

        // creating onClickListener when login button is clicked to run validate method
       /*
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
        */
    }


    public void loginPressed(View v) {
        String name = Name.getText().toString();
        String password = Password.getText().toString();

        String returnedPass = helper.searchPass(name);

        if(password.equals(returnedPass)) {
            Intent intent = new Intent(MainActivity.this, WelcomeScreen.class);
            intent.putExtra("NAME", Name.getText().toString());
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Username and password don't match!", Toast.LENGTH_SHORT).show();
        }


    }

    public void signupPressed(View v) {
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);
    }

        // validate method for preset username + password
    /*
    private void validate(String userName, String userPassword) {
        if (userName.equals("Admin") && userPassword.equals("1234"))
        {
            Intent intent = new Intent(MainActivity.this, WelcomeScreen.class);
            intent.putExtra("NAME", Name.getText().toString());
            startActivity(intent);
        }
    else
        {
            counter--;
            Info.setText("Number of attempts remaining: " + counter);
        }
        if (counter == 0){
            Login.setEnabled(false);
        }
    }
   */
}