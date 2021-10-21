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
    private ImageView kep1, kep2, emberElet1, emberElet2, emberElet3, gepElet1, gepElet2, gepElet3;
    private TextView eredmeny,dontetlen;
    private int emberEredmeny, gepEredmeny,dontetlenSzam;
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
        switch (emberEredmeny) {
            case 1: emberElet3.setImageResource(R.drawable.heart1);
            break;
            case 2: emberElet2.setImageResource(R.drawable.heart1);
                break;
            case 3: emberElet1.setImageResource(R.drawable.heart1);
                break;

        }

        //eredmeny.setText("Eredmeny: Ember: " + emberEredmeny + "Computer: " + gepEredmeny);
    }

    private void lose() {
        Toast.makeText(this,"Vereség", Toast.LENGTH_SHORT).show();
        gepEredmeny++;
        switch (gepEredmeny) {
            case 1: gepElet3.setImageResource(R.drawable.heart1);
                break;
            case 2: gepElet2.setImageResource(R.drawable.heart1);
                break;
            case 3: gepElet1.setImageResource(R.drawable.heart1);
                break;

        }
        //eredmeny.setText("Eredmeny: Ember: " + emberEredmeny + " Computer: " + gepEredmeny);
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
    if (emberEredmeny > gepEredmeny) {
        builder.setTitle("Győzelem");
    } else {
        builder.setTitle("Vereség");
    }

    builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
        }
    });

    builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            newGame();
        }
    });

    builder.create().show();

}

private void newGame() {
        beallitas(1, kep1);
        beallitas(2, kep2);
        emberEredmeny = 0;
        gepEredmeny = 0;
        dontetlenSzam = 0;
        //eredmeny.setText("Eredemény: Ember: 0 Computer:0");
        dontetlen.setText("Döntetlenek száma: 0");
        emberElet1.setImageResource(R.drawable.heart2);
        emberElet2.setImageResource(R.drawable.heart2);
        emberElet3.setImageResource(R.drawable.heart2);
        gepElet1.setImageResource(R.drawable.heart2);
        gepElet2.setImageResource(R.drawable.heart2);
        gepElet3.setImageResource(R.drawable.heart2);
}

    private void init() {
        kep1 = findViewById(R.id.kep1);
        kep2 = findViewById(R.id.kep2);
        //eredmeny = findViewById(R.id.eredmeny);
        dontetlen = findViewById(R.id.dontetlen);
        ko = findViewById(R.id.ko);
        papir = findViewById(R.id.papir);
        ollo = findViewById(R.id.ollo);
        emberEredmeny = 0;
        gepEredmeny = 0;
        dontetlenSzam = 0;
        emberElet1 = findViewById(R.id.emberEgyElet);
        emberElet2 = findViewById(R.id.emberKetElet);
        emberElet3 = findViewById(R.id.emberHaromElet);
        gepElet1 = findViewById(R.id.gepEgyElet);
        gepElet2 = findViewById(R.id.gepKetElet);
        gepElet3 = findViewById(R.id.gepHaromElet);
    }
}