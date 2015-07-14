package com.myschool.tp2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ConnexionActivity extends ActionBarActivity {


    private Button ui_btn_clear=null;
    private final static String CURRENT_LOGIN = "CURRENT_LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


        ui_btn_clear=(Button)findViewById(R.id.ui_btn_clear);
        ui_btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leaveTheApp();

            }
        });
    }
    private void leaveTheApp() {
        getSharedPreferences(CURRENT_LOGIN, 0).edit().clear().commit();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_connexion, menu);
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
}
