/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INFINITE
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void enoughTrainsShouldReturnTrue(){
        //Game is tested
        Game tester = new Game();
        
        Board board = new Board();
        
        //set player
        TrainTokens a = new TrainTokens("Blue"); 
        Player P1 = new Player("John", a);
        a = new TrainTokens("Red");
        Player P2 = new Player("Jane", a);
        
        //set city
         //set the first city
        City c1 = new City("Hayward");
        Route r1 = new Route("Red", 4);
        Route r2 = new Route("Blue", 5);
        c1.addRoute(r1);
        c1.addRoute(r2);
        board.addCity(c1);

        //set the second city
        City c2 = new City("Fremont");
        r1 = new Route("Red", 4);
        r2 = new Route("Yellow", 6);
        c2.addRoute(r1);
        c2.addRoute(r2);
        board.addCity(c2);
        
        //assert statements
        
        assertEquals(true, tester.enoughTrains(P1, c1, c2), "Player has enough trains");
       }

    private boolean enoughTrains(Player p, City c1, City c2){
         
     Route r = null;
     for (int i = 0; i < c1.getRoute().size(); i++){
         if (c1.getRoute().get(i) == c2.getRoute().get(0))
             r = c1.getRoute().get(i);
         else if (c1.getRoute().get(i) == c2.getRoute().get(1))
             r = c1.getRoute().get(i);
     }
     if(r == null)
         return false;
     if (p.getnumTrains() >= r.getNumber())
        return true;

     return false;
 }    
}
