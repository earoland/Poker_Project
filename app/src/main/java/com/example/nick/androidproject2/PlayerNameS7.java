package com.example.nick.androidproject2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * PlayerNameS7 is the activity that allows the user to input a username. If the username contains
 * illegal characters such as numbers or non a to z letters then an alert box appears. Space
 * isn't counted as an illegal character.
 * @version 10/24/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class PlayerNameS7 extends Activity implements View.OnClickListener {

    /** The button reference that takes us back to the main menu*/
    private Button ok;

    /** EditText reference for the user input*/
    private EditText name;

    /** Reference to the myApplication*/
    MyApplication app;

    /**
     * Life Cycle method for the PlayerNameS7 which also sets the XML layout to the activity.
     * @param savedInstanceState of the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name_s7);
    }

    /**
     * Life cycle method that calls the super, sets up the Appliciation reference,
     * sets the ok button to the XML and click listen, and the edit text to the XML.
     */
    @Override
    protected void onStart(){
        super.onStart();

        app = (MyApplication) getApplication();

        ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(this);
        name = (EditText) findViewById(R.id.name);
    }

    /**
     * Event handler for the ok button.
     * @param v is a event
     */
    @Override
    public void onClick(View v) {
        Intent i = null;

        switch(v.getId()){

            case R.id.ok:

                String s = name.getText().toString();

                if(s.matches("[a-zA-Z ]+")) {
                    i = new Intent(this, MenuS2.class);

                    app.setUserName(s);
                    //i.putExtra("name", s);
                }else{
                    alertBox(s);
                }
                break;

        }
        if(i != null) {
            this.startActivity(i);
        }
    }

    /**
     * alertBox method creates an alert box with an error message
     * @param error message to be displayed in the alert box
     */
    public void alertBox(String error){

        new AlertDialog.Builder(this)
                .setTitle("Invalid name")
                .setMessage(error + " is not a name." + "\n" + "Use only characters found in" +
                        " A to Z alphabetical letters.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }//end of alertBox
}//end of class
