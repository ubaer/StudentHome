package nl.tvj.studenthome;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kevin on 15-10-2015.
 */
public abstract class Activiteit {
    double totaalbedrag;
    String omschrijving;
    Gebruiker host;
    ArrayList<Gebruiker> deelnemers;
    ArrayList<Beoordeling> beoordelingen;
    Date startijd;
    Database db;
    boolean iedereenGestemd;

    Activiteit(double totaalbedrag, String omschrijving, Gebruiker host, Date startijd) {
        this.totaalbedrag = totaalbedrag;
        this.omschrijving = omschrijving;
        this.host = host;
        this.startijd = startijd;
        deelnemers = new ArrayList<>();
        beoordelingen = new ArrayList<>();
        db = new Database();
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

        if (beoordelingen.size() == deelnemers.size()) {
            setIedereenGestemd(true);
        }

        return false;
    }

    abstract public boolean addVotingOption(String option);
    abstract public ArrayList<Gebruiker> getDeelnemers();
}
