package com.example.dingo.loginscreentryout;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListActivity extends AppCompatActivity {

    private final static String TAG = "List";
    private pedido [] arrayPedidos;

    String[] fctuc = {"Geologia", "Antropologia ", "Biologia", "Bioquímica", "Design e Multimédia", "Engenharia Informática", "Engenharia e Gestão Industrial", "Física", "Matemática", "Química", "Química Medicinal", "Arquitetura", "Engenharia Cívil", "Engenharia do Ambiente", "Engenharia Eletrotécnica", "Engenharia Mecânica", "Engenharia Química", "Engenharia Biomédica", "Engenharia Física"};


    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String savedCurso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            savedCurso = extras.getString("savedCurso");
            toastMessage(savedCurso);
        }
        ListView listView=findViewById(R.id.listview);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

        mAuth = FirebaseAuth.getInstance();

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

        myRef.child("anuncios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                //Metodo para retornar cenas
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void showData(DataSnapshot dataSnapshot) {
        int i=0;
        for(DataSnapshot ds: dataSnapshot.getChildren()){
            String currentCurso = ds.getValue(pedido.class).getCurso();
            if(currentCurso.equals(savedCurso)){
                pedido storePedidos = ds.getValue(pedido.class);
                arrayPedidos[i] = storePedidos;
                i+=1;
            }

        }
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return fctuc.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.row,null);
            TextView tv=(TextView) view.findViewById(R.id.Nome);
            tv.setText(arrayPedidos[i].getEmail());
            return view;
        }
    }
    public void onStart() {
        super.onStart();
    }
    private void toastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
