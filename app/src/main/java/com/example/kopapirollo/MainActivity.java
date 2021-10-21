package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


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


    private void beallitas(int vegsoValasztas, ImageView kep) {
            switch (vegsoValasztas) {
                case 1:
                    kep.setImageResource(R.drawable.rock);
                    break;
                case 2:
                    kep.setImageResource(R.drawable.paper);
                    break;
                case 3:
                    kep.setImageResource(R.drawable.scissors);
                    break;
            }
    }

    private void win() {
        Toast.makeText(this,"Győzelem", Toast.LENGTH_SHORT).show();
        emberEredmeny++;
       eredmeny.setText("Eredmeny: Ember: " + emberEredmeny + "Computer: " + gepEredmeny);
    }

    private void lose() {
        Toast.makeText(this,"Vereség", Toast.LENGTH_SHORT).show();
        gepEredmeny++;
        eredmeny.setText("Eredmeny: Ember: " + emberEredmeny + " Computer: " + gepEredmeny);
    }

    private void draw() {
        Toast.makeText(this,"Döntetlen", Toast.LENGTH_SHORT).show();
        dontetlenSzam++;
        dontetlen.setText("Döntetlenek száma: " + dontetlenSzam);
    }


    private void valaszt(int option) {
        beallitas(option, kep1);
        int gepValaszt = (int) (Math.random() * 3) + 1;
        beallitas(gepValaszt, kep2);

        if (option == gepValaszt) {
            draw();
        }else if(option == 1) {
                if (gepValaszt == 2) {
                    lose();
                }else {
                    win();
                }
        }else if (option == 2){
            if (gepValaszt == 1){
                win();
            }
            else{
                lose();
            }
        }
        else if (option == 3){
            if (gepValaszt == 1){
               lose();
            }
            else{
                win();
            }
        }

        if (emberEredmeny>= 3 || gepEredmeny >= 3){
            vege();
        }
    }

private void vege() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setCancelable(false);
    builder.setMessage("Szeretne új játékot játszani?");
    if (gepEredmeny > emberEredmeny) {
        builder.setTitle("Vereség");
    } else {
        builder.setTitle("Győzelem");
    }
    builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            newGame();
        }
    });

    builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish();
        }
    });
}

private void newGame() {
        beallitas(1, kep1);
        beallitas(2, kep2);
        emberEredmeny = 0;
        gepEredmeny = 0;
        dontetlenSzam = 0;
        eredmeny.setText("Eredemény: Ember: 0 Computer:0");
        dontetlen.setText("Döntetlenek száma: 0");
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