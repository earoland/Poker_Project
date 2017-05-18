package com.example.nick.androidproject2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The WinS6 screen displays the information of a winning hand in game.  It has a title
 * description, and pictures of the card for that winning hand.
 * @version 10/25/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class WinS6 extends Activity {

    /** holds the TextView reference for the title */
    private TextView title;
    /** Holds the TextView reference for the description*/
    private TextView description;
    /** Holds an array of strings for the cards */
    private String[] cards = new String[5];
    /** Holds a reference to the Bundle passed in the intent */
    private Bundle extras;

    /** Holds reference to the first card */
    ImageView card1;
    /** Holds reference for the second card */
    ImageView card2;
    /** Holds reference for the third card */
    ImageView card3;
    /** Holds reference for the fourth card */
    ImageView card4;
    /** Holds reference for the 5th card */
    ImageView card5;

    /**
     * Life cycle method for the WinS6 activity and sets the WinS6 activity's XML display.
     * @param savedInstanceState the state that this activity was in before it was being created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_s6);

    }

    /**
     * Sets all the references to the XML textviews and imageviews.  Also, sets the
     * cards array to the list of cards to display.
     */
    @Override
    protected void onStart(){
        super.onStart();

        extras = getIntent().getExtras();

        title = (TextView) findViewById(R.id.textView);
        title.setText(extras.getString("cards"));
        description = (TextView) findViewById(R.id.textView3);
        description.setText(extras.getString("desc"));

        cards[0] = extras.getString("card0");
        cards[1] = extras.getString("card1");
        cards[2] = extras.getString("card2");
        cards[3] = extras.getString("card3");
        cards[4] = extras.getString("card4");

        card1 = (ImageView) findViewById(R.id.img1);
        card2 = (ImageView) findViewById(R.id.img2);
        card3 = (ImageView) findViewById(R.id.img3);
        card4 = (ImageView) findViewById(R.id.img4);
        card5 = (ImageView) findViewById(R.id.img5);

        int imgID1 = getResources()
                .getIdentifier(cards[0], "drawable", getApplicationContext().getPackageName());
        int imgID2 = getResources()
                .getIdentifier(cards[1], "drawable", getApplicationContext().getPackageName());
        int imgID3 = getResources()
                .getIdentifier(cards[2], "drawable", getApplicationContext().getPackageName());
        int imgID4 = getResources()
                .getIdentifier(cards[3], "drawable", getApplicationContext().getPackageName());
        int imgID5 = getResources()
                .getIdentifier(cards[4], "drawable", getApplicationContext().getPackageName());

        card1.setImageDrawable(null);
        card2.setImageDrawable(null);
        card3.setImageDrawable(null);
        card4.setImageDrawable(null);
        card5.setImageDrawable(null);

        card1.setImageResource(imgID1);
        card2.setImageResource(imgID2);
        card3.setImageResource(imgID3);
        card4.setImageResource(imgID4);
        card5.setImageResource(imgID5);
    }//end of onStart
}//end of class
