package com.example.dingo.loginscreentryout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class Mainlist extends AppCompatActivity {

    private FirebaseAuth mAuth;
    String[] nomes = {"Ines", "Maria", "Carlos", "Pedro"};
    String[] ages = {"17", "20", "18", "21"};
    String[] looking = {"putas", "putas", "putas", "putas"};
    String[] wheres = {"putas", "putas", "putas", "putas"};
    String[] faculdades = {"FDUC", "FLUC", "FCTUC", "FEUC", "FFUC", "FPCEUC", "FCDEFUC", "FMUC"};
    String[] fctuc = {"Geologia", "Antropologia", "Biologia", "Bioquímica", "Design e Multimédia", "Engenharia Informática", "Engenharia e Gestão Industrial", "Física", "Matemática", "Química", "Química Medicinal", "Arquitetura", "Engenharia Cívil", "Engenharia do Ambiente", "Engenharia Eletrotécnica", "Engenharia Mecânica", "Engenharia Química", "Engenharia Biomédica", "Engenharia Física"};
    String[] fmuc = {"Medicina", "Medicina Dentária"};
    String[] feuc = {"Relações Internacionais", "Gestão", "Economia"};
    String[] fcdefuc = {"Ciências do Desporto"};
    String[] fpceuc = {"Serviço Social", "Psicologia", "Ciências da Educação"};
    String[] ffuc = {"Farmácia Biomédica", "Ciências Bioanalíticas", "Ciências Farmacêuticas"};
    String[] fduc = {"Direito", "Administração Público-Privada"};
    String[] fluc = {"Arqueologia", "Ciência da Informação", "Estudos Artísticos", "Estudos Clássicos", "Estudos Europeus", "Filosofia", "Geografia", "História", "História de Arte", "Jornalismo e Comunicação", "Línguas Modernas", "Português", "Turismo, Território e Patrimónios"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_mainlist);
        List age = new ArrayList<Integer>();
        List faculdade = new ArrayList<String>();
        final ArrayList<String> cursos = new ArrayList<String>();
        for (String s : faculdades)
            faculdade.add(s);
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, faculdade);
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner4);
        spinner1.setAdapter(spinnerArrayAdapter1);
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
                ArrayAdapter<String> spinnerArrayAdapter2;
                spinnerArrayAdapter2 = new ArrayAdapter<String>(Mainlist.this, android.R.layout.simple_spinner_item, cursos);
                spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Spinner spinner2 = (Spinner) findViewById(R.id.spinner5);
                spinner2.setAdapter(spinnerArrayAdapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    private void toastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        mAuth.getCurrentUser();
        mAuth.signOut();
        toastMessage("Signed out");
        startActivity(new Intent(Mainlist.this, Login.class));
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
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
            view = getLayoutInflater().inflate(R.layout.row, null);
            TextView textview_nome = (TextView) view.findViewById(R.id.textView6);
            TextView textview_age = (TextView) view.findViewById(R.id.textView8);
            TextView textview_looking = (TextView) view.findViewById(R.id.textView11);
            TextView textview_where = (TextView) view.findViewById(R.id.textView14);
            textview_nome.setText(nomes[i]);
            textview_age.setText(ages[i]);
            textview_looking.setText(looking[i]);
            textview_where.setText(wheres[i]);
            return view;
        }
    }
}