package rs.strudlana.strudlanaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import rs.strudlana.strudlanaapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //Vracanje iz nove manifestacije u Manifestacija fragment
        if(getIntent().getStringExtra("fragment") != null){
            setContentView(binding.getRoot());
            replaceFragment(new ManifestacijaFragment());
            Toast.makeText(MainActivity.this, "Uspesno dodata manifestacija u bazu!", Toast.LENGTH_LONG).show();
        }else{
            setContentView(binding.getRoot());
            replaceFragment(new StrudlaFragment());
        }

        binding.bottomNavigationView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){

                case R.id.bottomManifest:
                    replaceFragment(new ManifestacijaFragment());
                    break;
                case R.id.bottomStrudla:
                    replaceFragment(new StrudlaFragment());
                    break;
                case R.id.bottomInfo:
                    replaceFragment(new InfoFragment());
                    break;
                case R.id.bottomPodesavanja:
                    replaceFragment(new PodesavanjaFragment());
                    break;

            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameMain,fragment);
        fragmentTransaction.commit();
    }
}