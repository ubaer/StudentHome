package nl.tvj.studenthome;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Kevin on 22-10-2015.
 */
public class Database {
    private static Connection conn = null;


    public static void main(String[] args) {
        System.out.println(" meh ");
    }

    public static boolean connect(){

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch(Exception e){
            System.err.println("Cannot create connection");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/studenthouse", "studenthouse", "test01");
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }

    //insert methode
    public  void insertScore(String name, int score) throws SQLException{
        conn.createStatement().execute("INSERT INTO HIGHSCORE(Name, Score) VALUES('" + name + "', " + score + ")");
    }

    //Get list methode
    public  ArrayList<String> getScores() throws SQLException{
        ArrayList<String> highscores= new ArrayList<>();
        ResultSet rs = conn.prepareStatement("SELECT * FROM HIGHSCORE").executeQuery();

        while (rs.next()) {
            System.out.print(rs.getString(1));
            System.out.print(": ");
            System.out.println(rs.getInt(2));
            highscores.add(rs.getString(1));
        }

        return highscores;
    }
}
