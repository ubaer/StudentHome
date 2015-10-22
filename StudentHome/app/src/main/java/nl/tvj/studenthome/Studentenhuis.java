package nl.tvj.studenthome;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kevin on 15-10-2015.
 */
public class Studentenhuis {
    ArrayList<Gebruiker>huisBewoners;
    Gebruiker huisBaas;
    ArrayList<IKlassering>klasseringen;
    ArrayList<Activiteit>activiteiten;
    String adres;
    String verstigingsplaats;
    String postcode;
    String naam;
    double longitude;
    double latitude;

    public Studentenhuis(String adres, String verstigingsplaats, String postcode, String naam, Gebruiker huisBaas) {
        this.huisBaas = huisBaas;
        this.adres = adres;
        this.verstigingsplaats = verstigingsplaats;
        this.postcode = postcode;
        this.naam = naam;
        this.huisBewoners = new ArrayList<>();
        this.klasseringen = new ArrayList<>();
        this.activiteiten = new ArrayList<>();
    }
    public String getNaam(){
        return naam;
    }

    public void setNaam(String naam){
        this.naam = naam;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public boolean addBewoner(Gebruiker bewoner){
        //  Kijkt of de bewoner nog niet in de lijst staat
        boolean excists = false;

        for (Gebruiker g : huisBewoners) {
            if (g == bewoner) {
                excists = true;
            }
        }

        if(!excists) {
            huisBewoners.add(bewoner);
            return true;
        }
        else {
            return false;
        }
    }

    //TODO invullen
    public boolean addActiviteit(Gebruiker host, String omschrijving,Date starttijd){
        return false;
    }

    //TODO invullen
    public boolean overlappenActiviteiten(Date starttijd){
        return false;
    }

    //kijkt of de gebruiker niet al in de activiteit zit en voegd hem vervolgens toe
    public boolean joinActiviteit(Gebruiker deelnemer, Activiteit activiteit){
        for(Activiteit a : activiteiten){
            if(a == activiteit){
                ArrayList<Gebruiker>deelnemers = a.getDeelnemers();
                boolean excists = false;
                for(Gebruiker gebruiker : deelnemers)
                {
                    if(deelnemer == gebruiker)
                        excists = true;
                }
                if(!excists) {
                    return activiteit.addDeelnemer(deelnemer);
                }
            }
        }
        return false;
    }

    //TODO invullen
    public boolean addBeoordeling(Activiteit activiteit, double Beoordeling, Gebruiker beoordeeldDoor){
        //  Kijkt of de Gebruiker de activiteit al beoordeeld heeft
        boolean alBeoordeeld = false;
        for (Beoordeling b : activiteit.beoordelingen) {
            if (b.beoordeeldDoor.equals(beoordeeldDoor)) {
                alBeoordeeld = true;
            }
        }

        if (!alBeoordeeld) {
            boolean returnValue = activiteit.addBeoordeling(new Beoordeling(beoordeeldDoor, Beoordeling));

            if (activiteit.getIedereenGestemd()) {
                
            }

            return returnValue;
        }
        return false;
    }

    //TODO invullen
    public boolean createCookOff(Gebruiker verdediger, Gebruiker uitdager, Activiteit activiteitVerdediger, Activiteit activiteitUitdager){
        return false;
    }
}
