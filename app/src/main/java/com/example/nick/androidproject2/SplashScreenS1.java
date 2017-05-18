package com.example.nick.androidproject2;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

/**
 * SplashScreenS1 is the activity portion of the splash screen. This screen is just a delay at
 * the start of the program to give the program time to boot up other code in the back ground.
 * @version 10/24/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class SplashScreenS1 extends Activity {

    //Constant to keep this window up for a certain amount of time before disappearing
    private final int DELAY = 2000;

    /**
     * Life cycle method that is needed in order to set the XML to this activity.
     * @param savedInstanceState of before
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_s1);
    }

    /**
     * Calls the onStart super method, and then creates a handler to run the delay.
     */
    protected void onStart(){
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(runner,DELAY);
    }

    /**
     * Creates a Runnable private class and runs for a set amount of time before calling the
     * next screen.
     */
    private final Runnable runner  = new Runnable(){
        @Override
        public void run(){
            nextScreen();
        }
    };

    /**
     * Creates a intent and starts the next screen which is the main menu.
     */
    private void nextScreen(){
        Intent i = new Intent(this, MenuS2.class);
        this.startActivity(i);
        this.finish();
    }
}
