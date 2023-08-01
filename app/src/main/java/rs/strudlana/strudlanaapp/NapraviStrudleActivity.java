package rs.strudlana.strudlanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class NapraviStrudleActivity extends AppCompatActivity {

    NumberPicker numberPickerMak ;
    NumberPicker numberPickerOrasi ;
    NumberPicker numberPickerVisnja ;

    NumberPicker numberPickerCokoVisnja ;
    NumberPicker numberPickerJabuka ;
    NumberPicker numberPickerRogac ;

    Button dodajStrudle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_napravi_strudle);

        numberPickerMak = findViewById(R.id.noveStrudle_numberPickerMak);
        numberPickerOrasi = findViewById(R.id.noveStrudle_numberPickerOrasi);
        numberPickerVisnja = findViewById(R.id.noveStrudle_numberPickerVisnja);

        numberPickerCokoVisnja = findViewById(R.id.noveStrudle_numberPickerCokoVisnja);
        numberPickerJabuka = findViewById(R.id.noveStrudle_numberPickerJabuka);
        numberPickerRogac = findViewById(R.id.noveStrudle_numberPickerRogac);

        int minValue = 1;
        int maxValue = 250;

        dodajStrudle = findViewById(R.id.napStrudle_napraviDugme);

        String operacija = getIntent().getStringExtra("Operacija");

        //provera koja je operacija u pitanju
        if(operacija.equals("Dodavanje")){

            int[]vrednosti=new int[6];

            numberPickerMak.setMinValue(minValue);
            numberPickerMak.setMaxValue(maxValue);

            numberPickerOrasi.setMinValue(minValue);
            numberPickerOrasi.setMaxValue(maxValue);

            numberPickerVisnja.setMinValue(minValue);
            numberPickerVisnja.setMaxValue(maxValue);

            numberPickerCokoVisnja.setMinValue(minValue);
            numberPickerCokoVisnja.setMaxValue(maxValue);

            numberPickerJabuka.setMinValue(minValue);
            numberPickerJabuka.setMaxValue(maxValue);

            numberPickerRogac.setMinValue(minValue);
            numberPickerRogac.setMaxValue(maxValue);

            dodajStrudle = findViewById(R.id.napStrudle_napraviDugme);

            //Hvatanje vrednosti iz numberpickera

            numberPickerMak.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[0] = i1;
            }));
            numberPickerOrasi.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[1] = i1;
            }));
            numberPickerVisnja.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[2] = i1;
            }));
            numberPickerCokoVisnja.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[3] = i1;
            }));
            numberPickerJabuka.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[4] = i1;
            }));
            numberPickerRogac.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[5] = i1;
            }));

            //stavljanje ovih u bazu, ali prvo ide na activity za proveru

            dodajStrudle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),NapraviStrudleProveraActivity.class);
                    intent.putExtra("Vrednosti",vrednosti);
                    intent.putExtra("Operacija","Dodavanje");

                    startActivity(intent);
                }
            });



        }else{

            int[]vrednosti=new int[6];

            numberPickerMak.setMinValue(minValue);
            numberPickerMak.setMaxValue(maxValue);

            numberPickerOrasi.setMinValue(minValue);
            numberPickerOrasi.setMaxValue(maxValue);

            numberPickerVisnja.setMinValue(minValue);
            numberPickerVisnja.setMaxValue(maxValue);

            numberPickerCokoVisnja.setMinValue(minValue);
            numberPickerCokoVisnja.setMaxValue(maxValue);

            numberPickerJabuka.setMinValue(minValue);
            numberPickerJabuka.setMaxValue(maxValue);

            numberPickerRogac.setMinValue(minValue);
            numberPickerRogac.setMaxValue(maxValue);

            //Hvatanje vrednosti iz numberpickera

            numberPickerMak.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[0] = i1;
            }));
            numberPickerOrasi.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[1] = i1;
            }));
            numberPickerVisnja.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[2] = i1;
            }));
            numberPickerCokoVisnja.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[3] = i1;
            }));
            numberPickerJabuka.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[4] = i1;
            }));
            numberPickerRogac.setOnValueChangedListener(((numberPicker, i, i1) -> {
                vrednosti[5] = i1;
            }));

            //stavljanje ovih u bazu, ali prvo ide na activity za proveru

            dodajStrudle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),NapraviStrudleProveraActivity.class);
                    intent.putExtra("Vrednosti",vrednosti);
                    intent.putExtra("Operacija","Dodavanje");

                    startActivity(intent);
                }
            });;

        }

    }
}