package rs.strudlana.strudlanaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

public class NovaManifestacijaActivity extends AppCompatActivity {

    private ImageView pozadina;
    private TextView gornjiNaslov;
    private TextView naslovParametar,textViewDatum,pomocTextView;
    private EditText editTextParametar;
    private Button izaberiDatumButton;
    private FloatingActionButton daljeFab;

    private Calendar calendar;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_manifestacija);

        int rBr = getIntent().getIntExtra("rBr",1);
        Manifestacija manifestacija = (Manifestacija) getIntent().getSerializableExtra("manifestacija");
        System.out.print("Doslo u novu aktivnost 2:"+rBr);

        gornjiNaslov = findViewById(R.id.novaMan_naslov);
        naslovParametar = findViewById(R.id.novaMan_naslovParametra);
        pozadina = findViewById(R.id.novaMan_pozadina);
        daljeFab = findViewById(R.id.novaMan_fab);
        editTextParametar = findViewById(R.id.novaMan_editTextParametra);
        izaberiDatumButton = findViewById(R.id.novaMan_izaberiDatumPocetka2);
        textViewDatum = findViewById(R.id.novaMan_textViewDatum);
        pomocTextView = findViewById(R.id.novaMan_pomoc);

        ConstraintLayout.LayoutParams params;

        switch (rBr){
            case 1:

                naslovParametar.setText("Unesi naziv:");
                pozadina.setImageResource(R.drawable.background_novamanifestacija_naziv);

                System.out.print("Doslo u novu aktivnost 3:"+rBr);
                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);
                pomocTextView.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        manifestacija.setNaziv(String.valueOf(editTextParametar.getText()));

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",2);

                        startActivity(intent);
                    }
                });
                break;
            case 2:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);
                pomocTextView.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Unesi lokaciju:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.lokacija_pozadina);

                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        manifestacija.setLokacija(String.valueOf(editTextParametar.getText()));

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",3);

                        startActivity(intent);
                    }
                });
                break;
            case 3:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);
                pomocTextView.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Unesi početan datum:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.datum_pozadina);
                izaberiDatumButton.setVisibility(View.VISIBLE);


                calendar = Calendar.getInstance();
                izaberiDatumButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDatePickerDialog();
                    }
                });
                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        manifestacija.setDatumPocetka(String.valueOf(textViewDatum.getText()));

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",4);

                        startActivity(intent);
                    }
                });
                break;
            case 4:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);
                pomocTextView.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Unesi krajnji datum:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.datum_pozadina);
                izaberiDatumButton.setVisibility(View.VISIBLE);


                calendar = Calendar.getInstance();
                izaberiDatumButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDatePickerDialog();
                    }
                });
                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        manifestacija.setDatumKraja(String.valueOf(textViewDatum.getText()));

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",5);

                        startActivity(intent);
                    }
                });
                break;
            case 5:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Unesi cene štrudli:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.cena_pozadina);
                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String unetaCena = String.valueOf(editTextParametar.getText());
                        int cenaCele  = Integer.parseInt(unetaCena.split("-")[0]);
                        int cenaPola = Integer.parseInt(unetaCena.split("-")[1]);
                        manifestacija.setCenaCela(cenaCele);
                        manifestacija.setCenaPolovina(cenaPola);

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",6);

                        startActivity(intent);
                    }
                });

                break;
            case 6:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Koliko si poneo maka:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.mak_pozadina);
                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String mak = String.valueOf(editTextParametar.getText());
                        int makCele  = Integer.parseInt(mak.split("-")[0]);
                        int makPola = Integer.parseInt(mak.split("-")[1]);
                        manifestacija.setMakCela(makCele);
                        manifestacija.setMakPolovina(makPola);;

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",7);

                        startActivity(intent);
                    }
                });
                break;
            case 7:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Koliko si poneo orasa:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.orasi_pozadina);
                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String orasi = String.valueOf(editTextParametar.getText());
                        int orasiCele  = Integer.parseInt(orasi.split("-")[0]);
                        int orasiPola = Integer.parseInt(orasi.split("-")[1]);
                        manifestacija.setOrasiCela(orasiCele);
                        manifestacija.setOrasiPolovina(orasiPola);

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",8);

                        startActivity(intent);
                    }
                });
                break;
            case 8:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Koliko si poneo višnji:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.visnja_pozadina);
                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String visnje = String.valueOf(editTextParametar.getText());
                        int visnjeCele  = Integer.parseInt(visnje.split("-")[0]);
                        int visnjePola = Integer.parseInt(visnje.split("-")[1]);
                        manifestacija.setVisnjaCela(visnjeCele);
                        manifestacija.setVisnjaPolovina(visnjePola);

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",9);

                        startActivity(intent);
                    }
                });
                break;
            case 9:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Koliko si poneo čoko višnji:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.cokovisnja_pozadina);
                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String cokovisnja = String.valueOf(editTextParametar.getText());
                        int cokovisnjaCele  = Integer.parseInt(cokovisnja.split("-")[0]);
                        int cokovisnjaPola = Integer.parseInt(cokovisnja.split("-")[1]);
                        manifestacija.setCokoVisnjaCela(cokovisnjaCele);
                        manifestacija.setCokoVisnjaPolovina(cokovisnjaPola);

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",10);

                        startActivity(intent);
                    }
                });
                break;
            case 10:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Koliko si poneo jabuka:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.jabuka_pozadina);
                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String jabuka = String.valueOf(editTextParametar.getText());
                        int jabukaCele  = Integer.parseInt(jabuka.split("-")[0]);
                        int jabukaPola = Integer.parseInt(jabuka.split("-")[1]);
                        manifestacija.setJabukaCela(jabukaCele);
                        manifestacija.setJabukaPolovina(jabukaPola);

                        Intent intent = new Intent(getApplicationContext(),NovaManifestacijaActivity.class);

                        intent.putExtra("manifestacija",manifestacija);
                        intent.putExtra("rBr",11);

                        startActivity(intent);
                    }
                });
                break;
            case 11:
                params = (ConstraintLayout.LayoutParams) gornjiNaslov.getLayoutParams();

                params.startToStart = gornjiNaslov.getId();
                params.endToEnd = gornjiNaslov.getId();
                params.topToTop = gornjiNaslov.getId();
                params.bottomToBottom = gornjiNaslov.getId();

                naslovParametar.setLayoutParams(params);
                gornjiNaslov.setVisibility(View.INVISIBLE);

                naslovParametar.setText("Koliko si poneo rogača:");
                naslovParametar.setTextSize(24);
                pozadina.setImageResource(R.drawable.rogac_pozadina);
                izaberiDatumButton.setVisibility(View.INVISIBLE);
                textViewDatum.setVisibility(View.INVISIBLE);

                daljeFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String rogac = String.valueOf(editTextParametar.getText());
                        int rogacCele  = Integer.parseInt(rogac.split("-")[0]);
                        int rogacPola = Integer.parseInt(rogac.split("-")[1]);
                        manifestacija.setRogacCela(rogacCele);
                        manifestacija.setRogacPolovina(rogacPola);

                        String zaProslediti ="Naziv manifestacije: "+manifestacija.getNaziv()+"\n"+
                                "\uD83D\uDCCDLokacija: "+manifestacija.getLokacija()+"\n"+
                                "\uD83D\uDDD3️Datum početka: "+manifestacija.getDatumPocetka()+"\n"+
                                "\uD83D\uDDD3️Datum kraja: "+manifestacija.getDatumKraja()+"\n"+
                                "⚫Mak cele: "+manifestacija.getMakCela()+"\n"+
                                "⚫Mak polovine: "+manifestacija.getMakPolovina()+"\n"+
                                "\uD83C\uDF30Orasi cele: "+manifestacija.getOrasiCela()+"\n"+
                                "\uD83C\uDF30Orasi polovine: "+manifestacija.getOrasiPolovina()+"\n"+
                                "\uD83C\uDF52Višnja cele: "+manifestacija.getVisnjaCela()+"\n"+
                                "\uD83C\uDF52Višnja polovine: "+manifestacija.getVisnjaPolovina()+"\n"+
                                "\uD83C\uDF6BČoko-višnja cele: "+manifestacija.getCokoVisnjaCela()+"\n"+
                                "\uD83C\uDF6BCokVisnjaPola: "+manifestacija.getCokoVisnjaPolovina()+"\n"+
                                "\uD83C\uDF4EJabuka cele: "+manifestacija.getJabukaCela()+"\n"+
                                "\uD83C\uDF4EJabuka polovine: "+manifestacija.getJabukaPolovina()+"\n"+
                                "\uD83D\uDFE4Rogač cele: "+manifestacija.getRogacCela()+"\n"+
                                "\uD83D\uDFE4Rogač polovine: "+manifestacija.getRogacPolovina();





                        Intent intent = new Intent(getApplicationContext(),ProveraActivity.class);

                        intent.putExtra("string",zaProslediti);
                        intent.putExtra("manifestacija",manifestacija);

                        startActivity(intent);
                    }
                });

                break;
        }
    }
    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            textViewDatum.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

}