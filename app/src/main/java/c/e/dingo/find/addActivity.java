package c.e.dingo.find;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addActivity extends AppCompatActivity {
    private static final String TAG = "ADD";
    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String selectedCurso;
    private String selectedUserID;
    private String selectedName;
    private String selectedAge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcreate);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Log.d(TAG, "onAuthStateChanged:signed_in:"+ user.getEmail());
                } else{
                    Log.d(TAG, "onAuthStateChanged: signed_out.");
                }
            }
        };

        myRef.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                showUserData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

    });

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
                String EMAIL = mAuth.getCurrentUser().getEmail();
                if (!WHAT.equals("") && !WHERE.equals("") && !OB.equals("") && !IDEAL.equals("") && selectedCurso!=null &&  selectedName!=null  && selectedAge!=null) {
                    pedido newpedido = new pedido(WHAT, user.getUid(), WHERE, OB, IDEAL, EMAIL, selectedCurso, selectedName, selectedAge);
                    myRef.child("anuncios").child(userid).setValue(newpedido);
                    toastMessage("Anuncio criado!");
                }
                else
                    toastMessage("Erro ao criar anúncio");
            }


        });
    }

    private void showUserData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds: dataSnapshot.getChildren()){
            selectedUserID = ds.getValue(user.class).getUid();
            if(selectedUserID.equals(mAuth.getCurrentUser().getUid())){
                selectedCurso = ds.getValue(user.class).getCurso();
                selectedAge = ds.getValue(user.class).getAge();
                selectedName = ds.getValue(user.class).getName();
            }
        }
    }
    private void toastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
