import org.junit.Test;
import static org.junit.Assert.*;

public class SpaceshipTest {


    @Test
    public void testMoveInBounds(){
        Spaceship spaceship1 = new Spaceship(300, 300);
        spaceship1.move(200, 2);
        assertEquals(spaceship1.getX(), 450);
        assertEquals(spaceship1.getY(), 252);
    }


    @Test
    public void testMoveXOutYIn(){
        Spaceship spaceship1 = new Spaceship(100, 2);
        spaceship1.move(-350, 200);
        assertEquals(spaceship1.getX(), 0);
        assertEquals(spaceship1.getY(), 450);
    }

    @Test
    public void testMoveXInYOut(){
        Spaceship spaceship1 = new Spaceship(50, 50);
        spaceship1.move(30, 600);
        assertEquals(spaceship1.getX(), 280);
        assertEquals(spaceship1.getY(), 600);
    }

}