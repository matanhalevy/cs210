package ca.ubc.cs.cpsc210.machine.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Represents a coin (one of loonie, quarter, dime & nickel).
 */
public enum Coin {
    LOONIE(0, 100), QUARTER(1, 25), DIME(2, 10), NICKEL(3, 5);

    public static final int SIZE;
    private static final List<Coin> coins;
    private int rank;   // rank of coin (highest value coin has rank 0, next highest rank 1, etc.)
    private int value;  // value of coin in cents

    static {
        coins = new ArrayList<Coin>();

        Collections.addAll(coins, Coin.values());

        SIZE = coins.size();
    }

    private Coin(int rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    // Get the rank of this coin
    // EFFECTS: returns rank fo this coin
    public int getRank() {
        return rank;
    }

    // Get the value of this coin
    // EFFECTS: returns the value of this coin in cents
    public int getValue() {
        return value;
    }

    // Get a list of coins in the enumeration
    // EFFECTS: returns a list of coins in the enumeration
    public static List<Coin> getCoins() {
        return coins;
    }
}
