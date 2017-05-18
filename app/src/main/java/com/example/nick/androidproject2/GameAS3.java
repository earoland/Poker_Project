package com.example.nick.androidproject2;

import android.app.Activity;
import android.os.Bundle;

/**
 * The main screen for the playing the game portion. This screen is used for smaller screens.
 * Only difference between this screen and the larger one is that it doesn't display the list view.
 * It just has a button that goes to the list view.
 * @version 10/24/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class GameAS3 extends Activity {

    /** Holds the singleton instance of GameAS3 */
    private static GameAS3 me;

    /**
     * Calls the super method for onCreate and then sets the XML for the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        me = this;
        setContentView(R.layout.activity_game_as3);

    }

    /**
     * Getter method for the singleton instance of GameAS3
     * @return me instance of GameAS3
     */
    public static GameAS3 getInstance(){
        return me;
            }

    /**
     * Life Cycle method reference
     */
    @Override
    protected void onStart() {
        super.onStart();
    }
}
