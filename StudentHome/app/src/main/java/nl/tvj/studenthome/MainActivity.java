package nl.tvj.studenthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Database dbm = new Database();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   boolean testbool =  DatabaseTest();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        mythread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean  DatabaseTest() throws SQLException {
        Gebruiker test = new Gebruiker(1, "geb","pass","naam");
        Activiteit activiteit = new Avondeten(1,1,"ok",test, new Date());
        return dbm.addDeelnemer(test, activiteit);
    }
}
