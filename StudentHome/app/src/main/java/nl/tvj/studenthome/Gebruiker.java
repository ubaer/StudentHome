package nl.tvj.studenthome;

/**
 * Created by Kevin on 15-10-2015.
 */
public class Gebruiker {
    String gebruikersnaam;
    String wachtwoord;
    String naam;

    public Gebruiker(String gebruikersnaam, String wachtwoord, String naam) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.naam = naam;
    }
    public String getNaam(){
        return naam;
    }
}
