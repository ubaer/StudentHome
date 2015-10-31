package nl.tvj.studenthome;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kevin on 15-10-2015.
 */
public class Avondeten extends Activiteit {
    ArrayList<String>votingOptions;

    Avondeten(int id, double totaalbedrag, String omschrijving, Gebruiker host, Date startijd) {
        super(id, totaalbedrag, omschrijving, host, startijd);
        votingOptions = new ArrayList<>();
    }
}
