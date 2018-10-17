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
            
            //set players and train tokens
            TrainTokens a = new TrainTokens("Blue"); 
            P1 = new Player("John", a);
            a = new TrainTokens("Red");
            P2 = new Player("Jane", a);
            
            //set the first city
            Route r1 = new Route("Red", 4);
            City b = new City("Hayward");
            b.addRoute(r1);
            Route r2 = new Route("Blue", 5);
            b.addRoute(r2);
            board.addCity(b);
            
            //set the second city
            r1 = new Route("Red", 4);
            b = new City("Fremont");
            r2 = new Route("Yellow", 6);
            b.addRoute(r1);
            b.addRoute(r2);
            board.addCity(b);
            
            //Set the third city
            r1 = new Route("Yellow", 6);
            r2 = new Route("Blue", 5);
            b.addRoute(r1);
            b.addRoute(r2);
            board.addCity(b);
            
            
            
            
            
            
            
            
    
    
    }
    
    
}
