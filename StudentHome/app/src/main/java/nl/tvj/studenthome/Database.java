package nl.tvj.studenthome;

import android.os.StrictMode;

import java.lang.reflect.Array;
import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kevin on 22-10-2015.
 */
public class Database {
    private static Connection conn = null;


    public static void main(String[] args) {
        System.out.println(" meh ");
    }

    public static boolean connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net/sql495412", "sql495412", "lA9%vS5!");
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }

    //insert methode
    public void insertScore(String name, int score) throws SQLException {
        conn.createStatement().execute("INSERT INTO HIGHSCORE(Name, Score) VALUES('" + name + "', " + score + ")");
    }


    public ArrayList<Gebruiker> getGebruikersInHuis(int HuisID) throws SQLException {
        ArrayList<Gebruiker> gebruikers = new ArrayList<>();
        try {
            connect();
            ResultSet rs = conn.prepareStatement("SELECT g.* FROM Gebruiker g, StudentenHuis sh WHERE sh.`ID` = 1 AND g.`StudentenhuisID` = sh.`ID`").executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String gebruikersnaam = rs.getString(2);
                String wachtwoord = rs.getString(3);
                String naam = rs.getString(4);
                Gebruiker gebruiker = new Gebruiker(id, gebruikersnaam, wachtwoord, naam);
                gebruikers.add(gebruiker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return gebruikers;
    }

    public boolean addDeelnemer(Gebruiker gebruiker, Activiteit activiteit) throws SQLException {
        boolean gelukt = false;
        try {
            connect();
            conn.createStatement().execute("INSERT INTO ActiviteitGebruiker VALUES("+ activiteit.getId() +","+ gebruiker.getId() +",NULL,NULL)");
            gelukt = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return gelukt;
    }
    public boolean addBeoordeling(Activiteit activiteit, Beoordeling beoordeling) throws SQLException {
        boolean gelukt = false;
        try {
            connect();
            conn.createStatement().execute("UPDATE  ActiviteitGebruiker SET beoordeling = "+beoordeling.getBeoordeling() +" WHERE activiteitID ="+ activiteit.getId()+ "AND gebruikerID ="+ beoordeling.beoordeeldDoor.getId() );
            gelukt = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return gelukt;
    }
    public boolean addHuisbewoner(Studentenhuis studentenhuis, Gebruiker gebruiker) throws SQLException {
        boolean gelukt = false;
        try {
            connect();
            conn.createStatement().execute("UPDATE Gebruiker SET StudentenhuisID = " + studentenhuis.getId() + " WHERE ID = " + gebruiker.getId());
            gelukt = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return gelukt;
    }
    public boolean addActiviteit(Studentenhuis studentenhuis, Activiteit activiteit) throws SQLException {
        boolean gelukt = false;
        try {
            connect();
            conn.createStatement().execute("INSERT INTO Activiteit(totdaalbedrag, omschrijving, GebruikerID, starttijd)VALUES(" + activiteit.totaalbedrag + "," + activiteit.omschrijving + "," + activiteit.host.getId() + "," + activiteit.starttijd + ");");
            int maxID = getMaxActiviteitID();
            conn.createStatement().execute("INSERT INTO Activiteit_Studentenhuis VALUES ("+studentenhuis.getId()+","+maxID+") "); // toevoegen aan Studenthuis Activiteit
            gelukt = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return gelukt;
    }
    public int getMaxActiviteitID() throws SQLException {
        int maxID = 0;
        try {
            connect();
            ResultSet rs = conn.prepareStatement("SELECT MAX(id) FROM activiteit ").executeQuery();
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return maxID;
    }
    public boolean addGebruikerActiviteit(Gebruiker gebruiker, Activiteit activiteit) throws SQLException {
        boolean gelukt = false;
        try {
            connect();
            conn.createStatement().execute("INSERT INTO Activiteit_Gebruiker VALUES("+activiteit.getId()+","+gebruiker.getId()+")");
            gelukt = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return gelukt;
    }
    public boolean addBeoordelingActiviteit(Activiteit activiteit, Beoordeling beoordeling) throws SQLException {
        boolean gelukt = false;
        try {
            connect();
            conn.createStatement().execute("INSERT INTO Beoordeling VALUES ("+activiteit.getId()+","+beoordeling.beoordeeldDoor.getId()+","+beoordeling.beoordeling+")");
           gelukt = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return gelukt;
    }

    public boolean addVotingOption(Activiteit activiteit, String option) throws SQLException {
        boolean gelukt = false;
        try {
            connect();
            conn.createStatement().execute("insert into `avondetenOptions` (`avondetenID`, `option`) values("+activiteit.getId()+","+option+")");
            gelukt = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return gelukt;
    }
    public Gebruiker getGebruikerVanGebruikersnaam(String gebruikersnaam) throws SQLException {
        Gebruiker returnGebruiker = null;
        try {
            connect();
            ResultSet rs = conn.prepareStatement("SELECT g.* FROM Gebruiker g, StudentenHuis sh WHERE sh.`ID` = 1 AND g.`StudentenhuisID` = sh.`ID` AND g.gebruikersnaam = "+gebruikersnaam).executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String gnaam = rs.getString(2);
                String wachtwoord = rs.getString(3);
                String naam = rs.getString(4);
                returnGebruiker = new Gebruiker(id, gnaam, wachtwoord, naam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return returnGebruiker;
    }
    public boolean setGebruikerLocatie(int gebruikersID, double longtitude, double latitude) throws SQLException {
        boolean gelukt = false;
        try {
            connect();
            conn.createStatement().execute("insert into `LocatieGebruiker` (`gebruikerID`, `long`, `lat`, `datetime`) values("+gebruikersID+","+longtitude+","+latitude+",'"+ new Date()+"')");
            gelukt = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return gelukt;
    }
}
