package com.example.nick.androidproject2;

import android.app.Activity;
import android.os.Bundle;

/**
 * Displays a screen that has a list of clickable winning hands.  These hands are clickable through
 * a viewlist that implemented in the FragmentWinList.  Each item should go to a screen that
 * provides more information about it.
 * @version 10/25/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class WinListS5 extends Activity {

    /**
     * Life cycle method for the WinListS5 which also sets the XML layout for the activity too.
     * @param savedInstanceState which is the saved state before this activity was created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_list_s5);
    }
}
