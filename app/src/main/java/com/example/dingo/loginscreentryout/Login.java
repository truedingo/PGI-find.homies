package com.example.dingo.loginscreentryout;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    Button login;
    EditText getEmail;
    EditText getPassword;

    private static final String TAG = "EmailPassword";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = findViewById(R.id.bLogin);
        getEmail = findViewById(R.id.editText2);
        getPassword = findViewById(R.id.editText3);
    }

    public void get_email_password(){
        String email = getEmail.getText().toString();
        String password = getPassword.getText().toString();
        Log.v("Got Email: ", email);
        Log.v("Got Password: ", password);

    }

    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void initialize_login(final String email, final String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.v("Email: ", email);
                Log.v("Password: ", password);
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                }

                // [START_EXCLUDE]
                if (!task.isSuccessful()) {
                    Log.v(TAG, "Opaaa");
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        get_email_password();
        initialize_login(getEmail.getText().toString(), getPassword.getText().toString());

    }
}
