package com.example.chitramitra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    private TextInputLayout mEmailInputLayout, mPasswordInputLayout,mcnfPasswordInputLayout;
    private Button mSignupButton;
    private TextView mLoginLink;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        mEmailInputLayout = findViewById(R.id.email_input_layout);
        mPasswordInputLayout = findViewById(R.id.password_input_layout);
        mSignupButton = findViewById(R.id.signup_button);
        mLoginLink = findViewById(R.id.login_textview);
        mSignupButton.setBackgroundColor(Color.WHITE);
        mcnfPasswordInputLayout = findViewById(R.id.password_confirm_input_layout);

        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailInputLayout.getEditText().getText().toString();
                String password = mPasswordInputLayout.getEditText().getText().toString();
                String cnfPassword =  mcnfPasswordInputLayout.getEditText().getText().toString();
                if(password.equals(cnfPassword) ){
                    createUser(email, password);
                }
            }
        });

        mLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void createUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign up success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(SignupActivity.this, MainActivity.class));
                        } else {
                            // If sign up fails, display a message to the user.
                            Toast.makeText(SignupActivity.this, "Authentication failed."+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
