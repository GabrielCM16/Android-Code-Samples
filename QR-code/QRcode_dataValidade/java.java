package com.example.qrcodecontador;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private TextView saidaTempo;
    private TextView saidaCurrent;
    private ImageView qrCode;
    private long finalContador = 30000; //milisegundos (30 segundos)
    private long intervaloContador = 1000; //milisegundos (1 segundo)
    private boolean apertado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saidaTempo = findViewById(R.id.saidaTempo);
        saidaCurrent = findViewById(R.id.saidacurrent);
        qrCode = findViewById(R.id.qrcode);
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
                apertado = false;
            }
        }.start();
    }

    public void iniciarTempo(View view){
        if (!apertado) {
            apertado = true;
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
        saidaCurrent.setText("tempo atual = " + currentAtual);
        String saidaQR = matricula + "/" + String.valueOf(currentAtual);
        return saidaQR;
    }

    public void gerarQR(String gerar){
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(gerar, BarcodeFormat.QR_CODE, 450, 450);
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
