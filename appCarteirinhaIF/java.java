package com.example.qrcodecontador;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private TextView saidaTempo;
    private ImageView qrCode;
    private Button botao;
    private long finalContador = 15000; //milisegundos (15 segundos)
    private long intervaloContador = 1000; //milisegundos (1 segundo)
    private boolean apertado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saidaTempo = findViewById(R.id.saidaTempo);
        qrCode = findViewById(R.id.qrcode);
        botao = findViewById(R.id.button);
        qrCode.setVisibility(View.INVISIBLE);
        botao.setVisibility(View.VISIBLE);
    }

    private void contador(long finalCont, long intervaloCont){
        new CountDownTimer(finalCont, intervaloCont) {

            public void onTick(long millisUntilFinished) {
                long segundos = millisUntilFinished / 1000;
                long minutos = millisUntilFinished / 60000;
                saidaTempo.setText("segundos restantes: " + minutos + ":" + segundos);
            }

            public void onFinish() {
                saidaTempo.setText("Fim!");
                qrCode.setVisibility(View.INVISIBLE);
                botao.setVisibility(View.VISIBLE);
                apertado = false;
            }
        }.start();
    }

    public void iniciarTempo(View view){
        if (!apertado) {
            apertado = true;
            botao.setVisibility(View.INVISIBLE);
            contador(finalContador, intervaloContador);
            String qr = stringQRcode();
            gerarQR(qr);
        } else {
            abrirToast("QR code já gerado!");
        }
    }

    public String stringQRcode(){
        String matricula = "20213018108";
        long currentAtual = System.currentTimeMillis();
        String saidaQR = matricula + "/" + String.valueOf(currentAtual);
        return saidaQR;
    }

    public void gerarQR(String gerar){
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(gerar, BarcodeFormat.QR_CODE, 500, 500);
            ImageView imageViewQrCode = (ImageView) findViewById(R.id.qrcode);
            imageViewQrCode.setImageBitmap(bitmap);
            qrCode.setVisibility(View.VISIBLE);
        } catch(Exception e) {

        }
    }

    public void abrirToast(String texto){
        Toast.makeText(
                getApplicationContext(),
                texto,
                Toast.LENGTH_LONG
        ).show();
    }
}
