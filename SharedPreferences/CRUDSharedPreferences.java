package com.example.exerciciosharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class CRUDSharedPreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private final String NOME_ARQUIVO = "meus.dados";

    public CRUDSharedPreferences(Context c){
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }
    public void salvarChave(String chave, String dado){
        editor.putString(chave, dado);
        editor.commit();
    }
    public String recuperarChave(String chave){
        return preferences.getString(chave, "ERRO");
    }

}
