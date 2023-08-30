package com.example.exercicioactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProximaTela extends AppCompatActivity {

    private TextView saidaName;
    private TextView saidaPhone;
    private TextView saidaAge;
    private TextView saidaMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxima_tela);

        inicializarComponent();
        setarTela();
    }

    private void setarTela() {
        User user = (User) getIntent().getSerializableExtra("user");

        saidaMail.setText("Mail: " + user.getEmail());
        saidaName.setText("Name: " + user.getName());
        saidaAge.setText("Age: " + user.getAge());
        saidaPhone.setText("Phone: " + user.getPhone());
    }

    private void inicializarComponent() {
        saidaAge = findViewById(R.id.saidaAge);
        saidaPhone = findViewById(R.id.saidaPhone);
        saidaName = findViewById(R.id.saidaNome);
        saidaMail = findViewById(R.id.saidaMail);

    }
}
