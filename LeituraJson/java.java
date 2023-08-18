package com.example.colocandobd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference userDocumentRef = db.collection("Usuarios").document("Alunos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJson();
            }
        });
    }

    private void loadJson(){
        try{

            //abre o arquivo
            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json;
            int max;
            String nome, turma;
            long matricula;

            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            max = jsonArray.length();

            for (int i = 0; i < max; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                nome = jsonObject.getString("NOME DO ALUNO"); //campo do json
                turma = jsonObject.getString("TURMA");
                //matricula = jsonObject.getInt("MATRÍCULA");
                matricula = Long.parseLong(jsonObject.optString("MATRÍCULA"));


                Log.d("TAG", nome + " " + turma + " "  + matricula + " tam " + max);

                // Criar uma nova coleção chamada "novaColecao"
                CollectionReference novaColecaoRef = db.collection("Usuarios").document("Alunos").collection(String.valueOf(matricula));

// Dados para os documentos
                List<Map<String, String>> documentos = new ArrayList<>();

                Map<String, String> dados = new HashMap<>();
                dados.put("nome", nome);

                String aux = "";

                if (turma.equals("INAQ3A")){
                    aux = "3QUI";
                } else if (turma.equals("INED1A")){
                    aux = "1EDI";
                } else if (turma.equals("INED2A")){
                    aux = "2EDI";
                } else if (turma.equals("INED3A")) {
                    aux = "3EDI";
                } else if (turma.equals("INIF1A")){
                    aux = "1INF";
                } else if (turma.equals("INIF2A")){
                    aux = "2INF";
                } else if (turma.equals("INIF3A")) {
                    aux = "3INF";
                } else if (turma.equals("INQU1A")){
                    aux = "1QUI";
                } else if (turma.equals("INQU2A")){
                    aux = "2QUI";
                }

                dados.put("turma", aux);
                documentos.add(dados);

                Map<String, String> id = new HashMap<>();
                id.put("email", "");
                id.put("idUser", "");
                documentos.add(id);

                Map<String, String> chamada = new HashMap<>();
                chamada.put("faltas", "0");
                chamada.put("presencas", "1");
                chamada.put("possivelStatus", "Saida");
                documentos.add(chamada);

// Adicionar os documentos à nova coleção com nomes específicos
                novaColecaoRef.document("dados").set(dados)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Sucesso! Documento 1 foi adicionado à coleção.
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Ocorreu um erro ao adicionar o documento 1 à coleção.
                            }
                        });

                novaColecaoRef.document("id").set(id)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Sucesso! Documento 2 foi adicionado à coleção.
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Ocorreu um erro ao adicionar o documento 2 à coleção.
                            }
                        });

                novaColecaoRef.document("chamadaPessoal").set(chamada)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Sucesso! Documento 3 foi adicionado à coleção.
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Ocorreu um erro ao adicionar o documento 3 à coleção.
                            }
                        });





            }

        }catch (Exception e){
            Log.e("TAG", "erro em" + e);
        }
    }
}
