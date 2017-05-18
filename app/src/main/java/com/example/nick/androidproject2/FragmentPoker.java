package com.example.nick.androidproject2;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Fragment that contains the name, the buttons to throw or keep and uses a few other fragments
 * in the XML. The use of this fragment is so that there can be two different Game screens for
 * bigger or smaller screens.
 *
 * @version 10/24/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class FragmentPoker extends Fragment implements View.OnClickListener {

    /** Holds reference for the first card*/
    protected static Button card1;
    /** Holds the reference to the second card*/
    protected static Button card2;
    /** Holds the reference to the third card*/
    protected static Button card3;
    /** Holds the reference to the fourth card */
    protected static Button card4;
    /** Holds the reference to the 5th card */
    protected static Button card5;

    /** Holds the reference to the first card*/
    ImageView card1img;
    /** Holds the reference to the second card */
    ImageView card2img;
    /** Holds the reference to the third card */
    ImageView card3img;
    /** Holds the reference to the fourth card */
    ImageView card4img;
    /** Holds the reference to the 5th card */
    ImageView card5img;

    /** holds an reference to an activity */
    Activity a;

    /** Reference to the win button*/
    private Button wins;
    /**holds a reference to a game object which runs most of the game */
    private Game poker;
    /* holds a reference to card 1 in the player's hand */
    private Card hcard1;
    /*holds a reference to card 2 in the player's hand */
    private Card hcard2;
    /*holds a reference to card 3 in the player's hand */
    private Card hcard3;
    /*holds a reference to card 4 in the player's hand */
    private Card hcard4;
    /*holds a reference to card 5 in the player's hand */
    private Card hcard5;

    /** Holds reference for the first card to tell if it needs replaced */
    private boolean replace1;
    /** Holds reference for the second card to tell if it needs replaced */
    private boolean replace2;
    /** Holds reference for the third card to tell if it needs replaced */
    private boolean replace3;
    /** Holds reference for the fourth card to tell if it needs replaced */
    private boolean replace4;
    /** Holds reference for the 5th card to tell if it needs replaced */
    private boolean replace5;

    /** Holds reference that tells if you won the game */
    private boolean won;


    /** Changes the screen to the main menu */
    private Button menu;

    /** Deals a new hand to the user */
    private Button deal;

    /** Holds the view of the screen */
    private boolean pressedBefore = false;



    /** Holds the reference to the name of the user*/
    private TextView name;
    /** Holds the textview reference for the bank */
    private TextView bank;
    /** Holds the textview reference for the handsPlayed status */
    private TextView handsPlayed;


    /** Holds the view of the fragment */
    private View view;

    /** Holds reference to the application class */
    MyApplication app;

    /** Holds singleton reference for the FragmentPoker class */
    private static FragmentPoker me;

    /**
     * Default constructor for the FragmentHand.
     */
    public FragmentPoker() {
        // Required empty public constructor
        me = this;
    }

    /**
     * Singleton getter method that returns the only instance of FragmentPoker
     * @return me is the instance of the FragmentPoker
     */
    public static FragmentPoker getInstance(){
        return me;
    }

    /**
     * This method is a life cycle method that calls the super onCreateView.
     * after doing this, it creates a reference to the current application.
     * and then it creates a reference to the current activity.
     * then creates a view for the fragment, upon doing so it returns the view.
     * @param inflater for the fragment
     * @param container for the fragment
     * @param savedInstanceState of the fragment
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);

        app = MyApplication.getInstance();

        a = getActivity();

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_poker, container, false);
        return view;
    }

    /**
     * Calls the super method for onStart, then set the buttons to the XML and turn on the click
     * listener. Then it sets the person name to the fragment.
     */
    @Override
    public void onStart(){
        super.onStart();

        replace1 = false;
        replace2 = false;
        replace3 = false;
        replace4 = false;
        replace5 = false;

        bank = (TextView) view.findViewById(R.id.bank);
        handsPlayed = (TextView) view.findViewById(R.id.hands);

        bank.setText("" + app.winnings + "  DogeCoins");
        handsPlayed.setText(""+ app.handsPlayed);

        menu = (Button) view.findViewById(R.id.menu);
        menu.setOnClickListener(this);

        deal = (Button) view.findViewById(R.id.deal);
        deal.setOnClickListener(this);

        wins = (Button) view.findViewById(R.id.winButton);
        if(!a.equals(GameBS3.getInstance())){
            wins.setOnClickListener(this);
        }
        else{
            menu.setLayoutParams(new LinearLayout.LayoutParams(0, ActionBar.LayoutParams.MATCH_PARENT ,1.5f));
            deal.setLayoutParams(new LinearLayout.LayoutParams(0, ActionBar.LayoutParams.MATCH_PARENT ,1.5f));
            wins.setVisibility(View.INVISIBLE);
        }


        card1 = (Button) view.findViewById(R.id.button1);
        card1.setOnClickListener(this);
        card1.setVisibility(View.INVISIBLE);
        card2 = (Button) view.findViewById(R.id.button2);
        card2.setOnClickListener(this);
        card2.setVisibility(View.INVISIBLE);
        card3 = (Button) view.findViewById(R.id.button3);
        card3.setOnClickListener(this);
        card3.setVisibility(View.INVISIBLE);
        card4 = (Button) view.findViewById(R.id.button4);
        card4.setOnClickListener(this);
        card4.setVisibility(View.INVISIBLE);
        card5 = (Button) view.findViewById(R.id.button5);
        card5.setOnClickListener(this);
        card5.setVisibility(View.INVISIBLE);

        card1img = (ImageView) view.findViewById(R.id.card1);
        card2img = (ImageView) view.findViewById(R.id.card2);
        card3img = (ImageView) view.findViewById(R.id.card3);
        card4img = (ImageView) view.findViewById(R.id.card4);
        card5img = (ImageView) view.findViewById(R.id.card5);

        if(card1img.getDrawable() == null) {
            card1img.setImageResource(R.drawable.back);
            card2img.setImageResource(R.drawable.back);
            card3img.setImageResource(R.drawable.back);
            card4img.setImageResource(R.drawable.back);
            card5img.setImageResource(R.drawable.back);
        }

        app = (MyApplication) getActivity().getApplication();
        a = getActivity();
        name = (TextView) view.findViewById(R.id.name);
        name.setText(app.getUserName());
    }

    /**
     * Event handler for the buttons.  Causes the text to change from throw to hold, or hold to
     * throw.
     * @param v event that has been caused by a click
     */
    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()){
            case R.id.button1:
                changeText(card1);
                replace1 = changeBoolean(replace1);
                break;
            case R.id.button2:
                changeText(card2);
                replace2 = changeBoolean(replace2);
                break;
            case R.id.button3:
                changeText(card3);
                replace3 = changeBoolean(replace3);
                break;
            case R.id.button4:
                changeText(card4);
                replace4 = changeBoolean(replace4);
                break;
            case R.id.button5:
                changeText(card5);
                replace5 = changeBoolean(replace5);
                break;
            case R.id.winButton:
                i = new Intent(this.getActivity(), WinListS5.class);
                break;
            case R.id.menu:

                i = new Intent(view.getContext(), MenuS2.class);

                pressedBefore = false;

                break;
            case R.id.deal:
                if (!pressedBefore) {
                    card1.setVisibility(View.VISIBLE);
                    card2.setVisibility(View.VISIBLE);
                    card3.setVisibility(View.VISIBLE);
                    card4.setVisibility(View.VISIBLE);
                    card5.setVisibility(View.VISIBLE);

                    runGame();

                    pressedBefore = true;

                } else {
                    deal.setClickable(false);

                    card1.setClickable(false);
                    card2.setClickable(false);
                    card3.setClickable(false);
                    card4.setClickable(false);
                    card5.setClickable(false);

                    drawNew();

                    calcWinnings();

                }
                break;
        }
        if(i != null){

            this.startActivity(i);

        }

    }

    /**
     * Changes the text of the button from throw to hold or hold to throw.
     * @param butt the button that needs it's text changed
     */
    public void changeText(Button butt){

        if(butt.getText().toString().equals(getResources().getString(R.string.Hold))){
            butt.setText(R.string.Throw);
        }else{
            butt.setText(R.string.Hold);
        }

    }

    /**
     * Helper method in order to change the bool variable.
     * @param bool the boolean value to be changed
     * @return returns a boolean value that is the opposite of what it was.
     */
    public boolean changeBoolean(boolean bool){

        if(!bool){
            bool = true;
        }
        else{
            bool = false;
        }
        return bool;
    }

    /**
     * Method in order to update the stats of the FragmentPoker such as the amount of
     * hands, and the amount of money that the user should have.
     * @param hands times played the game
     * @param money amount of money the user has gotten
     */
    public void updateFragStats(int hands, double money){

        handsPlayed.setText( "" + hands);
        bank.setText("" +money + "  DogeCoins");

    }


    /**
     * Changes the images of the cards to the cards that the user have drawn.
     * @param cards new cards to be draw on the screen
     */
    public void updateCards(String[] cards){

        app = MyApplication.getInstance();
        a =  getActivity();

        /**
         * Without this code, WinsS6 does not work because for some reason onStart() of the fragment
         * is never called to set these variables and as such they remain null. I would have liked
         * to find a better way to do this but ran out of time.
         */

        if(cards != null) {
            String cardOne = cards[0];
            String cardTwo = cards[1];
            String cardThree = cards[2];
            String cardFour = cards[3];
            String cardFive = cards[4];

            int imgID1 = a.getResources()
                    .getIdentifier(cardOne, "drawable", a.getApplicationContext().getPackageName());
            int imgID2 = a.getResources()
                    .getIdentifier(cardTwo, "drawable", a.getApplicationContext().getPackageName());
            int imgID3 = a.getResources()
                    .getIdentifier(cardThree, "drawable", a.getApplicationContext().getPackageName());
            int imgID4 = a.getResources()
                    .getIdentifier(cardFour, "drawable", a.getApplicationContext().getPackageName());
            int imgID5 = a.getResources()
                    .getIdentifier(cardFive, "drawable", a.getApplicationContext().getPackageName());

            /**
             * Because of an unintended bug or such in Android, using the .invalidate() method to
             * force a redraw does not always work as intended. However, setting the ImageView's
             * drawable resource to null and then re-updating it to it's new value DOES force the
             * intended redraw immediately. As such, we have included this unofficial hack.
             */
            card1img.setImageDrawable(null);
            card2img.setImageDrawable(null);
            card3img.setImageDrawable(null);
            card4img.setImageDrawable(null);
            card5img.setImageDrawable(null);

            card1img.setImageResource(imgID1);
            card2img.setImageResource(imgID2);
            card3img.setImageResource(imgID3);
            card4img.setImageResource(imgID4);
            card5img.setImageResource(imgID5);
        }
    }

    /**
     * Creates and runs the game.
     */
    public void runGame(){

        poker = new Game();

        poker.player.sort();

        hcard1 = poker.player.getCard(0);
        hcard2 = poker.player.getCard(1);
        hcard3 = poker.player.getCard(2);
        hcard4 = poker.player.getCard(3);
        hcard5 = poker.player.getCard(4);

        String[] hand = {hcard1.toString(), hcard2.toString(),
                hcard3.toString(), hcard4.toString(), hcard5.toString()};

        updateCards(hand);

    }

    /**
     * Draw new cards to replace the cards that the user said to throw out, and
     * then calls updateCards.
     */
    public void drawNew(){
        if (replace1){
            poker.dealOne(0);
        }
        if (replace2){
            poker.dealOne(1);
        }
        if (replace3){
            poker.dealOne(2);
        }
        if (replace4){
            poker.dealOne(3);
        }
        if (replace5){
            poker.dealOne(4);
        }

        poker.player.sort();


        hcard1 = poker.player.getCard(0);
        hcard2 = poker.player.getCard(1);
        hcard3 = poker.player.getCard(2);
        hcard4 = poker.player.getCard(3);
        hcard5 = poker.player.getCard(4);


        String[] hand = {hcard1.toString(), hcard2.toString(),
                hcard3.toString(), hcard4.toString(), hcard5.toString()};


        updateCards(hand);
    }

    /**
     * Calculates the amount of money the user has won if any for the given hand.
     * @return won if user has won or not
     */
    public boolean calcWinnings(){

        MyApplication app = MyApplication.getInstance();

        WinHand handtype = poker.player.getHandType();

        won = false;

        if(handtype.equals(WinHand.RFLUSH)){
            didWin(1000);
        }else if(handtype.equals(WinHand.SFLUSH)){
            didWin(250);
        }else if(handtype.equals(WinHand.FOURKIND)){
            didWin(100);
        }else if(handtype.equals(WinHand.FHOUSE)){
            didWin(50);
        }else if(handtype.equals(WinHand.FLUSH)){
            didWin(30);
        }else if(handtype.equals(WinHand.STRAIGHT)){
            didWin(25);
        }else if(handtype.equals(WinHand.THREEKIND)){
            didWin(20);
        }else if(handtype.equals(WinHand.TWOPAIR)){
            didWin(10);
        }else if(handtype.equals(WinHand.PAIR)){
            didWin(5);
        }else{
            app.handsPlayed +=1;
            alertStatus(0,false);
        }

        app.updateStats();

        return won;
    }

    /**
     * Helper method for the calcWinning.  If the user has won something it adds the amount the user
     * has won to the winnings, and increments the amount of times played.
     * @param amount that the user has won
     */
    private void didWin(int amount){

        MyApplication app = MyApplication.getInstance();

        app.winnings += amount;
        app.handsPlayed +=1;
        won = true;
        alertStatus(amount,true);
    }

    /**
     * alertBox method creates an alert box with an error message
     * @param amount message to be displayed in the alert box
     */
    public void alertStatus(int amount,boolean won){

        String s;
        if(won){
            s = "Congrats: You won "  + amount + " DogeCoins";
        }else{
            s = "Sadly: You didn't win, better luck next time";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setTitle("Result of Game");
        builder.setMessage(s);
        builder.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                resetGame();
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().verticalMargin = 1F;
        dialog.show();
    }

    /**
     * Restarts the game once a user has finished the game. Resets all the values.
     */
    public void resetGame(){
        card1img.setImageDrawable(null);
        card2img.setImageDrawable(null);
        card3img.setImageDrawable(null);
        card4img.setImageDrawable(null);
        card5img.setImageDrawable(null);
        pressedBefore = false;
        replace1 = false;
        replace2 = false;
        replace3 = false;
        replace4 = false;
        replace5 = false;
        card1.setText(R.string.Hold);
        card2.setText(R.string.Hold);
        card3.setText(R.string.Hold);
        card4.setText(R.string.Hold);
        card5.setText(R.string.Hold);

        this.onStart();
    }//end of resetGame
}//end of class
