package ca.ubc.cs.cpsc210.machine.test;

import ca.ubc.cs.cpsc210.machine.model.Coin;
import ca.ubc.cs.cpsc210.machine.model.PaymentUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaymentUnitTest {
    private PaymentUnit vm;

    @Before
    //construct a new PaymentUnit object prior to running each test
    public void setUp() throws Exception {
        vm = new PaymentUnit();
    }

    @Test
    public void testClearCoinsBanked() {
        assertEquals(0, vm.getValueOfCoinsBanked());
        vm.addCoinsToBanked(Coin.LOONIE, 2);
        assertEquals(200, vm.getValueOfCoinsBanked());
        vm.clearCoinsBanked();
        assertEquals(0, vm.getValueOfCoinsBanked());
    }

    @Test
    public void testAddCoinsToBanked(){
        assertEquals(0, vm.getValueOfCoinsBanked());
        vm.addCoinsToBanked(Coin.NICKEL, 6);
        assertEquals(30, vm.getValueOfCoinsBanked());
        vm.addCoinsToBanked(Coin.QUARTER, 4);
        assertEquals(130, vm.getValueOfCoinsBanked());
    }

    @Test
    public void testGetNumberOfCoinsBankedOfType(){
        vm.addCoinsToBanked(Coin.LOONIE, 3);
        vm.addCoinsToBanked(Coin.QUARTER, 2);
        vm.addCoinsToBanked(Coin.DIME, 5);
        assertEquals(3, vm.getNumberOfCoinsBankedOfType(Coin.LOONIE));
        assertEquals(2, vm.getNumberOfCoinsBankedOfType(Coin.QUARTER));
        assertEquals(5, vm.getNumberOfCoinsBankedOfType(Coin.DIME));
    }

    @Test
    public void testGetValueOfCoinsBanked(){
        vm.addCoinsToBanked(Coin.LOONIE, 3);
        vm.addCoinsToBanked(Coin.QUARTER, 2);
        vm.addCoinsToBanked(Coin.DIME, 5);
        assertEquals(400, vm.getValueOfCoinsBanked());
    }

    @Test
    public void testGetValueofCoinsInserted(){
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.LOONIE);
        assertEquals(125, vm.getValueOfCoinsInserted());
    }

    @Test
    public void testCancelTransaction(){
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.DIME);
        assertEquals(2, vm.cancelTransaction().size());

    }

    @Test
    public void testMakePurchase() {
        vm.addCoinsToBanked(Coin.LOONIE, 2);
        vm.addCoinsToBanked(Coin.QUARTER, 4);
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);

        List<Coin> change = vm.makePurchase(300);
        assertEquals(0, change.size());

        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);

        List<Coin> secondPurchase = vm.makePurchase(200);
        assertEquals(1, secondPurchase.size());
    }

    //TODO: add tests
}
