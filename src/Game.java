/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Game {

    public static void main(String args){
            Player P1;
            Player P2;
            Board board = new Board();
            
            TrainTokens a = new TrainTokens("Blue");
            
            P1 = new Player("John", a);
            a = new TrainTokens("Red");
            P2 = new Player("Jane", a);
            
            Route r1 = new Route("Red", 4);
            City b = new City("Hayward");
            b.addRoute(r1);
            Route r2 = new Route
            
            board.addCity(b);
            
            r1 = new Route("Blue", 5);
            b = new City("Fremont");
            bo
            
            
            
    
    
    }
    
    
}
