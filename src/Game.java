
import java.util.Scanner;

/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class Game {
    
    /**
     * determines whether if player has enough trains to obtain city from previous
     * @param p player object
     * @param c1 city object
     * @param c2 city object
     * @return
     */
    public boolean enoughTrains(Player p, City c1, City c2){
         
        Route r = null;
        for (int i = 0; i < c1.getRoute().size(); i++){
            if (c1.getRoute().get(i) == c2.getRoute().get(0))
               r = c1.getRoute().get(i);
            else if (c1.getRoute().get(i) == c2.getRoute().get(1))
               r = c1.getRoute().get(i);
        }
        if(r == null)
            return false;
        else if (p.getnumTrains() >= r.getNumber())
            return true;
        return false;
    }      
         
    /**
     * updates ScoreMarker based on points earned
     * @param p player object
     * @param c1 city object
     * @param c2 city object
     * @return
     */
    public int moveScoreMarker(Player p, City c1, City c2){
            p.getSM().changePosition(p.PointsThisRound(c1, c2));
            return p.PointsThisRound(c1, c2);
         }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //declare variables
        Board board = new Board();
        Player P1;
        Player P2;
        int choice;
        Scanner sc = new Scanner(System.in);

        //set players and train tokens
        TrainTokens a = new TrainTokens("Blue"); 
        P1 = new Player("John", a);
        a = new TrainTokens("Red");
        P2 = new Player("Jane", a);

        //set the first city
        City b = new City("Hayward");
        Route r1 = new Route("Red", 4);
        Route r2 = new Route("Blue", 5);
        b.addRoute(r1); //red
        b.addRoute(r2); //blue
        board.addCity(b);

        //set the second city
        b = new City("Fremont");
        Route r3 = new Route("Yellow", 6);
        b.addRoute(r1); //red
        b.addRoute(r3); //yellow
        board.addCity(b);

        //Set the third city
        b = new City("Oakland");
        b.addRoute(r2); //blue
        b.addRoute(r3); //yellow
        board.addCity(b);
        
        //display board
        System.out.println("This is the board: ");
        board.displayBoard();
        
        //play
        System.out.println("What will you do?");
        System.out.println("[1] Draw two train car cards.");
        System.out.println("[2] claim a route.");
        System.out.println("[3] Draw three destination cards.");
        
        //receive input
        choice = sc.nextInt();
    }  
}
