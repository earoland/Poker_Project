package com.example.nick.androidproject2;

import java.util.Random;

/**
 * The Game class simulates a game of poker being played.  Such as drawing a hand, shuffling,
 * and swaping cards.
 * @version 10/28/2016
 * @author Ethan Roland & Nick Sprinkle
 */
public class Game
{
	/** an array of type card that holds the deck */
    private Card[] deck;
    
    /** an instance of Hand named player, holds the player's hand */
    public Hand player;

    /** a named constant that hold the maximum deck size */
    public static final int     DECK_SIZE  = 52;
    
    /** a named constant that holds the maximum hand size to avoid magic numbers*/
	public static final int HAND_SIZE = 5;
	
	/** holds the index of the hard that the player wants to replace */
    private int index;

    
    /**
     * creates a new game object with all fields initialized
     * initializes the deck but does not deal to players
     */
    public Game ()
    {
    	index = 0;
    	this.deck = new Card[DECK_SIZE];
    	this.player = new Hand();
    	this.initPack();
        this.shuffle();
        this.deal();


    }

    /**
     * initializes the deck of cards so that for each space in the deck
     *  a unique card object is placed there
     */
    private void initPack()
    {
        int cardNum = 0;

        for (Suit suit :  Suit.values())
        {
            for (Face face : Face.values())
            {
                deck[cardNum++] = new Card(face, suit);
            }
        }
    }

    /**
     * The Fisher-Yates Shuffle. From "The Art of Computer Programming 2", 3rd
     * Edition, Addison-Wesley. pp-145-156.
     */
    public void shuffle()
    {
      Random rnd = new Random();
      for (int i = deck.length - 1; i > 0; i--)
      {
        int index = rnd.nextInt(i + 1);
        this.swap(index, i);
      }
    }

    /**
     * swaps two card within the deck
     */
    private void swap(int one, int two)
    {
        Card a = deck[one];
        deck[one] = deck[two];
        deck[two] = a;
    }
    
    /**
     * deals 5 cards to the player's hand
     */
    public void deal()
    {
    	for(int hIndex = 0; hIndex < HAND_SIZE; hIndex++)
    	{
    		player.setCard(hIndex, deck[index++ % DECK_SIZE]);
    	}
    }
    
    /**
     * Deals one card to the
     */
    public void dealOne(int hIndex)
    {
    	player.setCard(hIndex, deck[index++ % DECK_SIZE]);
    }

    /**
     * Gets a card from a player hand at a certain index.
     * @param index which card to return
     * @return Card which is the card that was selected to be gotten
     */
	public Card getCard(int index){
		return player.getCard(index);
	}

}
