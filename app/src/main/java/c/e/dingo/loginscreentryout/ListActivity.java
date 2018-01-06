package c.e.dingo.loginscreentryout;

import android.content.Intent;
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

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private final static String TAG = "List";
    private ArrayList<pedido> arrayPedidos =new ArrayList<>();
    private ArrayList<String> emails=new ArrayList<>();
    private ArrayList<String> nomes=new ArrayList<>();
    private ArrayList<String> idades=new ArrayList<>();
    private ArrayList<String> wheres=new ArrayList<>();
    private ArrayList<String> searchings=new ArrayList<>();
    private ArrayList<String> obs=new ArrayList<>();
    private ArrayList<String> ideais=new ArrayList<>();
    String[] fctuc = {"Geologia"};
    String[] myStringArray = new String[3];
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
        }
        final ListView listView=findViewById(R.id.listview);
        final CustomAdapter customAdapter=new CustomAdapter();


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
                if (emails.size()!=0)
                    listView.setAdapter(customAdapter);
                else{
                    toastMessage("Sem Resultados");
                    startActivity(new Intent(ListActivity.this,Mainlist.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void showData(DataSnapshot dataSnapshot) {
        int i=0;
        if(savedCurso.equals("Todos os cursos")){
            for(DataSnapshot ds: dataSnapshot.getChildren()){
                pedido storePedidos = ds.getValue(pedido.class);
                arrayPedidos.add(storePedidos);
            }
        }else{
            for(DataSnapshot ds: dataSnapshot.getChildren()){
                String currentCurso = ds.getValue(pedido.class).getCurso();
                if(currentCurso.equals(savedCurso)){
                    pedido storePedidos = ds.getValue(pedido.class);
                    arrayPedidos.add(storePedidos);
                }
            }
        }
        for (pedido p:arrayPedidos){
            emails.add(p.getEmail());
            nomes.add(p.getNome());
            idades.add(p.getAge());
            wheres.add(p.getWhere());
            searchings.add(p.getSearching());
            obs.add(p.getObs());
            ideais.add(p.getIdealHomies());
        }

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return emails.size();
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
            if(emails.size()!=0){
                view=getLayoutInflater().inflate(R.layout.row,null);
                TextView name=(TextView) view.findViewById(R.id.nome);
                TextView email=(TextView) view.findViewById(R.id.email);
                TextView idade=(TextView) view.findViewById(R.id.textView8);
                TextView where=(TextView) view.findViewById(R.id.textView11);
                TextView ob=(TextView) view.findViewById(R.id.textView16);
                TextView searching=(TextView) view.findViewById(R.id.textView14);
                TextView ideals=(TextView) view.findViewById(R.id.textView18);
                name.setText(nomes.get(i));
                email.setText(emails.get(i));
                idade.setText(idades.get(i));
                where.setText(wheres.get(i));
                ob.setText(obs.get(i));
                searching.setText(searchings.get(i));
                ideals.setText(ideais.get(i));
                return view;
            }
            else
                return null;
        }
    }
    public void onStart() {
        super.onStart();
    }
    private void toastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
