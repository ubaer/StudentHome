package nl.tvj.studenthome;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Kevin on 15-10-2015.
 */
public class Gebruiker {
    int id;
    String gebruikersnaam;
    String wachtwoord;
    String naam;
    double lastLong;
    double lastLat;

    public Gebruiker(int id, String gebruikersnaam, String wachtwoord, String naam) {
        this.id = id;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.naam = naam;
        this.lastLong = 0;
        this.lastLat = 0;
    }
    public int getId() { return id; }
    public String getNaam(){
        return naam;
    }
}
