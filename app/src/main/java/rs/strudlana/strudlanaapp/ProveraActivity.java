package rs.strudlana.strudlanaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProveraActivity extends AppCompatActivity {

    private TextView proveraInformacije;
    private FloatingActionButton fab;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provera);

        String string = getIntent().getStringExtra("string");
        Manifestacija manifestacija = (Manifestacija) getIntent().getSerializableExtra("manifestacija");

        proveraInformacije = findViewById(R.id.proveri_informacije);
        proveraInformacije.setText(string);

        fab = findViewById(R.id.provera_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dodajUBazu(manifestacija);

                Intent pocetnaAktivnost = new Intent(getApplicationContext(),MainActivity.class);

                pocetnaAktivnost.putExtra("fragment","ManifestacijaFragment");

                startActivity(pocetnaAktivnost);
            }
        });


    }

    private void dodajUBazu(Manifestacija manifestacija) {
        DatabaseReference manifestacijaRef = databaseReference.child("Manifestacija");
        String manifestacijaId = manifestacijaRef.push().getKey();

        assert manifestacijaId != null;
        DatabaseReference idRef = manifestacijaRef.child(manifestacijaId);
        DatabaseReference aktivneManifestacijeRef = databaseReference.child("AktivneManifestacije");


        String mesecGodinaString = manifestacija.getDatumPocetka().split("-")[1] + "-" + manifestacija.getDatumPocetka().split("-")[2];
        DatabaseReference mesecGodinaRef = databaseReference.child("M-G-Manifestacija").child(mesecGodinaString);
        mesecGodinaRef.child(manifestacijaId).setValue(mesecGodinaString);


        aktivneManifestacijeRef.child(manifestacijaId).setValue("AKTIVNA");

        idRef.child("Beleske").setValue("");
        idRef.child("CenaPolovine").setValue(manifestacija.getCenaPolovina());
        idRef.child("CenaStrudle").setValue(manifestacija.getCenaCela());
        idRef.child("PocetakDatum").setValue(manifestacija.getDatumPocetka());
        idRef.child("KrajDatum").setValue(manifestacija.getDatumKraja());
        idRef.child("Lokacija").setValue(manifestacija.getLokacija());
        idRef.child("Naziv").setValue(manifestacija.getNaziv());
        idRef.child("Prihod").setValue(0);
        idRef.child("Rashod").setValue(0);
        idRef.child("Status").setValue("AKTIVNA");

        DatabaseReference lagerRef = idRef.child("Lager");

        lagerRef.child("Mak").setValue(manifestacija.getMakCela());
        lagerRef.child("MakPolovina").setValue(manifestacija.getMakPolovina());
        lagerRef.child("Orasi").setValue(manifestacija.getOrasiCela());
        lagerRef.child("OrasiPolovina").setValue(manifestacija.getOrasiPolovina());
        lagerRef.child("Visnja").setValue(manifestacija.getVisnjaCela());
        lagerRef.child("VisnjaPolovina").setValue(manifestacija.getVisnjaPolovina());
        lagerRef.child("CokoVisnja").setValue(manifestacija.getCokoVisnjaCela());
        lagerRef.child("CokoVisnjaPolovina").setValue(manifestacija.getCokoVisnjaPolovina());
        lagerRef.child("Jabuka").setValue(manifestacija.getJabukaCela());
        lagerRef.child("JabukaPolovina").setValue(manifestacija.getJabukaPolovina());
        lagerRef.child("Rogac").setValue(manifestacija.getRogacCela());
        lagerRef.child("RogacPolovina").setValue(manifestacija.getRogacPolovina());

        DatabaseReference prodatoRef = idRef.child("Prodato");

        prodatoRef.child("Mak").setValue(0);
        prodatoRef.child("MakPolovina").setValue(0);
        prodatoRef.child("Orasi").setValue(0);
        prodatoRef.child("OrasiPolovina").setValue(0);
        prodatoRef.child("Visnja").setValue(0);
        prodatoRef.child("VisnjaPolovina").setValue(0);
        prodatoRef.child("CokoVisnja").setValue(0);
        prodatoRef.child("CokoVisnjaPolovina").setValue(0);
        prodatoRef.child("Jabuka").setValue(0);
        prodatoRef.child("JabukaPolovina").setValue(0);
        prodatoRef.child("Rogac").setValue(0);
        prodatoRef.child("RogacPolovina").setValue(0);


    }
}