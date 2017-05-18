package com.example.nick.androidproject2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * This fragment is a list of hands you can win in the poker game.  This passes information about
 * the hand to the winS6 to be displayed.
 * @version 10/24/2016
 * @author Ethan Roland &Nick Sprinkle
 */
public class FragmentWinList extends Fragment implements AdapterView.OnItemClickListener {

    /** Array that contains the names of the hands possible to win*/
    private final String HANDS[] = {"$1000 Royal Flush","$250 Straight Flush","$100 4 of a kind",
            "$50 Full House","$30 Flush","$25 Straight","$20 3 of a kind","$10 2 pair","$5 pair"};
    /** Array that contains the descriptions of the hands*/
    private final int DESC[] = {R.string.royalFlush,
            R.string.straightFlush,
            R.string.fourOfAKind,
            R.string.fullHouse,
            R.string.flush,
            R.string.straight,
            R.string.threeOfAKind,
            R.string.twoPair,
            R.string.pair};

    /** List of cards id to be set to in winS6*/
    //private final int CARDSLIST[][] = {{R.drawable.ace_of_diamonds,R.drawable.king_of_diamonds,
       // R.drawable.queen_of_diamonds, R.drawable.jack_of_diamonds, R.drawable.ten_of_diamonds}};


    private ArrayAdapter<String> myAdapter;

    /** contains the list view for the fragment*/
    private ListView lv;

    /** holds the view for the fragment*/

    private View view;

    /** Default constructor for the winlist fragment*/
    public FragmentWinList() {
        // Required empty public constructor
    }

    /**
     * Life cycle method for the fragment called onCreateView. It calls the super method, and
     * creates a view for the fragment, and returns the view.
     * @param inflater for the fragment
     * @param container for the fragment
     * @param savedInstanceState for the fragment
     * @return view for the fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_win_list, container, false);
        return view;
    }

    /**
     * Calls the onStart super method, and then sets the list view to the XML, sets up the
     * arrayAdapter, then finishes setting up the list view by putting the adapter into the
     * list view, and set on the on click listener.
     */
    @Override
    public void onStart(){
        super.onStart();

        //sets the listview to an id
        lv = (ListView) view.findViewById(R.id.listView);

        //sets up the adapter
        myAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1,
                HANDS);

        //puts the adapter into the list view
        lv.setAdapter(myAdapter);

        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(this);
    }

    /**
     * If one of the listed items are clicked this method handles the action for it. The method puts
     * in an intent which has which listed item was click.  Then it adds the description to the
     * intent. Which then the WinS6 screen is clicked.
     * @param parent is the adapter view that was clicked
     * @param view the view that this happen in
     * @param position position in the list view that was clicked
     * @param id of the item
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Intent i = null;
        String[] cards = passValues(position);
        i = new Intent(view.getContext(), WinS6.class);
        i.putExtra("cards",HANDS[position]);
        i.putExtra("desc",getActivity().getString(DESC[position]));
        i.putExtra("card0", cards[0]);
        i.putExtra("card1", cards[1]);
        i.putExtra("card2", cards[2]);
        i.putExtra("card3", cards[3]);
        i.putExtra("card4", cards[4]);

        if(i != null) {
            this.startActivity(i);
        }
    }

    /**
     * Makes an array for a win hand. Returns the array of strings for a choosen win hand.
     * @param position in the view list that was selected
     * @return result which is array of strings of the name of a win hand
     */
    private String[] passValues(int position) {
        String[] result = new String[5];
        switch (position) {
            case 0:
                result = new String[]{"ace_of_spades", "ten_of_spades", "jack_of_spades",
                    "queen_of_spades", "king_of_spades"};
                break;
            case 1:
                result = new String[]{"nine_of_spades", "ten_of_spades", "jack_of_spades",
                        "queen_of_spades", "king_of_spades"};
                break;
            case 2:
                result = new String[]{"ace_of_spades", "ace_of_hearts", "ace_of_diamonds",
                        "ace_of_clubs", "king_of_spades"};
                break;
            case 3:
                result = new String[]{"ace_of_spades", "ace_of_hearts", "ace_of_diamonds",
                        "king_of_clubs", "king_of_spades"};
                break;
            case 4:
                result = new String[]{"ace_of_spades", "four_of_spades", "nine_of_spades",
                        "jack_of_spades", "king_of_spades"};
                break;
            case 5:
                result = new String[]{"ace_of_spades", "two_of_clubs", "three_of_diamonds",
                        "four_of_hearts", "five_of_spades"};
                break;
            case 6:
                result = new String[]{"ace_of_spades", "ace_of_clubs", "ace_of_diamonds",
                        "four_of_hearts", "five_of_spades"};
                break;
            case 7:
                result = new String[]{"ace_of_spades", "ace_of_clubs", "four_of_hearts",
                        "five_of_diamonds", "five_of_spades"};
                break;
            case 8:
                result = new String[]{"ace_of_spades", "four_of_clubs", "seven_of_diamonds",
                        "king_of_hearts", "king_of_spades"};
                break;


        }
        return result;
    }


}
