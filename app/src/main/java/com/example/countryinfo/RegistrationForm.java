package com.example.countryinfo;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationForm extends AppCompatActivity {

    private EditText emailTextView, passwordTextView;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form_activity);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        button = findViewById(R.id.aboutMeButtonRegister);
        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.passwd);
        Button btn = findViewById(R.id.btnregister);
        progressbar = findViewById(R.id.progressbar);

        // Set on Click Listener on Registration button
        btn.setOnClickListener(v -> registerNewUser());

        button.setOnClickListener(v -> {
            Intent back = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(back);
        });
    }

    private void registerNewUser() {

        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        // create new user or register new user
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(getApplicationContext(),
                        "Registration successful!",
                        Toast.LENGTH_LONG)
                        .show();

                // hide the progress bar
                progressbar.setVisibility(View.GONE);

                // if the user created intent to login activity
                Intent intent = new Intent(RegistrationForm.this, MainActivity.class);
                startActivity(intent);
            } else {

                // Registration failed
                Toast.makeText(
                        getApplicationContext(),
                        "Registration failed!!"
                                + " Please try again later",
                        Toast.LENGTH_LONG)
                        .show();

                // hide the progress bar
                progressbar.setVisibility(View.GONE);
            }
        });
    }
}