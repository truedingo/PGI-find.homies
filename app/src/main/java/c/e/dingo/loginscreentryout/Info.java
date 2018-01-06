package c.e.dingo.loginscreentryout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dingo on 16/12/2017.
 */

public class Info extends AppCompatActivity{


    private FirebaseAuth mAuth;
    private final static String TAG = "Email/Password";
    private FirebaseAuth.AuthStateListener mAuthListener;

    //Database
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    String [] faculdades={"FDUC","FLUC","FCTUC","FEUC","FFUC","FPCEUC","FCDEFUC","FMUC"};
    String [] fctuc={"Geologia","Antropologia","Biologia","Bioquímica","Design e Multimédia","Engenharia Informática","Engenharia e Gestão Industrial","Física","Matemática","Química","Química Medicinal","Arquitetura","Engenharia Cívil","Engenharia do Ambiente","Engenharia Eletrotécnica","Engenharia Mecânica","Engenharia Química","Engenharia Biomédica","Engenharia Física"};
    String [] fmuc={"Medicina","Medicina Dentária"};
    String [] feuc= {"Relações Internacionais","Gestão","Economia"};
    String [] fcdefuc={"Ciências do Desporto"};
    String [] fpceuc={"Serviço Social","Psicologia","Ciências da Educação"};
    String [] ffuc={"Farmácia Biomédica","Ciências Bioanalíticas","Ciências Farmacêuticas"};
    String [] fduc={"Direito","Administração Público-Privada"};
    String [] fluc = {"Arqueologia","Ciência da Informação","Estudos Artísticos","Estudos Clássicos","Estudos Europeus","Filosofia","Geografia","História","História de Arte","Jornalismo e Comunicação","Línguas Modernas","Português","Turismo, Território e Patrimónios"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Object value = dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //Text
        final EditText name = findViewById(R.id.editText4);

        final Button createAcc = findViewById(R.id.button2);


        List age = new ArrayList<Integer>();
        List faculdade = new ArrayList<String>();
        final ArrayList<String> cursos= new ArrayList<String>();
        for (String s: faculdades)
            faculdade.add(s);
        for (int i = 16; i <= 65; i++) {
            age.add(Integer.toString(i));
        }
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_item, age);
        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(spinnerArrayAdapter);

        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, faculdade);
        spinnerArrayAdapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        final Spinner spinner1 = (Spinner)findViewById(R.id.spinner2);
        spinner1.setAdapter(spinnerArrayAdapter1);
        final Spinner spinner2 = (Spinner)findViewById(R.id.spinner3);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String choice = spinner1.getSelectedItem().toString();
                cursos.clear();
                switch (choice) {
                    case "FDUC":
                        for (String s : fduc)
                            cursos.add(s);
                        break;
                    case "FLUC":
                        for (String s : fluc)
                            cursos.add(s);
                        break;
                    case "FEUC":
                        for (String s : feuc)
                            cursos.add(s);
                        break;
                    case "FCTUC":
                        for (String s : fctuc)
                            cursos.add(s);
                        break;
                    case "FFUC":
                        for (String s : ffuc)
                            cursos.add(s);
                        break;
                    case "FPCEUC":
                        for (String s : fpceuc)
                            cursos.add(s);
                        break;
                    case "FMUC":
                        for (String s : fmuc)
                            cursos.add(s);
                        break;
                    case "FCDEFUC":
                        for (String s : fcdefuc)
                            cursos.add(s);
                        break;
                }
                java.util.Collections.sort(cursos);
                ArrayAdapter<String> spinnerArrayAdapter2;
                spinnerArrayAdapter2 = new ArrayAdapter<String>(Info.this, android.R.layout.simple_spinner_item, cursos);
                spinnerArrayAdapter2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
                spinner2.setAdapter(spinnerArrayAdapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView){
            }

        });

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                if(extras != null) {
                    String savedPassword = extras.getString("savedPassword");
                    String savedEmail = extras.getString("savedEmail");
                    mAuth.createUserWithEmailAndPassword(savedEmail, savedPassword);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    toastMessage("Account created: " +savedEmail);
                }
                else{
                    toastMessage("Something went wrong with account creation!");
                }
                mAuth.addAuthStateListener(mAuthListener);
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser authUser = firebaseAuth.getCurrentUser();
                if (authUser != null) {
                    String selectedFaculdade = spinner1.getSelectedItem().toString();
                    String selectedCurso = spinner2.getSelectedItem().toString();
                    String selectedAge = spinner.getSelectedItem().toString();
                    String selectedName = name.getText().toString();
                    String userID = authUser.getUid();
                    user newUser = new user(selectedName, authUser.getEmail(), selectedFaculdade, selectedCurso, selectedAge, userID);
                    myRef.child("users").child(userID).setValue(newUser);
                    startActivity(new Intent(Info.this, Mainlist.class));
                }
                else{
                    mAuth.removeAuthStateListener(mAuthListener);
                    startActivity(new Intent(Info.this, Login.class));
                }
            }
        };
    }

    private void toastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void onStart(){
        super.onStart();
    }

}
