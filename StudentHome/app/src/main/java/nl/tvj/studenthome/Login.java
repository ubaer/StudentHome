package nl.tvj.studenthome;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Database db;
    private boolean connected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Database();
        connected = false;

        new showConnectionResult().execute((Void[])null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    private class showConnectionResult extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            connected = db.connect();
            return null;
        }

        @Override
        protected void onPostExecute(Void param) {
            if (connected) {
                Toast.makeText(Login.this, "Database connectie geslaagd", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(Login.this, "Database connectie gefaald", Toast.LENGTH_SHORT).show();
        }
    }
}
