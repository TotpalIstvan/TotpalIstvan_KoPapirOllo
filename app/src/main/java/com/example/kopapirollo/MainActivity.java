package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ImageView kep1, kep2;
    private TextView eredmeny,dontetlen;
    private int emberEredmeny, gepEredmeny,dontetlenSzam, emberElet, gepElet;
    private Button ko,papir,ollo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valaszt(1);
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valaszt(2);
            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valaszt(3);
            }
        });
    }



    private void valaszt(int option) {
        beallitas(option, kep1);
        int gepValaszt = (int) (Math.random() * 3) + 1;
        beallitas(option, kep2);

        if (option == gepValaszt) {
            draw();
        }else if(option == 1) {
                if (gepValaszt == 2) {
                    loss();
                }else {
                    win();
                }
        }else if (option == 2){
            if (gepValaszt == 1){
                win();
            }
            else{
                loss();
            }
        }
        else if (option == 3){
            if (gepValaszt == 1){
               loss();
            }
            else{
                win();
            }
        }

        if (emberEredmeny>= 3 || gepEredmeny >= 3){
            vege();
        }
    }



    private void init() {
        kep1 = findViewById(R.id.kep1);
        kep2 = findViewById(R.id.kep2);
        eredmeny = findViewById(R.id.eredmeny);
        dontetlen = findViewById(R.id.dontetlen);
        ko = findViewById(R.id.ko);
        papir = findViewById(R.id.papir);
        ollo = findViewById(R.id.ollo);
    }
}