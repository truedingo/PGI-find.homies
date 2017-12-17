package com.example.dingo.loginscreentryout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Dingo on 16/12/2017.
 */

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.bContinue) {
            startActivity(new Intent(SignUp.this, Info.class));
        }
    }
}
