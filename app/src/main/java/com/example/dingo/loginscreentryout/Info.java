package com.example.dingo.loginscreentryout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dingo on 16/12/2017.
 */

public class Info extends AppCompatActivity implements View.OnClickListener{


    String [] faculdades={"FDUC","FLUC","FCTUC","FEUC","FFUC","FPCEUC","FCDEFUC","FLUC"};
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
        List age = new ArrayList<Integer>();
        List faculdade = new ArrayList<String>();
        List cursos= new ArrayList<String>();
        for (String s: faculdades)
            faculdade.add(s);
        for (int i = 16; i <= 65; i++) {
            age.add(Integer.toString(i));
        }
        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_item, age);
        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(spinnerArrayAdapter);

        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, faculdade);
        spinnerArrayAdapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner2);
        spinner1.setAdapter(spinnerArrayAdapter1);

        String choice = spinner1.getSelectedItem().toString();
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
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, cursos);
        spinnerArrayAdapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner3);
        spinner2.setAdapter(spinnerArrayAdapter2);









    }
    @Override
    public void onClick(View view) {

    }
}
