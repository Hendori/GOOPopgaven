/*
 * Dit is een subclass van persoon om  een leerling van te kunnen maken
 * */

public class Leerling extends Persoon{
    protected int nummer;
    protected String klas;
    Leerling(String naam, int nummer){
    	super(naam);
	this.nummer = nummer;
    }
    
    public String getKlas(){
    	return klas;
    }

    public int getNummer(){
    	return nummer;
    }    
	
    public void setKlas(String klas){
    	this.klas = klas;
    }

    public String toString(){
      	return String.format("De leerling heet %s, woont in %s en zit in klas %s", naam, adres, klas);
    }
}
