package ca.ubc.cs.cpsc210.machine.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the payment unit in a vending machine.
 */
public class PaymentUnit {
    private List<Coin> BankedCoin;
    private List<Coin> InsertedCoin;
    private List<Coin> change;
    private List<Coin> returnCoins;

    // Constructor
    // EFFECTS: there are no banked coins and no coins have been inserted into the machine
    // as part of a payment
    public PaymentUnit() {
        BankedCoin = new LinkedList<Coin>();
        InsertedCoin = new LinkedList<Coin>();
    }

    // Clear all the coins banked in the unit
    // MODIFIES: this
    // EFFECTS: clears all the coins banked in the unit
    public void clearCoinsBanked() {
        BankedCoin.clear();
    }

    // Add a number of coins of a certain type to the banked coins in the unit
    // REQUIRES: number > 0
    // MODIFIES: this
    // EFFECTS: adds number coins of type c to the banked coins in the unit
    public void addCoinsToBanked(Coin c, int number) {
        for (int i = 0; i < number; i++) {
            BankedCoin.add(0, c);
        }

    }

    // Gets the number of coins banked in the unit of the given type
    // EFFECTS: returns number of coins banked of the given type
    public int getNumberOfCoinsBankedOfType(Coin c) {
        int j = 0;
        for (int i = 0; i < BankedCoin.size(); i++) {
            if (c.equals(BankedCoin.get(i))){
                j++;
            }
        }
        return j;
    }

    // Gets total value of coins banked
    // EFFECTS: returns the total value of all coins banked in the unit
    public int getValueOfCoinsBanked() {
        int j = 0;
        for (int i = 0; i < BankedCoin.size(); i++) {
            j = j + BankedCoin.get(i).getValue();
        }
        return j;
    }

    // Insert a coin as part of a transaction
    // MODIFIES: this
    // EFFECTS: adds coin c to the unit as a part of a transaction
    public void insertCoin(Coin c) {
        InsertedCoin.add(c);
    }

    // Get value of coins inserted for current payment
    // EFFECTS: returns value of coins inserted for current transaction
    public int getValueOfCoinsInserted() {
        int j = 0;
        for (int i = 0; i < InsertedCoin.size(); i++) {
            j = j + InsertedCoin.get(i).getValue();
        }
        return j;
    }

    // Cancel current transaction
    // MODIFIES: this
    // EFFECTS: coins inserted for current transaction are cleared; list of coins
    // inserted for current transaction is returned in the order in which they were inserted.
    public List<Coin> cancelTransaction() {
        returnCoins = new LinkedList<Coin>();
        for (Coin c : InsertedCoin){
            returnCoins.add(c);
        }
        InsertedCoin.clear();
        return returnCoins;
    }

    // Make a purchase of an item with given cost
    // REQUIRES: cost <= total value of coins inserted as part of current transaction
    // MODIFIES: this
    // EFFECTS: adds coins inserted to coins banked in unit and returns list of coins that will be provided as change.
    // Coins of largest possible value are used when determining the change.  Change in full is not guaranteed -
    // will provide only as many coins as are banked in the machine, without going over the amount due.
    public List<Coin> makePurchase(int cost) {
        change = new LinkedList<Coin>();
        int j = getValueOfCoinsInserted();
        for (Coin c : InsertedCoin){
            BankedCoin.add(c);
        }

        InsertedCoin.clear();
        if (j - cost > 4){
            while (j - cost >=100 && BankedCoin.contains(Coin.LOONIE)) {
                change.add(Coin.LOONIE);
                j = j-100;
                BankedCoin.remove(Coin.LOONIE);
            }

            while (j - cost >=25 &&BankedCoin.contains(Coin.QUARTER)){
                change.add(Coin.QUARTER);
                j = j-25;
                BankedCoin.remove(Coin.QUARTER);
            }

            while (j - cost >=10 && BankedCoin.contains(Coin.DIME)){
                change.add(Coin.DIME);
                j = j-10;
                BankedCoin.remove(Coin.DIME);
            }

            while (j - cost >=5 &&BankedCoin.contains(Coin.NICKEL)){
                change.add(Coin.NICKEL);
                j = j-5;
                BankedCoin.remove(Coin.NICKEL);
            }
        }
       return change;
    }
}
