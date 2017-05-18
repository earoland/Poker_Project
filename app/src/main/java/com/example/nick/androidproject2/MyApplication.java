package com.example.nick.androidproject2;

import android.app.Application;
import android.content.res.Configuration;

/**
 * MyApplication is the application class for the project. All the activities are within the
 * this class as a whole. This class is used to hold global names such as the username.  Holding
 * global variables such as username makes sure that the variable is communicated to other
 * activities and fragments correctly.
 * @version 10/24/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class MyApplication extends Application {

    /** The String that holds the user variable*/
    private String userName;
    /** Holds the user winnings for the game and helps perserve them between screens */
    public double winnings;
    /** Holds te number of hands the user has and perserves that data between screens */
    public int handsPlayed;

    /** Holds the singleton instance of the MyApplication class. */
    public static MyApplication me;

    /**
     * Getter method for the singleton instance for the MyApplication class.
     * @return me which is the singleton instance.
     */
    public static MyApplication getInstance(){
        return me;
    }

    /**
     * Life cycle method for the MyApplication. Just calls the super method.
     * @param config for the application
     */
    @Override
    public void onConfigurationChanged(Configuration config){
        super.onConfigurationChanged(config);
    }

    /**
     * Life Cycle method. Calls the onCreate super method, and makes the programs variables
     * to default settings for first run.
     */
    @Override
    public void onCreate(){
        super.onCreate();
        me = this;
        userName = "player";
        winnings = 0.0;
        handsPlayed = 0;
    }

    /**
     * Setter method for userName
     * @param name is the name to be changed to
     */
    public void setUserName(String name){
        userName = name;
        winnings = 0.0;
        handsPlayed = 0;

    }

    /**
     * Getter method for userName
     * @return userName is the name of the user
     */
    public String getUserName(){
        return userName;
    }

    /**
     * Forces the FragmentPoker hand to update it's stats to be the stats of the MyApplication's
     * class.
     */
    public void updateStats(){
        FragmentPoker hand = FragmentPoker.getInstance();

        hand.updateFragStats(handsPlayed, winnings);
    }


}
