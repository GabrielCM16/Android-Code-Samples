package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHorizontal;
    private ProgressBar progressBarCircular;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        this.progress = 0;

        progressBarCircular.setVisibility(View.GONE);

    }

    public void loadProgress(View view) {
        //ProgressBar Horizontal
        if (this.progress >= 10) {
            this.progress = 0;
            progressBarHorizontal.setProgress(this.progress);
            progressBarCircular.setVisibility(View.GONE);

        } else {
            this.progress = this.progress + 1;
            progressBarHorizontal.setProgress(this.progress);

            //ProgressBar Circular
            progressBarCircular.setVisibility(View.VISIBLE);
        }

    }
}
