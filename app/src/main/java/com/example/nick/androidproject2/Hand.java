package com.example.nick.androidproject2;

import java.util.Arrays;

/**
 * The Hand class models a player hand of cards.  It orders, sorts, and detects what kind of win
 * has happen.
 * @Author Ethan Roland & Nick Sprinkle
 * @Version 10/25/2016
 */

public class Hand {

	//Named Constant Hand Size, maximum number of cards a hand can hold
	private static final int HAND_SIZE = 5;

	//array of cards representing a hand in poker
	private Card[] Hand;
	
	/*
	 * constructor that accepts a parameter of the maximum hand;
	 *  is private because no one should be able to create a hand with
	 *  a size larger than 5
	 */
	private Hand(int handSize) {
		Hand = new Card[handSize];
	}

	/*
	 * constructor without variables that calls the constructor with parameters and initializes
	 * the hand size to HAND_SIZE,
	 *  public because game needs to call this constructor and not another one
	 */
	public Hand() {
		this(HAND_SIZE);
	}

    /**
     * Uses Lambda expression. Sorts the cards in the hand.
     */
	public void sort()
	{
		Arrays.sort(Hand, (Card u0, Card u1) -> u0.compareTo(u1));
	}


	/*
	 * takes a card variable and an index and replaces the card in the hand at that index with the
	 *  given card; public because dealOne uses this method in game to deal a new card to the
	 *  player, computer would also use this method had I went for extra credit.
	 */
	public void setCard(int index, Card replace) {
		Hand[index] = replace;
	}

    /**
     * Gets a card from a player hand at a certain index.
     * @param index which card to return
     * @return Card which is the card that was selected to be gotten
     */
    public Card getCard(int index){
        return Hand[index];
    }

    /**
     * Determines what type of win hand has happen
     * @return the hand that won
     */
	public WinHand getHandType()
	{
		//code to figure out what hand is held, uses helper methods
		if(this.royalFlush())
		{
			return WinHand.RFLUSH;
		}
		else if(this.straightFlush())
		{
			return WinHand.SFLUSH;
		}
		else if(this.fourOfAKind())
		{
			return WinHand.FOURKIND;
		}
		else if(this.fullHouse())
		{
			return WinHand.FHOUSE;
		}
		else if(this.flush())
		{
			return WinHand.FLUSH;
		}
		else if(this.straight())
		{
			return WinHand.STRAIGHT;
		}
		else if(this.threeOfAKind())
		{
			return WinHand.THREEKIND;
		}
		else if(this.twoPair())
		{
			return WinHand.TWOPAIR;
		}
		else if(this.pair())
		{
			return WinHand.PAIR;
		}
		else
		{
			return WinHand.HIGHCARD;
		}

	}


    /*
     * helper method used in getHandtype to determine if the hand contains a royal flush,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean royalFlush()
    {
        boolean isRoyalFlush = false;
        this.sort();
        if(this.flush())
        {
            if(Hand[0].getName().toString().equals("king")
                    && Hand[1].getName().toString().equals("queen")
                    && Hand[2].getName().toString().equals("jack")
                    && Hand[3].getName().toString().equals("ten")
                    && Hand[4].getName().toString().equals("ace"))
            {
                isRoyalFlush = true;
            }
        }

        return isRoyalFlush;
    }

    /*
     * helper method used in getHandtype to determine if the hand contains a straight flush,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean straightFlush()
    {
        boolean isStraightFlush = false;
        this.sort();
        if(this.straight() && this.flush())
        {
            isStraightFlush = true;
        }
        return isStraightFlush;
    }

    /*
     * helper method used in getHandtype to determine if the hand contains a 4 of a kind,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean fourOfAKind()
    {
        boolean isFourOfKind = false;
        this.sort();
        if(Hand[0].getName().equals(Hand[1].getName())
                && Hand[1].getName().equals(Hand[2].getName())
                && Hand[2].getName().equals(Hand[3].getName()))
        {
            isFourOfKind = true;
        }
        if(Hand[1].getName().equals(Hand[2].getName())
                && Hand[2].getName().equals(Hand[3].getName())
                && Hand[3].getName().equals(Hand[4].getName()))
        {
            isFourOfKind = true;
        }
        return isFourOfKind;
    }

    /*
     * helper method used in getHandtype to determine if the hand contains a full house,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean fullHouse()
    {
        boolean isFullHouse = false;
        this.sort();
        if(Hand[0].getName().equals(Hand[1].getName())
                && Hand[1].getName().equals(Hand[2].getName())
                && Hand[3].getName().equals(Hand[4].getName()))
        {
            isFullHouse = true;
        }
        if(Hand[0].getName().equals(Hand[1].getName())
                && Hand[2].getName().equals(Hand[3].getName())
                && Hand[3].getName().equals(Hand[4].getName()))
        {
            isFullHouse = true;
        }
        return isFullHouse;
    }

    /*
     * helper method used in getHandtype to determine if the hand contains a flush,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean flush()
    {
        boolean isFlush = false;
        this.sort();
        if(Hand[0].getSuit().toString().equals("hearts")
                && Hand[1].getSuit().toString().equals( "hearts")
                && Hand[2].getSuit().toString().equals("hearts")
                && Hand[3].getSuit().toString().equals("hearts")
                && Hand[4].getSuit().toString().equals("hearts"))
        {
            isFlush = true;
        }
        else if(Hand[0].getSuit().toString().equals("spades")
                && Hand[1].getSuit().toString().equals("spades")
                && Hand[2].getSuit().toString().equals("spades")
                && Hand[3].getSuit().toString().equals("spades")
                && Hand[4].getSuit().toString().equals("spades"))
        {
            isFlush = true;
        }
        else if(Hand[0].getSuit().toString().equals("clubs")
                && Hand[1].getSuit().toString().equals("clubs")
                && Hand[2].getSuit().toString().equals("clubs")
                && Hand[3].getSuit().toString().equals("clubs")
                && Hand[4].getSuit().toString().equals("clubs"))
        {
            isFlush = true;
        }
        else if(Hand[0].getSuit().toString().equals("diamonds")
                && Hand[1].getSuit().toString().equals("diamonds")
                && Hand[2].getSuit().toString().equals("diamonds")
                && Hand[3].getSuit().toString().equals("diamonds")
                && Hand[4].getSuit().toString().equals("diamonds"))

        {
            isFlush = true;
        }
        return isFlush;
    }

    /*
     * helper method used in getHandtype to determine if the hand contains a straight,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean straight()
    {
        boolean isStraight = false;
        this.sort();
        if((Hand[0].rank() + 1) == Hand[1].rank()
                && (Hand[1].rank() + 1) == Hand[2].rank()
                && (Hand[2].rank() + 1) == Hand[3].rank()
                && (Hand[3].rank() + 1) == Hand[4].rank())
        {
            isStraight = true;
        }
        else if(Hand[0].getName().toString().equals("king")
                && Hand[1].getName().toString().equals("queen")
                && Hand[2].getName().toString().equals("jack")
                && Hand[3].getName().toString().equals("ten")
                && Hand[4].getName().toString().equals("ace"))
        {
            isStraight = true;
        }
        return isStraight;
    }

    /*
     * helper method used in getHandtype to determine if the hand contains a 3 of a kind,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean threeOfAKind()
    {
        boolean isThreeOfKind = false;
        this.sort();
        if(!this.fourOfAKind())
        {
            if(Hand[0].getName().equals(Hand[1].getName())
                    && Hand[1].getName().equals(Hand[2].getName()))
            {
                isThreeOfKind = true;
            }
            else if(Hand[1].getName().equals(Hand[2].getName())
                    && Hand[2].getName().equals(Hand[3].getName()))
            {
                isThreeOfKind = true;
            }
            else if(Hand[2].getName().equals(Hand[3].getName())
                    && Hand[3].getName().equals(Hand[4].getName()))
            {
                isThreeOfKind = true;
            }
        }
        return isThreeOfKind;
    }

    /*
     * helper method used in getHandtype to determine if the hand contains two pair,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean twoPair()
    {
        boolean isTwoPair = false;
        this.sort();
        if(!this.fullHouse())
        {
            if(Hand[0].getName().equals(Hand[1].getName())
                    && Hand[2].getName().equals(Hand[3].getName()))
            {
                isTwoPair = true;
            }
            else if(Hand[0].getName().equals(Hand[1].getName())
                    && Hand[3].getName().equals(Hand[4].getName()))
            {
                isTwoPair = true;
            }
            else if(Hand[1].getName().equals(Hand[2].getName())
                    && Hand[3].getName().equals(Hand[4].getName()))
            {
                isTwoPair = true;
            }
        }
        return isTwoPair;
    }

    /*
     * helper method used in getHandtype to determine if the hand contains a pair,
     *  is private because nothing outside of hand should need to call it
     */
    private boolean pair()
    {
        boolean isPair = false;
        this.sort();
        if(!this.twoPair() && !this.threeOfAKind())
        {
            if(Hand[0].getName().equals(Hand[1].getName()))
            {
                isPair = true;
            }
            else if(Hand[1].getName().equals(Hand[2].getName()))
            {
                isPair = true;
            }
            else if(Hand[2].getName().equals(Hand[3].getName()))
            {
                isPair = true;
            }
            else if(Hand[3].getName().equals(Hand[4].getName()))
            {
                isPair = true;
            }
        }
        return isPair;
    }
}
	

