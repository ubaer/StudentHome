package nl.tvj.studenthome;

import java.util.Date;

/**
 * Created by Kevin on 15-10-2015.
 */
public class CookOff extends Avondeten {
    public boolean titelVerdediger;
    CookOff tegenstander;
    CookOff(int id, double totaalbedrag, String omschrijving, Gebruiker host, Date startijd, boolean titelVerdediger, CookOff tegenstander) {
        super(id, totaalbedrag, omschrijving, host, startijd);
        this.titelVerdediger = titelVerdediger;
        this.tegenstander = tegenstander;
    }

    @Override
    public boolean addBeoordeling(Beoordeling beoordeling) {
        beoordelingen.add(beoordeling);

        if (beoordelingen.size() == deelnemers.size()) {
            setIedereenGestemd(true);
        }

        //TODO Database methode implementeren
        //  db.addBeoordeling(this, beoordeling);

        return false;
    }
}
