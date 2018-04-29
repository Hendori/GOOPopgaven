/*
 * Dit is een superclass van persoon om vervolgens een leerling en een docent van te kunnen maken
 * */

public class Persoon{
    protected String naam;
    protected String adres;
    
    Persoon(String naam){
        this.naam = naam;
        adres = "Onbekend";
    }

    public String getNaam(){
        return this.naam;
    }

    public String getAdres(){
        return this.adres;
    }

    public void setAdres(String adres){
        this.adres = adres;
    }

    public String toString(){
        return "De persoon heet " + naam + " en zijn adres is " + adres;
    }    
}
