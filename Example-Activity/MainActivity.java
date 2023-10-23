package com.example.exercicioactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputName;
    private EditText inputMail;
    private EditText inputPhone;
    private EditText inputAge;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarlizarComponentes();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarInput();
            }
        });
    }

    private void cadastrarInput() {
        String name = inputName.getText().toString();
        String email = inputMail.getText().toString();
        String phone = inputPhone.getText().toString();
        String age = inputAge.getText().toString();

        if (!name.equals("") || !email.equals("") || !phone.equals("") || !age.equals("")){
            User user = new User(name, email, phone, age);

            proximaTela(user);
        }else {
            Toast.makeText(getApplicationContext(), "Insira todas as informaçoes", Toast.LENGTH_LONG).show();
        }
    }

    private void proximaTela(User user){
        Intent intent = new Intent(getApplicationContext(), ProximaTela.class);

        intent.putExtra("user", user);

        startActivity(intent);

    }

    private void iniciarlizarComponentes() {
        inputName = findViewById(R.id.inputName);
        inputMail = findViewById(R.id.inputMail);
        inputPhone = findViewById(R.id.inputPhone);
        inputAge = findViewById(R.id.inputAge);
        button = findViewById(R.id.button);
    }
}
