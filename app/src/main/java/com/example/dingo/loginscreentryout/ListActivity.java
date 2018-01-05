package com.example.dingo.loginscreentryout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    String[] fctuc = {"Geologia", "Antropologia", "Biologia", "Bioquímica", "Design e Multimédia", "Engenharia Informática", "Engenharia e Gestão Industrial", "Física", "Matemática", "Química", "Química Medicinal", "Arquitetura", "Engenharia Cívil", "Engenharia do Ambiente", "Engenharia Eletrotécnica", "Engenharia Mecânica", "Engenharia Química", "Engenharia Biomédica", "Engenharia Física"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView=findViewById(R.id.listview);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

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
            tv.setText(fctuc[i]);
            return view;
        }
    }
}
