package test;

import app.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TreatTest {

    @Test
    public void testVanillaIceCreamOnACone(){
        Cone cone = new Cone();
        IceCream iceCream = new IceCream("vanilla", cone);
        assertEquals("vanilla ice cream on a cone",iceCream.readOutOrder());
    }

    @Test
    public void testSprinklesOnVanillaIceCreamOnACone(){
        Cone cone = new Cone();
        IceCream iceCream = new IceCream("vanilla", cone);
        Sprinkles sprinkles = new Sprinkles(iceCream);
        assertEquals("sprinkles on vanilla ice cream on a cone",sprinkles.readOutOrder());
    }

    @Test
    public void testSmartiesAndSprinklesOnVanillaIceCreamOnACone(){
        Cone cone = new Cone();
        IceCream iceCream = new IceCream("vanilla", cone);
        Sprinkles sprinkles = new Sprinkles(iceCream);
        Smarties smarties = new Smarties(sprinkles);
        assertEquals("smarties and sprinkles on vanilla ice cream on a cone",smarties.readOutOrder());
    }

    @Test
    public void testSprinklesAndSmartiesOnVanillaIceCreamOnACone(){
        Cone cone = new Cone();
        IceCream iceCream = new IceCream("vanilla", cone);
        Smarties smarties = new Smarties(iceCream);
        Sprinkles sprinkles = new Sprinkles(smarties);
        Treat myTreat = sprinkles;
        assertEquals("sprinkles and smarties on vanilla ice cream on a cone",myTreat.readOutOrder());
    }

    @Test
    public void testWithAnonymousConstructors(){
        Treat myTreat = new Sprinkles(new Smarties(new IceCream("vanilla", new Cone())));
        assertEquals("sprinkles and smarties on vanilla ice cream on a cone",myTreat.readOutOrder());
    }

    @Test
    public void testCalculateCostWithOneTopping(){
        Cone cone = new Cone();
        IceCream iceCream = new IceCream("Chocolate", cone);
        ChocolateDip chocolateDip = new ChocolateDip(iceCream);
        Smarties smarties = new Smarties(chocolateDip);
        Treat treat = smarties;
        assertEquals(treat.calculateCost(), 22);
    }

    @Test
    public void testCalculateCostWithTwoTopping(){
        Cone cone = new Cone();
        IceCream iceCream = new IceCream("Chocolate", cone);
        ChocolateDip chocolateDip = new ChocolateDip(iceCream);
        Smarties smarties = new Smarties(chocolateDip);
        Sprinkles sprinkles = new Sprinkles(smarties);
        Treat treat = sprinkles;
        assertEquals(treat.calculateCost(), 23);
    }

}