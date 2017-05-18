package com.example.nick.androidproject2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * MenuS2 is the activity that is the main menu of the program.  It controls going to PlayerNameS7,
 * to the game screen, and view the list view.  It also tells if a large or small play screen should
 * be used.
 * @version 10/24/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class MenuS2 extends Activity implements View.OnClickListener{

    /** Button to go to PlayerNameS7*/
    private Button playerName;
    /** Button that goes to the game screen*/
    private Button play;
    /** Button that takes the user to the WinListS5 screen*/
    private Button viewHand;

    /**
     * Life Cycle method that calls the super method onCreate. It also sets the XML to the screen.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_s2);
    }

    /**
     * Life Cycle method that calls once the activity starts. It calls the onStart super method,
     * and then sets the XML and on click listeners the button.  It also determines the name of
     * the button Player Name.
     */
    @Override
    protected void onStart(){
        super.onStart();

        playerName = (Button) findViewById(R.id.playerName);
        playerName.setOnClickListener(this);

        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(this);

        viewHand = (Button) findViewById(R.id.viewHand);
        viewHand.setOnClickListener(this);

        MyApplication app = (MyApplication) getApplication();
        if(!app.getUserName().equals("")){
            playerName.setText(app.getUserName());
        }

    }

    /**
     * Event handler for the buttons in the main menu.
     * @param v is the event fired off from a click.
     */
    @Override
    public void onClick(View v) {
        Intent i = null;

        switch(v.getId()){

            case R.id.playerName:
                i = new Intent(this, PlayerNameS7.class);
                break;
            case R.id.play:

                int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
                if(screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                    i = new Intent(this, GameBS3.class);
                }else{
                    i = new Intent(this, GameAS3.class);
                }

                break;
            case R.id.viewHand:
                i = new Intent(this, WinListS5.class);
                break;
        }
        if(i != null) {
            this.startActivity(i);
        }
    }
}
