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
    ArrayList<Beoordeling>beoordelingen;
    Date startijd;

    Activiteit(double totaalbedrag, String omschrijving, Gebruiker host, Date startijd) {
        this.totaalbedrag = totaalbedrag;
        this.omschrijving = omschrijving;
        this.host = host;
        this.startijd = startijd;
        deelnemers = new ArrayList<>();
        beoordelingen = new ArrayList<>();
    }
    abstract public boolean getIedereenGestemd();
    abstract public void setIedereenGestemd(boolean iedereenGestemd);
    abstract public void addDeelnemer(Gebruiker deelnemer);
    abstract public void setTotaalbedrag(double totaalbedrag);
    abstract public Beoordeling addBeoordeling(Beoordeling beoordeling);
    abstract public boolean addVotingOption(String option);
    abstract public ArrayList<Gebruiker> getDeelnemers();
}
