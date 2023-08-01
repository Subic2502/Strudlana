package rs.strudlana.strudlanaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NapraviStrudleProveraActivity extends AppCompatActivity {

    DatabaseReference strudlaRef = FirebaseDatabase.getInstance().getReference().child("Strudla");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_napravi_strudle_provera);

        String operacija = getIntent().getStringExtra("Operacija");

        if(operacija.equals("Dodavanje")){
            int[] vrednosti = getIntent().getIntArrayExtra("Vrednosti");


            DatabaseReference makRef = strudlaRef.child("Mak");
            DatabaseReference orasiRef = strudlaRef.child("Orasi");
            DatabaseReference visnjaRef = strudlaRef.child("Visnja");
            DatabaseReference cokoVisnjaRef = strudlaRef.child("CokoVisnja");
            DatabaseReference jabukaRef = strudlaRef.child("Jabuka");
            DatabaseReference rogacRef = strudlaRef.child("Rogac");

            strudlaRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    DataSnapshot lagerMakSnapshot = snapshot.child("Mak").child("Lager");
                    DataSnapshot lagerOrasiSnapshot = snapshot.child("Orasi").child("Lager");
                    DataSnapshot lagerVisnjaSnapshot = snapshot.child("Visnja").child("Lager");
                    DataSnapshot lagerCokoVisnjaSnapshot = snapshot.child("CokoVisnja").child("Lager");
                    DataSnapshot lagerJabukaSnapshot = snapshot.child("Jabuka").child("Lager");
                    DataSnapshot lagerRogacSnapshot = snapshot.child("Rogac").child("Lager");

                    int stariMak = lagerMakSnapshot.getValue(Integer.class);
                    int stariOrasi = lagerOrasiSnapshot.getValue(Integer.class);
                    int staraVisnja = lagerVisnjaSnapshot.getValue(Integer.class);
                    int staraCokoVisnja = lagerCokoVisnjaSnapshot.getValue(Integer.class);
                    int staraJabuka = lagerJabukaSnapshot.getValue(Integer.class);
                    int stariRogac = lagerRogacSnapshot.getValue(Integer.class);

                    int novoStanjeMak = stariMak + vrednosti[0];
                    int novoStanjeOrasi = stariOrasi + vrednosti[1];
                    int novoStanjeVisnja = staraVisnja + vrednosti[2];
                    int novoStanjeCokoVisnja = staraCokoVisnja + vrednosti[3];
                    int novoStanjeJabuka = staraJabuka + vrednosti[4];
                    int novoStanjeRogac = stariRogac + vrednosti[5];

                    makRef.child("Lager").setValue(novoStanjeMak);
                    orasiRef.child("Lager").setValue(novoStanjeOrasi);
                    visnjaRef.child("Lager").setValue(novoStanjeVisnja);
                    cokoVisnjaRef.child("Lager").setValue(novoStanjeCokoVisnja);
                    jabukaRef.child("Lager").setValue(novoStanjeJabuka);
                    rogacRef.child("Lager").setValue(novoStanjeRogac);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }else{
            int[] vrednosti = getIntent().getIntArrayExtra("Vrednosti");

            DatabaseReference makRef = strudlaRef.child("Mak");
            DatabaseReference orasiRef = strudlaRef.child("Orasi");
            DatabaseReference visnjaRef = strudlaRef.child("Visnja");
            DatabaseReference cokoVisnjaRef = strudlaRef.child("CokoVisnja");
            DatabaseReference jabukaRef = strudlaRef.child("Jabuka");
            DatabaseReference rogacRef = strudlaRef.child("Rogac");

            makRef.child("Lager").setValue(vrednosti[0]);
            orasiRef.child("Lager").setValue(vrednosti[1]);
            visnjaRef.child("Lager").setValue(vrednosti[2]);
            cokoVisnjaRef.child("Lager").setValue(vrednosti[3]);
            jabukaRef.child("Lager").setValue(vrednosti[4]);
            rogacRef.child("Lager").setValue(vrednosti[5]);


        }
    }
}