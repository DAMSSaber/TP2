package com.myschool.tp2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FormActivity extends ActionBarActivity {

    SharedPreferences sharedpreferences =null;
    private final static String CURRENT_LOGIN = "CURRENT_LOGIN";
    SharedPreferences.Editor editor=null;
    private EditText ui_edit_nom = null;
    private EditText ui_edit_mail = null;
    private EditText ui_edit_mdp = null;
    private Button ui_btn_valide = null;


    private String mName = "";
    private String mMail = "";
    private String mMdp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        ui_edit_nom = (EditText) findViewById(R.id.ui_edit_nom);
        ui_edit_mail = (EditText) findViewById(R.id.ui_edit_mail);
        ui_edit_mdp = (EditText) findViewById(R.id.ui_edit_mdp);
        ui_btn_valide = (Button) findViewById(R.id.ui_btn_valide);


        ui_edit_nom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mName = s.toString();
            }
        });
        ui_edit_mail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mMail = s.toString();
            }
        });
        ui_edit_mdp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mMdp = s.toString();
            }
        });


        ui_btn_valide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mMdp.equals("")) {

                    Toast.makeText(getApplicationContext(), "Votre mot de passe est null",
                            Toast.LENGTH_LONG).show();
                } else if (mName.equals("")) {

                    Toast.makeText(getApplicationContext(), "Votre Idantifiant est null",
                            Toast.LENGTH_LONG).show();
                } else if (mMail.equals("")) {
                    Toast.makeText(getApplicationContext(), "Votre email est null",
                            Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(getApplicationContext(), "Ok",
                            Toast.LENGTH_LONG).show();
                    sharedpreferences = getSharedPreferences(CURRENT_LOGIN, Context.MODE_PRIVATE);
                    editor= sharedpreferences.edit();
                    editor.putString("mdp", mMdp);
                    editor.putString("name", mName);
                    editor.putString("mail", mMail);
                    editor.commit();
                }




                }
            }

            );


        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_form, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
