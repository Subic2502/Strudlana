package rs.strudlana.strudlanaapp;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ManifestacijaAdapter extends RecyclerView.Adapter<ManifestacijaAdapter.ViewHolder> {

    List<Manifestacija> aktivneManifestacije;

    public ManifestacijaAdapter(List<Manifestacija> aktivneManifestacije) {
        this.aktivneManifestacije =aktivneManifestacije;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manifestacija_item, parent, false);
        return new ViewHolder(view,aktivneManifestacije);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Manifestacija manifestacijaItem = aktivneManifestacije.get(position);

        holder.rBr.setText(String.valueOf(position+1));
        holder.rBr.setTypeface(null,Typeface.BOLD);
        String naziv = manifestacijaItem.getNaziv() + " - ";
        holder.naziv.setText(naziv);
        holder.lokacija.setText(manifestacijaItem.getLokacija());

        holder.datumPocetka.setText(manifestacijaItem.getDatumPocetka());
        holder.datumKraja.setText(manifestacijaItem.getDatumKraja());

        String makVrednostOstalo = manifestacijaItem.getMakCela() + "-" + manifestacijaItem.getMakPolovina();
        holder.makVrednostOstalo.setText(makVrednostOstalo);
        String makVrednostProdato = manifestacijaItem.getMakCelaProdato() + "-" + manifestacijaItem.getMakPolovinaProdato();
        holder.makVrednostProdato.setText(makVrednostProdato);

        String orasiVrednostOstalo = manifestacijaItem.getOrasiCela() + "-" + manifestacijaItem.getOrasiPolovina();
        holder.orasiVrednostOstalo.setText(orasiVrednostOstalo);
        String orasiVrednostProdato = manifestacijaItem.getOrasiCelaProdato() + "-" + manifestacijaItem.getOrasiPolovinaProdato();
        holder.orasiVrednostProdato.setText(orasiVrednostProdato);

        String visnjaVrednostOstalo = manifestacijaItem.getVisnjaCela() + "-" + manifestacijaItem.getVisnjaPolovina();
        holder.visnjaVrednostOstalo.setText(visnjaVrednostOstalo);
        String visnjaVrednostProdato = manifestacijaItem.getVisnjaCelaProdato() + "-" + manifestacijaItem.getVisnjaPolovinaProdato();
        holder.visnjaVrednostProdato.setText(visnjaVrednostProdato);

        String cokoVisnjaVrednostOstalo = manifestacijaItem.getCokoVisnjaCela() + "-" + manifestacijaItem.getCokoVisnjaPolovina();
        holder.cokoVisnjaVrednostOstalo.setText(cokoVisnjaVrednostOstalo);
        String cokoVisnjaVrednostProdato = manifestacijaItem.getCokoVisnjaCelaProdato() + "-" + manifestacijaItem.getCokoVisnjaPolovinaProdato();
        holder.cokoVisnjaVrednostProdato.setText(cokoVisnjaVrednostProdato);

        String jabukaVrednostOstalo = manifestacijaItem.getJabukaCela() + "-" + manifestacijaItem.getJabukaPolovina();
        holder.jabukaVrednostOstalo.setText(jabukaVrednostOstalo);
        String jabukaVrednostProdato = manifestacijaItem.getJabukaCelaProdato() + "-" + manifestacijaItem.getJabukaPolovinaProdato();
        holder.jabukaVrednostProdato.setText(jabukaVrednostProdato);

        String rogacVrednostOstalo = manifestacijaItem.getRogacCela() + "-" + manifestacijaItem.getRogacPolovina();
        holder.rogacVrednostOstalo.setText(rogacVrednostOstalo);
        String rogacVrednostProdato = manifestacijaItem.getRogacCelaProdato() + "-" + manifestacijaItem.getRogacPolovinaProdato();
        holder.rogacVrednostProdato.setText(rogacVrednostProdato);


    }

    @Override
    public int getItemCount() {
        return aktivneManifestacije.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView rBr,naziv,lokacija;
        public TextView datumPocetka,datumKraja;
        public  TextView makVrednostProdato,makVrednostOstalo;
        public TextView orasiVrednostProdato,orasiVrednostOstalo;
        public TextView visnjaVrednostProdato,visnjaVrednostOstalo;
        public TextView cokoVisnjaVrednostProdato,cokoVisnjaVrednostOstalo;
        public TextView jabukaVrednostProdato,jabukaVrednostOstalo;
        public  TextView rogacVrednostProdato,rogacVrednostOstalo;



        public ViewHolder(@NonNull View itemView,List<Manifestacija> aktivneManifestacije) {
            super(itemView);
            rBr = itemView.findViewById(R.id.miItem_redniBroj);
            naziv = itemView.findViewById(R.id.mitem_naziv);
            lokacija = itemView.findViewById(R.id.mItem_lokacija);

            datumPocetka = itemView.findViewById(R.id.mItem_datumPocetkaVrednost);
            datumKraja = itemView.findViewById(R.id.mItem_datumKrajaVrednost);

            makVrednostOstalo = itemView.findViewById(R.id.mItem_makVrednostOstalo);
            makVrednostProdato = itemView.findViewById(R.id.mItem_makVrednostProdato);

            orasiVrednostOstalo = itemView.findViewById(R.id.mItem_orasiVrednostOstalo);
            orasiVrednostProdato = itemView.findViewById(R.id.mItem_orasiVrednostProdato);

            visnjaVrednostOstalo = itemView.findViewById(R.id.mItem_visnjaVrednostOstalo);
            visnjaVrednostProdato = itemView.findViewById(R.id.mItem_visnjaVrednostProdato);

            cokoVisnjaVrednostOstalo = itemView.findViewById(R.id.mItem_cokoVisnjaVrednostOstalo);
            cokoVisnjaVrednostProdato = itemView.findViewById(R.id.mItem_cokoVisnjaVrednostProdato);

            jabukaVrednostOstalo = itemView.findViewById(R.id.mItem_jabukaVrednostOstalo);
            jabukaVrednostProdato = itemView.findViewById(R.id.mItem_jabukaVrednostProdato);

            rogacVrednostOstalo = itemView.findViewById(R.id.mItem_rogacVrednostOstalo);
            rogacVrednostProdato = itemView.findViewById(R.id.mItem_rogacVrednostProdato);
        }
    }
}
