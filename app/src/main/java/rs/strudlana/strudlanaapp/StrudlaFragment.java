package rs.strudlana.strudlanaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StrudlaFragment extends Fragment {

    Button napraviStrudleButton,azurirajStrudleButton;
    Button prodajPijacaButton,prodajMusterijaButton;
    Button napraviIzvestajButton;

    Button dodajSirovineButton,azurirajSirovineButton;


    public StrudlaFragment() {
        // Required empty public constructor
    }

    public static StrudlaFragment newInstance(String param1, String param2) {
        StrudlaFragment fragment = new StrudlaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_strudla,container,false);


        napraviIzvestajButton = view.findViewById(R.id.fr_studla_buttonNapraviIzvestaj);
        napraviIzvestajButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),NapraviIzvestajActivity.class);

                startActivity(intent);
            }
        });

        napraviStrudleButton = view.findViewById(R.id.fr_studla_buttonNapravi);
        napraviStrudleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),NapraviStrudleActivity.class);
                intent.putExtra("Operacija","Dodavanje");

                startActivity(intent);
            }
        });

        azurirajStrudleButton = view.findViewById(R.id.fr_studla_buttonNovoStanje);
        azurirajStrudleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),NapraviStrudleActivity.class);
                intent.putExtra("Operacija","Azuriranje");

                startActivity(intent);
            }
        });

        prodajPijacaButton = view.findViewById(R.id.fr_studla_buttonProdajPijaca);
        prodajPijacaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),ProdajPijacaActivity.class);

                startActivity(intent);
            }
        });

        prodajMusterijaButton = view.findViewById(R.id.fr_studla_buttonProdajMusterija);
        prodajMusterijaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dodajSirovineButton = view.findViewById(R.id.fr_strudla_dodajSirovine);
        dodajSirovineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),DodajSirovineActivity.class);

                intent.putExtra("Operacija","Dodavanje");
                startActivity(intent);
            }
        });

        azurirajSirovineButton = view.findViewById(R.id.fr_strudla_novoStanjeSirovine);
        azurirajSirovineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),DodajSirovineActivity.class);

                intent.putExtra("Operacija","Azuriranje");
                startActivity(intent);
            }
        });

        return view;
    }
}