package androidpro.com.br.appaula11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String SETTINGS = "br.com.androidpro.appaula11.settings";
    public static final String FIRST_USE = "br.com.androidpro.appaula11.firstUse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        boolean firstUse = preferences.getBoolean(FIRST_USE, true);
        if (firstUse){
            Toast message = Toast.makeText(getApplicationContext(), "Olá, é sua primeira vez aqui", Toast.LENGTH_LONG);
            message.show();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(FIRST_USE, false);
            editor.commit();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.title_activity_settings2:
                intent = new Intent(this, Settings2Activity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
