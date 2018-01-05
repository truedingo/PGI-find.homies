package com.example.dingo.loginscreentryout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addActivity extends AppCompatActivity {
    private static final String TAG = "ADD";
    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcreate);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        final EditText what = findViewById(R.id.what);
        final EditText where = findViewById(R.id.where);
        final EditText ob = findViewById(R.id.ob);
        final EditText ideal = findViewById(R.id.ideal);
        Button create=findViewById(R.id.criar);
        final FirebaseUser user = mAuth.getCurrentUser();
        final String userid = user.getUid();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String WHAT=what.getText().toString();
                String WHERE=where.getText().toString();
                String OB=ob.getText().toString();
                String IDEAL=ideal.getText().toString();
                if (!WHAT.equals("") && !WHERE.equals("") && !OB.equals("") && !IDEAL.equals("")){
                    pedido newpedido= new pedido(WHAT,user.getUid(),WHERE,OB,IDEAL);
                    if(myRef.child("anuncios").child(userid)==null){
                        myRef.child("anuncios").child(userid).setValue(newpedido);
                    }
                    else
                        toastMessage("Já tens um anúncio");
                }
            }


        });
    }
    private void toastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
