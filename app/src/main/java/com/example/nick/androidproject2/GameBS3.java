package com.example.nick.androidproject2;

import android.app.Activity;
import android.os.Bundle;

/**
 * Code for the large play screen of the app.  The XML is all done in fragments for this screen,
 * and all the code that is in use is in those fragment so very little code here.
 * @version 10/24/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class GameBS3 extends Activity {

    /** Singleton instance of the GameBS3 screen */
    private static GameBS3 me;

    /**
     * Life cycle method for the Activity class. This method calls the super method, and then
     * sets the XML for the screen to this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        me = this;
        setContentView(R.layout.activity_game_bs3);

    }

    /**
     * Getter method for the singleton reference of GameBS3
     * @return me the singleton instance of this activity
     */
    public static GameBS3 getInstance(){
        return me;
    }

}
