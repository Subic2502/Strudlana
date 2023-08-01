package rs.strudlana.strudlanaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ManifestacijaFragment extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();



    public ManifestacijaFragment() {
        // Required empty public constructor
    }


    public static ManifestacijaFragment newInstance(String param1, String param2) {
        ManifestacijaFragment fragment = new ManifestacijaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manifestacija, container, false);

        recyclerView = view.findViewById(R.id.fr_manifestacija_recyclerview);
        fab = view.findViewById(R.id.fabButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Manifestacija manifestacija = new Manifestacija();

                Intent intent = new Intent(getContext(), NovaManifestacijaActivity.class);

                intent.putExtra("manifestacija", manifestacija);
                intent.putExtra("rBr",1);


                startActivity(intent);
            }
        });

        vidiAktivneManifestacije().thenAccept(aktivneManifestacije -> {
            ManifestacijaAdapter manifestacijaAdapter = new ManifestacijaAdapter(aktivneManifestacije);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(manifestacijaAdapter);
        }).exceptionally(ex -> {
            // Handle any errors
            return null;
        });

        return view;
    }



    // Method to return the list of unique identifiers from AktivneManifestacije
    public CompletableFuture<List<Manifestacija>> vidiAktivneManifestacije() {
        DatabaseReference aktivneManifestacijeRef = databaseReference.child("AktivneManifestacije");

        CompletableFuture<List<Manifestacija>> future = new CompletableFuture<>();

        aktivneManifestacijeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Manifestacija> aktivneManifestacije = new ArrayList<>();
                long brojManifestacija = dataSnapshot.getChildrenCount();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String uniqueIdentifier = snapshot.getKey();

                    DatabaseReference manifestacijaItemRef = databaseReference.child("Manifestacija").child(uniqueIdentifier);
                    manifestacijaItemRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            // Povrati info od svake Manifestacija item i dodaj u list aktivneManifestacije

                            DataSnapshot pocetakDatumSnapshot = dataSnapshot.child("PocetakDatum");
                            DataSnapshot krajDatumSnapshot = dataSnapshot.child("KrajDatum");
                            DataSnapshot lokacijaSnapshot = dataSnapshot.child("Lokacija");
                            DataSnapshot nazivSnapshot = dataSnapshot.child("Naziv");

                            //Data snapshot za lager
                            DataSnapshot lagerMakSnapshot = dataSnapshot.child("Lager").child("Mak");
                            DataSnapshot lagerMakPolovinaSnapshot = dataSnapshot.child("Lager").child("MakPolovina");

                            DataSnapshot lagerOrasiSnapshot = dataSnapshot.child("Lager").child("Orasi");
                            DataSnapshot lagerOrasiPolovinaSnapshot = dataSnapshot.child("Lager").child("OrasiPolovina");

                            DataSnapshot lagerVisnjaSnapshot = dataSnapshot.child("Lager").child("Visnja");
                            DataSnapshot lagerVisnjaPolovinaSnapshot = dataSnapshot.child("Lager").child("VisnjaPolovina");

                            DataSnapshot lagerCokoVisnjaSnapshot = dataSnapshot.child("Lager").child("CokoVisnja");
                            DataSnapshot lagerCokoVisnjaPolovinaSnapshot = dataSnapshot.child("Lager").child("CokoVisnjaPolovina");

                            DataSnapshot lagerJabukaSnapshot = dataSnapshot.child("Lager").child("Jabuka");
                            DataSnapshot lagerJabukaPolovinaSnapshot = dataSnapshot.child("Lager").child("JabukaPolovina");

                            DataSnapshot lagerRogacSnapshot = dataSnapshot.child("Lager").child("Rogac");
                            DataSnapshot lagerRogacPolovinaSnapshot = dataSnapshot.child("Lager").child("RogacPolovina");

                            //Datgasnapshot za prodato
                            DataSnapshot prodatoMakSnapshot = dataSnapshot.child("Prodato").child("Mak");
                            DataSnapshot prodatoMakPolovinaSnapshot = dataSnapshot.child("Prodato").child("MakPolovina");

                            DataSnapshot prodatoOrasiSnapshot = dataSnapshot.child("Prodato").child("Orasi");
                            DataSnapshot prodatoOrasiPolovinaSnapshot = dataSnapshot.child("Prodato").child("OrasiPolovina");

                            DataSnapshot prodatoVisnjaSnapshot = dataSnapshot.child("Prodato").child("Visnja");
                            DataSnapshot prodatoVisnjaPolovinaSnapshot = dataSnapshot.child("Prodato").child("VisnjaPolovina");

                            DataSnapshot prodatoCokoVisnjaSnapshot = dataSnapshot.child("Prodato").child("CokoVisnja");
                            DataSnapshot prodatoCokoVisnjaPolovinaSnapshot = dataSnapshot.child("Prodato").child("CokoVisnjaPolovina");

                            DataSnapshot prodatoJabukaSnapshot = dataSnapshot.child("Prodato").child("Jabuka");
                            DataSnapshot prodatoJabukaPolovinaSnapshot = dataSnapshot.child("Prodato").child("JabukaPolovina");

                            DataSnapshot prodatoRogacSnapshot = dataSnapshot.child("Prodato").child("Rogac");
                            DataSnapshot prodatoRogacPolovinaSnapshot = dataSnapshot.child("Prodato").child("RogacPolovina");


                            String pocetakDatum = pocetakDatumSnapshot.getValue(String.class);
                            String krajDatum = krajDatumSnapshot.getValue(String.class);
                            String lokacija = lokacijaSnapshot.getValue(String.class);
                            String naziv = nazivSnapshot.getValue(String.class);


                            //Citanje lagera strudli iz baze
                            int lagerMakInt = lagerMakSnapshot.getValue(Integer.class);
                            int lagerMakPolovinaInt = lagerMakPolovinaSnapshot.getValue(Integer.class);

                            int lagerOrasiInt = lagerOrasiSnapshot.getValue(Integer.class);
                            int lagerOrasiPolovinaInt = lagerOrasiPolovinaSnapshot.getValue(Integer.class);

                            int lagerVisnjaInt = lagerVisnjaSnapshot.getValue(Integer.class);
                            int lagerVisnjaPolovinaInt = lagerVisnjaPolovinaSnapshot.getValue(Integer.class);

                            int lagerCokoVisnjaInt = lagerCokoVisnjaSnapshot.getValue(Integer.class);
                            int lagerCokoVisnjaPolovinaInt = lagerCokoVisnjaPolovinaSnapshot.getValue(Integer.class);

                            int lagerJabukaInt = lagerJabukaSnapshot.getValue(Integer.class);
                            int lagerJabukaPolovinaInt = lagerJabukaPolovinaSnapshot.getValue(Integer.class);

                            int lagerRogacInt = lagerRogacSnapshot.getValue(Integer.class);
                            int lagerRogacPolovinaInt = lagerRogacPolovinaSnapshot.getValue(Integer.class);

                            Manifestacija manifestacija = new Manifestacija();
                            manifestacija.setLokacija(lokacija);
                            manifestacija.setNaziv(naziv);
                            manifestacija.setDatumPocetka(pocetakDatum);
                            manifestacija.setDatumKraja(krajDatum);

                            //dodavanje lagera u objekat manifestacije da bi se posle citala
                            manifestacija.setMakCela(lagerMakInt);
                            manifestacija.setMakPolovina(lagerMakPolovinaInt);
                            manifestacija.setOrasiCela(lagerOrasiInt);
                            manifestacija.setOrasiPolovina(lagerOrasiPolovinaInt);
                            manifestacija.setVisnjaCela(lagerVisnjaInt);
                            manifestacija.setVisnjaPolovina(lagerVisnjaPolovinaInt);
                            manifestacija.setCokoVisnjaCela(lagerCokoVisnjaInt);
                            manifestacija.setCokoVisnjaPolovina(lagerCokoVisnjaPolovinaInt);
                            manifestacija.setJabukaCela(lagerJabukaInt);
                            manifestacija.setJabukaPolovina(lagerJabukaPolovinaInt);
                            manifestacija.setRogacCela(lagerRogacInt);
                            manifestacija.setRogacPolovina(lagerRogacPolovinaInt);

                            //citanje prodatih iz baze
                            int prodatoMakInt = prodatoMakSnapshot.getValue(Integer.class);
                            int prodatoMakPolovinaInt = prodatoMakPolovinaSnapshot.getValue(Integer.class);

                            int prodatoOrasiInt = prodatoOrasiSnapshot.getValue(Integer.class);
                            int prodatoOrasiPolovinaInt = prodatoOrasiPolovinaSnapshot.getValue(Integer.class);

                            int prodatoVisnjaInt = prodatoVisnjaSnapshot.getValue(Integer.class);
                            int prodatoVisnjaPolovinaInt = prodatoVisnjaPolovinaSnapshot.getValue(Integer.class);

                            int prodatoCokoVisnjaInt = prodatoCokoVisnjaSnapshot.getValue(Integer.class);
                            int prodatoCokoVisnjaPolovinaInt = prodatoCokoVisnjaPolovinaSnapshot.getValue(Integer.class);

                            int prodatoJabukaInt = prodatoJabukaSnapshot.getValue(Integer.class);
                            int prodatoJabukaPolovinaInt = prodatoJabukaPolovinaSnapshot.getValue(Integer.class);

                            int prodatoRogacInt = prodatoRogacSnapshot.getValue(Integer.class);
                            int prodatoRogacPolovinaInt = prodatoRogacPolovinaSnapshot.getValue(Integer.class);

                            //dodavanje prodatih  u objekat manifestacije da bi se posle citala
                            manifestacija.setMakCelaProdato(prodatoMakInt);
                            manifestacija.setMakPolovinaProdato(prodatoMakPolovinaInt);
                            manifestacija.setOrasiCelaProdato(prodatoOrasiInt);
                            manifestacija.setOrasiPolovinaProdato(prodatoOrasiPolovinaInt);
                            manifestacija.setVisnjaCelaProdato(prodatoVisnjaInt);
                            manifestacija.setVisnjaPolovinaProdato(prodatoVisnjaPolovinaInt);
                            manifestacija.setCokoVisnjaCelaProdato(prodatoCokoVisnjaInt);
                            manifestacija.setCokoVisnjaPolovinaProdato(prodatoCokoVisnjaPolovinaInt);
                            manifestacija.setJabukaCelaProdato(prodatoJabukaInt);
                            manifestacija.setJabukaPolovinaProdato(prodatoJabukaPolovinaInt);
                            manifestacija.setRogacCelaProdato(prodatoRogacInt);
                            manifestacija.setRogacPolovinaProdato(prodatoRogacPolovinaInt);


                            System.out.println(lokacija);
                            System.out.println(naziv);
                            System.out.println(pocetakDatum);
                            System.out.println(krajDatum);
                            System.out.println("LagerMak - "+lagerMakInt);

                            aktivneManifestacije.add(manifestacija);

                            // Provera da li su sve uhcvacene
                            if (aktivneManifestacije.size() == brojManifestacija) {
                                future.complete(aktivneManifestacije);
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            future.completeExceptionally(databaseError.toException());
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }


    // Method to retrieve specific fields from Manifestacija objects using unique identifiers
    public List<Manifestacija> vratiAktivneManifestacije(List<String> uniqueIdentifiers) {
        DatabaseReference manifestacijaRef = databaseReference.child("Manifestacija");
        List<Manifestacija> aktivneManifestacije = new ArrayList<>();
        System.out.println("uso u on vrati aktivne u aktivnim");


        for (String uniqueIdentifier : uniqueIdentifiers) {
            DatabaseReference manifestacijaItemRef = manifestacijaRef.child(uniqueIdentifier);
            System.out.println("uso u for u vratiAktivne");


            manifestacijaItemRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    System.out.println("uso u on datachange u aktivnim");
                    DataSnapshot beleskeSnapshot = dataSnapshot.child("Beleske");
                    DataSnapshot cenaPolovineSnapshot = dataSnapshot.child("CenaPolovine");
                    DataSnapshot cenaStrudleSnapshot = dataSnapshot.child("CenaStrudle");
                    DataSnapshot pocetakDatumSnapshot = dataSnapshot.child("PocetakDatum");
                    DataSnapshot krajDatumSnapshot = dataSnapshot.child("KrajDatum");
                    DataSnapshot lokacijaSnapshot = dataSnapshot.child("Lokacija");
                    DataSnapshot nazivSnapshot = dataSnapshot.child("Naziv");

                    DataSnapshot lagerMakSnapshot = dataSnapshot.child("Lager").child("Mak");
                    DataSnapshot lagerMakPolovinaSnapshot = dataSnapshot.child("Lager").child("MakPolovina");


                    String beleske = beleskeSnapshot.getValue(String.class);
                    String cenaPolovine = cenaPolovineSnapshot.getValue(String.class);
                    String cenaStrudle = cenaStrudleSnapshot.getValue(String.class);
                    String pocetakDatum = pocetakDatumSnapshot.getValue(String.class);
                    String krajDatum = krajDatumSnapshot.getValue(String.class);
                    String lokacija = lokacijaSnapshot.getValue(String.class);
                    String naziv = nazivSnapshot.getValue(String.class);

                    String lagerMak = lagerMakSnapshot.getValue(String.class);
                    String lagerMakPolovina = lagerMakPolovinaSnapshot.getValue(String.class);

                    Manifestacija manifestacija = new Manifestacija();
                    manifestacija.setLokacija(lokacija);
                    manifestacija.setNaziv(naziv);
                    manifestacija.setDatumPocetka(pocetakDatum);
                    manifestacija.setDatumKraja(krajDatum);
                    manifestacija.setMakCela(Integer.parseInt(lagerMak));

                    System.out.println(lokacija);
                    System.out.println(naziv);
                    System.out.println(pocetakDatum);
                    System.out.println(krajDatum);
                    System.out.println(lagerMak);

                    aktivneManifestacije.add(manifestacija);


                    // Do something with the separate strings (beleske, cenaPolovine, cenaStrudle, etc.)
                    // For example, pass them to another method or display the data
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Handle any errors
                }
            });
        }
        return aktivneManifestacije;
    }


}