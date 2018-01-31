package c.e.dingo.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Dingo on 16/12/2017.
 */

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String savedEmail;
    private String savedPassword;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Button bContinue = findViewById(R.id.bContinue);
        final EditText sEmail = findViewById(R.id.editText3);
        final EditText sPassword = findViewById(R.id.editText2);
        final EditText cPassword = findViewById(R.id.editText5);

        bContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedEmail = sEmail.getText().toString();
                savedPassword = sPassword.getText().toString();
                String confPassword = cPassword.getText().toString();
                if(!savedEmail.equals("") && !savedPassword.equals("") && !confPassword.equals("")){
                    if(savedPassword.equals(confPassword)){
                        Intent sender = new Intent(SignUp.this, Info.class);
                        sender.putExtra("savedPassword", savedPassword);
                        sender.putExtra("savedEmail", savedEmail);
                        startActivity(sender);
                    }
                    else if (savedPassword.length() < 6){
                        toastMessage("A password precisa de ter 6 ou mais caracteres!");
                    }
                }
                else{
                    toastMessage("É necessário preencher todos os campos!");
                }
            }
        });

    }

    private void toastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void onStart(){
        super.onStart();
    }

}
