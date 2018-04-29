/*
 * Dit is een subclass van persoon om een docent van te kunnen maken
 * */

public class Docent extends Persoon{
    protected String vak;
    protected int aantalUren; 
    
    Docent(String naam){
       	super(naam);
    }

    Docent(String naam, String vak, int aantalUren){
	super(naam);
	this.vak = vak;
	this.aantalUren = aantalUren;
    }

    public String getVak(){
        return vak;
    }

    public int getAantalUren(){
    	return aantalUren;
    }

    public void setAantalUren(int aantalUren){
    	this.aantalUren = aantalUren;
    }

    public void setVak(String vak){
	this.vak = vak;
    }

    public String toString(){
    	return String.format("De docent heet %s, geeft %s voor %d uren en hij komt uit %s", naam, vak, aantalUren, adres);
    }
}

