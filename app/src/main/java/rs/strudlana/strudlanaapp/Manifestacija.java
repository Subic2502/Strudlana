package rs.strudlana.strudlanaapp;

import java.io.Serializable;

public class Manifestacija implements Serializable {

    int redniBroj;
    int cenaPolovina,cenaCela;
    String datumPocetka,datumKraja;

    int cokoVisnjaCela,cokoVisnjaPolovina;
    int orasiCela,orasiPolovina;
    int makCela,makPolovina;
    int visnjaCela,visnjaPolovina;
    int jabukaCela,jabukaPolovina;
    int rogacCela,rogacPolovina;

    String lokacija;
    String naziv;

    int cokoVisnjaCelaProdato,cokoVisnjaPolovinaProdato;
    int orasiCelaProdato,orasiPolovinaProdato;
    int makCelaProdato,makPolovinaProdato;
    int visnjaCelaProdato,visnjaPolovinaProdato;
    int jabukaCelaProdato,jabukaPolovinaProdato;
    int rogacCelaProdato,rogacPolovinaProdato;

    int prihod;
    int rashod;

    String status;

    int brasnoCena,brasnoKolicina,brasnoVrednostUtroseno,brasnoMernaJedinica;
    int kvasacCena,kvasacKolicina,kvasacVrednostUtroseno,kvasacMernaJedinica;
    int mlekoCena,mlekoKolicina,mlekoVrednostUtroseno,mlekoMernaJedinica;
    int nadevJabukaCena,nadevJabukaKolicina,nadevJabukaVrednostUtroseno,nadevJabukaMernaJedinica;
    int nadevMakCena,nadevMakKolicina,nadevMakVrednostUtroseno,nadevMakMernaJedinica;
    int nadevOrasiCena,nadevOrasiKolicina,nadevOrasiVrednostUtroseno,nadevOrasiMernaJedinica;
    int nadevKremCena,nadevKremKolicina,nadevKremVrednostUtroseno,nadevKremMernaJedinica;
    int nadevVisnjaCena,nadevVisnjaKolicina,nadevVisnjaVrednostUtroseno,nadevVisnjaMernaJedinica;
    int papirZaPecenjeCena,papirZaPecenjeKolicina,papirZaPecenjeVrednostUtroseno,papirZaPecenjeMernaJedinica;
    int secerVisnjaCena,secerKolicina,secerVrednostUtroseno,secerMernaJedinica;

    int cenaStanda,dnevnica,hranaPice;
    int putarina;

    public Manifestacija() {
    }

    public int getBrasnoCena() {
        return brasnoCena;
    }

    public void setBrasnoCena(int brasnoCena) {
        this.brasnoCena = brasnoCena;
    }

    public int getBrasnoKolicina() {
        return brasnoKolicina;
    }

    public void setBrasnoKolicina(int brasnoKolicina) {
        this.brasnoKolicina = brasnoKolicina;
    }

    public int getBrasnoVrednostUtroseno() {
        return brasnoVrednostUtroseno;
    }

    public void setBrasnoVrednostUtroseno(int brasnoVrednostUtroseno) {
        this.brasnoVrednostUtroseno = brasnoVrednostUtroseno;
    }

    public int getBrasnoMernaJedinica() {
        return brasnoMernaJedinica;
    }

    public void setBrasnoMernaJedinica(int brasnoMernaJedinica) {
        this.brasnoMernaJedinica = brasnoMernaJedinica;
    }

    public int getKvasacCena() {
        return kvasacCena;
    }

    public void setKvasacCena(int kvasacCena) {
        this.kvasacCena = kvasacCena;
    }

    public int getKvasacKolicina() {
        return kvasacKolicina;
    }

    public void setKvasacKolicina(int kvasacKolicina) {
        this.kvasacKolicina = kvasacKolicina;
    }

    public int getKvasacVrednostUtroseno() {
        return kvasacVrednostUtroseno;
    }

    public void setKvasacVrednostUtroseno(int kvasacVrednostUtroseno) {
        this.kvasacVrednostUtroseno = kvasacVrednostUtroseno;
    }

    public int getKvasacMernaJedinica() {
        return kvasacMernaJedinica;
    }

    public void setKvasacMernaJedinica(int kvasacMernaJedinica) {
        this.kvasacMernaJedinica = kvasacMernaJedinica;
    }

    public int getMlekoCena() {
        return mlekoCena;
    }

    public void setMlekoCena(int mlekoCena) {
        this.mlekoCena = mlekoCena;
    }

    public int getMlekoKolicina() {
        return mlekoKolicina;
    }

    public void setMlekoKolicina(int mlekoKolicina) {
        this.mlekoKolicina = mlekoKolicina;
    }

    public int getMlekoVrednostUtroseno() {
        return mlekoVrednostUtroseno;
    }

    public void setMlekoVrednostUtroseno(int mlekoVrednostUtroseno) {
        this.mlekoVrednostUtroseno = mlekoVrednostUtroseno;
    }

    public int getMlekoMernaJedinica() {
        return mlekoMernaJedinica;
    }

    public void setMlekoMernaJedinica(int mlekoMernaJedinica) {
        this.mlekoMernaJedinica = mlekoMernaJedinica;
    }

    public int getNadevJabukaCena() {
        return nadevJabukaCena;
    }

    public void setNadevJabukaCena(int nadevJabukaCena) {
        this.nadevJabukaCena = nadevJabukaCena;
    }

    public int getNadevJabukaKolicina() {
        return nadevJabukaKolicina;
    }

    public void setNadevJabukaKolicina(int nadevJabukaKolicina) {
        this.nadevJabukaKolicina = nadevJabukaKolicina;
    }

    public int getNadevJabukaVrednostUtroseno() {
        return nadevJabukaVrednostUtroseno;
    }

    public void setNadevJabukaVrednostUtroseno(int nadevJabukaVrednostUtroseno) {
        this.nadevJabukaVrednostUtroseno = nadevJabukaVrednostUtroseno;
    }

    public int getNadevJabukaMernaJedinica() {
        return nadevJabukaMernaJedinica;
    }

    public void setNadevJabukaMernaJedinica(int nadevJabukaMernaJedinica) {
        this.nadevJabukaMernaJedinica = nadevJabukaMernaJedinica;
    }

    public int getNadevMakCena() {
        return nadevMakCena;
    }

    public void setNadevMakCena(int nadevMakCena) {
        this.nadevMakCena = nadevMakCena;
    }

    public int getNadevMakKolicina() {
        return nadevMakKolicina;
    }

    public void setNadevMakKolicina(int nadevMakKolicina) {
        this.nadevMakKolicina = nadevMakKolicina;
    }

    public int getNadevMakVrednostUtroseno() {
        return nadevMakVrednostUtroseno;
    }

    public void setNadevMakVrednostUtroseno(int nadevMakVrednostUtroseno) {
        this.nadevMakVrednostUtroseno = nadevMakVrednostUtroseno;
    }

    public int getNadevMakMernaJedinica() {
        return nadevMakMernaJedinica;
    }

    public void setNadevMakMernaJedinica(int nadevMakMernaJedinica) {
        this.nadevMakMernaJedinica = nadevMakMernaJedinica;
    }

    public int getNadevOrasiCena() {
        return nadevOrasiCena;
    }

    public void setNadevOrasiCena(int nadevOrasiCena) {
        this.nadevOrasiCena = nadevOrasiCena;
    }

    public int getNadevOrasiKolicina() {
        return nadevOrasiKolicina;
    }

    public void setNadevOrasiKolicina(int nadevOrasiKolicina) {
        this.nadevOrasiKolicina = nadevOrasiKolicina;
    }

    public int getNadevOrasiVrednostUtroseno() {
        return nadevOrasiVrednostUtroseno;
    }

    public void setNadevOrasiVrednostUtroseno(int nadevOrasiVrednostUtroseno) {
        this.nadevOrasiVrednostUtroseno = nadevOrasiVrednostUtroseno;
    }

    public int getNadevOrasiMernaJedinica() {
        return nadevOrasiMernaJedinica;
    }

    public void setNadevOrasiMernaJedinica(int nadevOrasiMernaJedinica) {
        this.nadevOrasiMernaJedinica = nadevOrasiMernaJedinica;
    }

    public int getNadevKremCena() {
        return nadevKremCena;
    }

    public void setNadevKremCena(int nadevKremCena) {
        this.nadevKremCena = nadevKremCena;
    }

    public int getNadevKremKolicina() {
        return nadevKremKolicina;
    }

    public void setNadevKremKolicina(int nadevKremKolicina) {
        this.nadevKremKolicina = nadevKremKolicina;
    }

    public int getNadevKremVrednostUtroseno() {
        return nadevKremVrednostUtroseno;
    }

    public void setNadevKremVrednostUtroseno(int nadevKremVrednostUtroseno) {
        this.nadevKremVrednostUtroseno = nadevKremVrednostUtroseno;
    }

    public int getNadevKremMernaJedinica() {
        return nadevKremMernaJedinica;
    }

    public void setNadevKremMernaJedinica(int nadevKremMernaJedinica) {
        this.nadevKremMernaJedinica = nadevKremMernaJedinica;
    }

    public int getNadevVisnjaCena() {
        return nadevVisnjaCena;
    }

    public void setNadevVisnjaCena(int nadevVisnjaCena) {
        this.nadevVisnjaCena = nadevVisnjaCena;
    }

    public int getNadevVisnjaKolicina() {
        return nadevVisnjaKolicina;
    }

    public void setNadevVisnjaKolicina(int nadevVisnjaKolicina) {
        this.nadevVisnjaKolicina = nadevVisnjaKolicina;
    }

    public int getNadevVisnjaVrednostUtroseno() {
        return nadevVisnjaVrednostUtroseno;
    }

    public void setNadevVisnjaVrednostUtroseno(int nadevVisnjaVrednostUtroseno) {
        this.nadevVisnjaVrednostUtroseno = nadevVisnjaVrednostUtroseno;
    }

    public int getNadevVisnjaMernaJedinica() {
        return nadevVisnjaMernaJedinica;
    }

    public void setNadevVisnjaMernaJedinica(int nadevVisnjaMernaJedinica) {
        this.nadevVisnjaMernaJedinica = nadevVisnjaMernaJedinica;
    }

    public int getPapirZaPecenjeCena() {
        return papirZaPecenjeCena;
    }

    public void setPapirZaPecenjeCena(int papirZaPecenjeCena) {
        this.papirZaPecenjeCena = papirZaPecenjeCena;
    }

    public int getPapirZaPecenjeKolicina() {
        return papirZaPecenjeKolicina;
    }

    public void setPapirZaPecenjeKolicina(int papirZaPecenjeKolicina) {
        this.papirZaPecenjeKolicina = papirZaPecenjeKolicina;
    }

    public int getPapirZaPecenjeVrednostUtroseno() {
        return papirZaPecenjeVrednostUtroseno;
    }

    public void setPapirZaPecenjeVrednostUtroseno(int papirZaPecenjeVrednostUtroseno) {
        this.papirZaPecenjeVrednostUtroseno = papirZaPecenjeVrednostUtroseno;
    }

    public int getPapirZaPecenjeMernaJedinica() {
        return papirZaPecenjeMernaJedinica;
    }

    public void setPapirZaPecenjeMernaJedinica(int papirZaPecenjeMernaJedinica) {
        this.papirZaPecenjeMernaJedinica = papirZaPecenjeMernaJedinica;
    }

    public int getSecerVisnjaCena() {
        return secerVisnjaCena;
    }

    public void setSecerVisnjaCena(int secerVisnjaCena) {
        this.secerVisnjaCena = secerVisnjaCena;
    }

    public int getSecerKolicina() {
        return secerKolicina;
    }

    public void setSecerKolicina(int secerKolicina) {
        this.secerKolicina = secerKolicina;
    }

    public int getSecerVrednostUtroseno() {
        return secerVrednostUtroseno;
    }

    public void setSecerVrednostUtroseno(int secerVrednostUtroseno) {
        this.secerVrednostUtroseno = secerVrednostUtroseno;
    }

    public int getSecerMernaJedinica() {
        return secerMernaJedinica;
    }

    public void setSecerMernaJedinica(int secerMernaJedinica) {
        this.secerMernaJedinica = secerMernaJedinica;
    }

    public int getRedniBroj(){return redniBroj;}

    public int getCenaPolovina() {return cenaPolovina;}

    public void setCenaPolovina(int cenaPolovina) {this.cenaPolovina = cenaPolovina;}

    public int getCenaCela() {return cenaCela;}

    public void setCenaCela(int cenaCela) {this.cenaCela = cenaCela;}

    public String getDatumPocetka() {return datumPocetka;}

    public void setDatumPocetka(String datumPocetka) {this.datumPocetka = datumPocetka;}

    public String getDatumKraja() {return datumKraja;}

    public void setDatumKraja(String datumKraja) {this.datumKraja = datumKraja;}

    public int getCokoVisnjaCela() {return cokoVisnjaCela;}

    public void setCokoVisnjaCela(int cokoVisnjaCela) {this.cokoVisnjaCela = cokoVisnjaCela;}

    public int getCokoVisnjaPolovina() {return cokoVisnjaPolovina;}

    public void setCokoVisnjaPolovina(int cokoVisnjaPolovina) {this.cokoVisnjaPolovina = cokoVisnjaPolovina;}

    public int getOrasiCela() {return orasiCela;}

    public void setOrasiCela(int orasiCela) {this.orasiCela = orasiCela;}

    public int getOrasiPolovina() {return orasiPolovina;}

    public void setOrasiPolovina(int orasiPolovina) {this.orasiPolovina = orasiPolovina;}

    public int getMakCela() {return makCela;}

    public void setMakCela(int makCela) {this.makCela = makCela;}

    public int getMakPolovina() {return makPolovina;}

    public void setMakPolovina(int makPolovina) {this.makPolovina = makPolovina;}

    public int getVisnjaCela() {return visnjaCela;}

    public void setVisnjaCela(int visnjaCela) {this.visnjaCela = visnjaCela;}

    public int getVisnjaPolovina() {return visnjaPolovina;}

    public void setVisnjaPolovina(int visnjaPolovina) {this.visnjaPolovina = visnjaPolovina;}

    public int getJabukaCela() {return jabukaCela;}

    public void setJabukaCela(int jabukaCela) {this.jabukaCela = jabukaCela;}

    public int getJabukaPolovina() {return jabukaPolovina;}

    public void setJabukaPolovina(int jabukaPolovina) {this.jabukaPolovina = jabukaPolovina;}

    public int getRogacCela() {return rogacCela;}

    public void setRogacCela(int rogacCela) {this.rogacCela = rogacCela;}

    public int getRogacPolovina() {return rogacPolovina;}

    public void setRogacPolovina(int rogacPolovina) {this.rogacPolovina = rogacPolovina;}

    public String getLokacija() {return lokacija;}

    public void setLokacija(String lokacija) {this.lokacija = lokacija;}

    public String getNaziv() {return naziv;}

    public void setNaziv(String naziv) {this.naziv = naziv;}

    public int getCokoVisnjaCelaProdato() {return cokoVisnjaCelaProdato;}

    public void setCokoVisnjaCelaProdato(int cokoVisnjaCelaProdato) {this.cokoVisnjaCelaProdato = cokoVisnjaCelaProdato;}

    public int getCokoVisnjaPolovinaProdato() {return cokoVisnjaPolovinaProdato;}

    public void setCokoVisnjaPolovinaProdato(int cokoVisnjaPolovinaProdato) {this.cokoVisnjaPolovinaProdato = cokoVisnjaPolovinaProdato;}

    public int getOrasiCelaProdato() {return orasiCelaProdato;}

    public void setOrasiCelaProdato(int orasiCelaProdato) {this.orasiCelaProdato = orasiCelaProdato;}

    public int getOrasiPolovinaProdato() {return orasiPolovinaProdato;}

    public void setOrasiPolovinaProdato(int orasiPolovinaProdato) {this.orasiPolovinaProdato = orasiPolovinaProdato;}

    public int getMakCelaProdato() {return makCelaProdato;}

    public void setMakCelaProdato(int makCelaProdato) {this.makCelaProdato = makCelaProdato;}

    public int getMakPolovinaProdato() {return makPolovinaProdato;}

    public void setMakPolovinaProdato(int makPolovinaProdato) {this.makPolovinaProdato = makPolovinaProdato;}

    public int getVisnjaCelaProdato() {return visnjaCelaProdato;}

    public void setVisnjaCelaProdato(int visnjaCelaProdato) {this.visnjaCelaProdato = visnjaCelaProdato;}

    public int getVisnjaPolovinaProdato() {
        return visnjaPolovinaProdato;
    }

    public void setVisnjaPolovinaProdato(int visnjaPolovinaProdato) {
        this.visnjaPolovinaProdato = visnjaPolovinaProdato;
    }

    public int getJabukaCelaProdato() {
        return jabukaCelaProdato;
    }

    public void setJabukaCelaProdato(int jabukaCelaProdato) {
        this.jabukaCelaProdato = jabukaCelaProdato;
    }

    public int getJabukaPolovinaProdato() {
        return jabukaPolovinaProdato;
    }

    public void setJabukaPolovinaProdato(int jabukaPolovinaProdato) {
        this.jabukaPolovinaProdato = jabukaPolovinaProdato;
    }

    public int getRogacCelaProdato() {
        return rogacCelaProdato;
    }

    public void setRogacCelaProdato(int rogacCelaProdato) {
        this.rogacCelaProdato = rogacCelaProdato;
    }

    public int getRogacPolovinaProdato() {
        return rogacPolovinaProdato;
    }

    public void setRogacPolovinaProdato(int rogacPolovinaProdato) {
        this.rogacPolovinaProdato = rogacPolovinaProdato;
    }

    public int getPrihod() {
        return prihod;
    }

    public void setPrihod(int prihod) {
        this.prihod = prihod;
    }

    public int getRashod() {
        return rashod;
    }

    public void setRashod(int rashod) {
        this.rashod = rashod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getCenaStanda() {
        return cenaStanda;
    }

    public void setCenaStanda(int cenaStanda) {
        this.cenaStanda = cenaStanda;
    }

    public int getDnevnica() {
        return dnevnica;
    }

    public void setDnevnica(int dnevnica) {
        this.dnevnica = dnevnica;
    }

    public int getHranaPice() {
        return hranaPice;
    }

    public void setHranaPice(int hranaPice) {
        this.hranaPice = hranaPice;
    }


    public int getPutarina() {
        return putarina;
    }

    public void setPutarina(int putarina) {
        this.putarina = putarina;
    }


}
