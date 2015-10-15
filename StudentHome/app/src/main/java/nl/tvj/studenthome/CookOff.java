package nl.tvj.studenthome;

import java.util.Date;

/**
 * Created by Kevin on 15-10-2015.
 */
public class CookOff extends Avondeten {
    public boolean titelVerdediger;
    CookOff tegenstander;
    CookOff(double totaalbedrag, String omschrijving, Gebruiker host, Date startijd, boolean titelVerdediger, CookOff tegenstander) {
        super(totaalbedrag, omschrijving, host, startijd);
        this.titelVerdediger = titelVerdediger;
        this.tegenstander = tegenstander;
    }
}
