package nl.tvj.studenthome;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kevin on 15-10-2015.
 */
public abstract class Activiteit {
    int id;
    double totaalbedrag;
    String omschrijving;
    Gebruiker host;
    ArrayList<Gebruiker> deelnemers;
    ArrayList<Beoordeling> beoordelingen;
    Date startijd;
    Database db;
    boolean iedereenGestemd;

    Activiteit(int id, double totaalbedrag, String omschrijving, Gebruiker host, Date startijd) {
        this.id = id;
        this.totaalbedrag = totaalbedrag;
        this.omschrijving = omschrijving;
        this.host = host;
        this.startijd = startijd;
        deelnemers = new ArrayList<>();
        beoordelingen = new ArrayList<>();
        db = new Database();
    }

    public int getId() {
        return this.id;
    }

    public boolean getIedereenGestemd() {
        return this.iedereenGestemd;
    }

    public void setIedereenGestemd(boolean iedereenGestemd) {
        this.iedereenGestemd = iedereenGestemd;
    }

    abstract public boolean addDeelnemer(Gebruiker deelnemer);
    abstract public void setTotaalbedrag(double totaalbedrag);

    public boolean addBeoordeling(Beoordeling beoordeling) {
        beoordelingen.add(beoordeling);

        //TODO Database methode implementeren
        //  db.addBeoordeling(this, beoordeling);

        return false;
    }

    abstract public boolean addVotingOption(String option);
    abstract public ArrayList<Gebruiker> getDeelnemers();
}
