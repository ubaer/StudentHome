package nl.tvj.studenthome;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kevin on 15-10-2015.
 */
public class Avondeten extends Activiteit {

    double totaalbedrag;
    String omschrijving;
    Gebruiker host;
    ArrayList<Gebruiker> deelnemers;
    ArrayList<Beoordeling>beoordelingen;
    Date startijd;
    ArrayList<String>votingOptions;

    Avondeten(double totaalbedrag, String omschrijving, Gebruiker host, Date startijd) {
        super(totaalbedrag, omschrijving, host, startijd);
        votingOptions = new ArrayList<>();
    }
    @Override
    public boolean getIedereenGestemd() {
        return false;
    }

    @Override
    public void setIedereenGestemd(boolean iedereenGestemd) {

    }

    @Override
    public void addDeelnemer(Gebruiker deelnemer) {

    }

    @Override
    public void setTotaalbedrag(double totaalbedrag) {

    }

    @Override
    public Beoordeling addBeoordeling(Beoordeling beoordeling) {
        return null;
    }

    @Override
    public boolean addVotingOption(String option) {
        return false;
    }

    @Override
    public ArrayList<Gebruiker> getDeelnemers() {
        return null;
    }
}
