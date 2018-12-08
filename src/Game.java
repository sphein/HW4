
import java.util.Scanner;

/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class Game {
    

         public static boolean enoughTrains(Player p, Route r){
         
             if (p.getnumTrains() >= r.getNumber()){
                 return true;
             }
             return false;
         }      

         
    /**
     * updates ScoreMarker based on points earned
     * @param p player object
     * @param c1 city object
     * @param c2 city object
     * @return
     */

    public static int moveScoreMarker(Player p, Route r){
             return p.PointsThisRound(r);

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
        Deck aDeck = new Deck();
        DestinationCards dc1;
        DestinationCards dc2;
        DestinationCards dc3;
        boolean enoughTrainsa;
        int numTrainCards = 0;
        boolean drawInsideClaim = false;
        int endCount = 0;

        
        //create cities and routes
        Route r1 = new Route("Red", 2, "R1");
        Route r2 = new Route("Blue", 5, "R2");
        Route r3 = new Route("Yellow", 4, "R3");
        Route r4 = new Route("Red", 2, "R4");
        Route r5 = new Route("Blue", 5, "R5");
        Route r6 = new Route("Yellow", 4, "R6");
        Route r7 = new Route("Green", 3, "R7");
        City c1 = new City ("Oakland");
        c1.addRoute(r1);
        c1.addRoute(r2);
        City c2 = new City("Hayward");
        c2.addRoute(r3);
        c2.addRoute(r2);
        c2.addRoute(r7);
        City c3 = new City("Fremont");
        c3.addRoute(r4);
        c3.addRoute(r3);
        City c4 = new City("San Jose");
        c4.addRoute(r4);
        c4.addRoute(r5);
        City c5 = new City("Daly City");
        c5.addRoute(r5);
        c5.addRoute(r6);
        c5.addRoute(r7);
        City c6 = new City("SF");
        c6.addRoute(r1);
        c6.addRoute(r6);
        Route r = r1;
        Route ra = r1;
        
        
        //initiliaze decks and board
        aDeck.setTCDeck();
        aDeck.setDCDeck(c1, c2, c3, c4, c5, c6);
        aDeck.setFaceUp();
        board.initializeBoard(c1, c2, c3, c4, c5, c6);
        board.addroutes(r1, r2, r3, r4, r5, r6, r7);

        //get player name and color
       // System.out.println("What is the first player's name?");
        
        //set players and train tokens
        TrainTokens a = new TrainTokens("Blue"); 
        P1 = new Player("John", a);
        a = new TrainTokens("Red");
        P2 = new Player("Jane", a);
        
        //give players Train Car Cards
        P1.addTrainCarCards(aDeck.drawTrainCarCard(), aDeck.drawTrainCarCard());
        P2.addTrainCarCards(aDeck.drawTrainCarCard(), aDeck.drawTrainCarCard());
                Player playerNow  = P1;
        
        //give players Destination Cards
        for (int i = 0; i < 2; i++){
            System.out.println(playerNow.getName() + ", here are your first two destination cards: ");
            dc1 = aDeck.drawDestinationCard();
            System.out.println("First Destination Card: " + dc1.toString());
            dc2 = aDeck.drawDestinationCard();
            System.out.println("Second Destination Card: " + dc2.toString());
            System.out.println("Would you like to discard one? ");
            System.out.println("[1] : The First One");
            System.out.println("[2] : The Second One");
            System.out.println("[0] : None");
             choice = sc.nextInt();
             if (choice == 0){
                 System.out.println("Ok!");
                 playerNow.addDestinationCards(dc1, dc2);
             }
             else if(choice == 1){
                 playerNow.addDestinationCards(dc2);
                 aDeck.discardDestinationCard(dc1);
             } 
             else if (choice == 2){
                 playerNow.addDestinationCards(dc1);
                 aDeck.discardDestinationCard(dc2);
                   
             }
             if (playerNow.getName().equalsIgnoreCase(P1.getName())){
                 P1 = playerNow;
                 playerNow = P2;
             }
        }

         //output the board and face up train car cards
        System.out.println("This is the board: ");
        board.displayBoard();
        System.out.print("These are the face-up train car cards: ");
        for (int i = 0; i < aDeck.getFaceUp().size(); i++){
            System.out.print(i + 1 + ". " + aDeck.getFaceUp().get(i).getcolorTrainCarCard() + " ");
        }
        

        System.out.println();
        //output the first player's information
        playerNow  = P1;
        System.out.println(playerNow.getName() + " will go first.");
        System.out.print("Your Train Car Cards: ");
        for (int i = 0; i < playerNow.getTC().size(); i++){
            System.out.print(playerNow.getTC().get(i).getcolorTrainCarCard() + " ");
        }
        System.out.println();
        System.out.print("Your destination cards: ");
        for(int i = 0; i < playerNow.getDC().size(); i++){
            System.out.print(playerNow.getDC().get(i).toString() + " ");
        }
        System.out.println();
        

        //play
        do {
        
            do {
               System.out.println("What will you do?");
                System.out.println("[1] Draw two train car cards.");
                System.out.println("[2] claim a route.");
                System.out.println("[3] Draw three destination cards.");
                System.out.println("[9] QUIT.");
                    choice = sc.nextInt();
                    
            if (choice != 1 && choice != 0 && choice != 2 && choice != 3){
            
                System.out.println("That is not a choice please choose again!");
        }
            }while(choice != 1 && choice != 9 && choice != 2 && choice != 3);
            
            if (choice == 1){
                
                System.out.println("Would you like to draw from face-up or deck?");
                System.out.println("[0] : Draw From Deck.");
                System.out.println("[1] : Draw From Face-Up Pile.");
                choice = sc.nextInt();
                
                if (choice == 0){
               playerNow.addTrainCarCards(aDeck.drawTrainCarCard(), aDeck.drawTrainCarCard());                    
                }
                else {
                    System.out.println("Which one do you want to pick?: 1 2 3 4 5");
                    choice = sc.nextInt();
                    playerNow.addTrainCarCards(aDeck.drawFaceUp(choice));
                    System.out.println("Choose one more:");
                    for (int i = 0; i < aDeck.getFaceUp().size(); i++){
                       System.out.print(i + 1 + ". " + aDeck.getFaceUp().get(i).getcolorTrainCarCard() + " ");
                    }
                    choice = sc.nextInt();
                   playerNow.addTrainCarCards(aDeck.drawFaceUp(choice));
                   aDeck.changesFaceUP(choice);
                }
                

               
            }
            else if (choice == 2){
                do {
                    
                
                System.out.println("Which route do you want to claim?");
                System.out.println("{1] : " + r1.toString());
                System.out.println("{2] : " + r2.toString());
                System.out.println("{3] : " + r3.toString());
                System.out.println("{4] : " + r4.toString());
                System.out.println("{5] : " + r5.toString());
                System.out.println("{6] : " + r6.toString());
                System.out.println("{7] : " + r7.toString());
                choice = sc.nextInt();
                ra = r;
                if(choice == 1){
                    r = board.getRoutes().get(0);
                }
                else if(choice == 2){
                    r = board.getRoutes().get(1);
                }
                else if(choice == 3){
                    r = board.getRoutes().get(2);
                }
                else if(choice == 4){
                    r = board.getRoutes().get(3);
                }
                else if(choice == 5){
                    r = board.getRoutes().get(4);
                }
                else if(choice == 6){
                    r = board.getRoutes().get(5);
                    
                }
                else if(choice == 7){
                    r = board.getRoutes().get(6);
                }
                
                enoughTrainsa = enoughTrains(playerNow, r);
                if ( enoughTrainsa == true){
                    if(r.getClaimed() == 0){
                        for(int i = 0; i < playerNow.getTC().size(); i++){
                                if(playerNow.getTC().get(i).getcolorTrainCarCard().equalsIgnoreCase(r.getColor())){
                                    numTrainCards++;
                                }
                        }
                        if(numTrainCards >= r.getNumber()){
                           playerNow.getSM().changePosition(moveScoreMarker(playerNow, r));
                          if(choice == 1){
                             board.getRoutes().get(0).setClaimed();
                             board.getRoutes().get(0).setClaimedBy(playerNow.getName());
                          }
                          else if(choice == 2){
                               board.getRoutes().get(1).setClaimed();
                               board.getRoutes().get(1).setClaimedBy(playerNow.getName());
                         }
                         else if(choice == 3){
                              board.getRoutes().get(2).setClaimed();
                              board.getRoutes().get(2).setClaimedBy(playerNow.getName());
                         }
                         else if(choice == 4){
                                board.getRoutes().get(3).setClaimed();
                                board.getRoutes().get(3).setClaimedBy(playerNow.getName());
                         }
                         else if(choice == 5){
                              board.getRoutes().get(4).setClaimed();
                              board.getRoutes().get(4).setClaimedBy(playerNow.getName());
                         }
                         else if(choice == 6){
                              board.getRoutes().get(5).setClaimed();
                              board.getRoutes().get(5).setClaimedBy(playerNow.getName());
                         }
                         else if(choice == 7){
                              board.getRoutes().get(6).setClaimed();
                              board.getRoutes().get(6).setClaimedBy(playerNow.getName());
                         }
                          r.resetClaimed();
                          playerNow.removeTrainTokens(r.getNumber());
                         for (int i = 0; i+1 <= r.getNumber(); i++){
                             for(int j = 0; j < playerNow.getTC().size(); j++){
                                 if(playerNow.getTC().get(j).getcolorTrainCarCard().equalsIgnoreCase(r.getColor())){
                                 playerNow.removeTC(j);
                                 
                                 j = playerNow.getTC().size();
                              }
                             }
                             
                         }
                         numTrainCards = r.getNumber();
                          
                        }
                        else{
                            System.out.println("Not enough train car cards");
                            System.out.println("Would you like to draw train car cards instead?");
                            System.out.println("They Will be drawn from the deck.");
                            System.out.println("[0] : Yes.");
                            System.out.println("[1] : No.");
                            choice  = sc.nextInt();
                            if (choice == 0){
                                playerNow.addTrainCarCards(aDeck.drawTrainCarCard(), aDeck.drawTrainCarCard());
                                numTrainCards = r.getNumber();
                                drawInsideClaim = true;
                            }
                            
                        }
                        
                    }
                        else {
                        System.out.println("This route is claimed!");
                    }
                }
                else{
                    System.out.println("Not Enough Trains");
                }
                
                
                }while(enoughTrainsa != true || r.getClaimed() == 1 || numTrainCards < r.getNumber());    
                if(drawInsideClaim == true){
                    numTrainCards = 0;
                }
                else if(enoughTrainsa == true && r.getClaimed() == 0 && numTrainCards >= r.getNumber()){
                                    numTrainCards = 0;
                                    r.setClaimed();
                }
            }
            else if (choice == 3){
                dc1 = aDeck.drawDestinationCard();
                System.out.println("First Destination Card: " + dc1.toString());
               dc2 = aDeck.drawDestinationCard();
               System.out.println("Second Destination Card: " + dc2.toString());
               dc3 = aDeck.drawDestinationCard();
               System.out.println("Third Destination Card " + dc3.toString());
               System.out.println("Would you like to discard one? ");
               System.out.println("[1] : The First One");
               System.out.println("[2] : The Second One");
               System.out.println("[3] : The Third One");
               System.out.println("[4] : The First and Second.");
               System.out.println("[5] : The First and Third.");
               System.out.println("[6] : The Second and Third.");
               System.out.println("[0] : None");
               choice = sc.nextInt();
               if (choice == 0){
                 System.out.println("Ok!");
                 playerNow.addDestinationCards(dc1, dc2, dc3);
               }
               else if(choice == 1){
                 playerNow.addDestinationCards(dc2, dc3);
                 aDeck.discardDestinationCard(dc1);
               } 
               else if (choice == 2){
                 playerNow.addDestinationCards(dc1, dc3);
                 aDeck.discardDestinationCard(dc2);
               }
               else if(choice == 3){
                   playerNow.addDestinationCards(dc1, dc2);
                   aDeck.discardDestinationCard(dc3);
               }
               else if(choice == 4){
                   playerNow.addDestinationCards(dc3);
                   aDeck.discardDestinationCard(dc2);
                   aDeck.discardDestinationCard(dc1);
               }
               else if(choice == 5){
                   playerNow.addDestinationCards(dc2);
                   aDeck.discardDestinationCard(dc1);
                   aDeck.discardDestinationCard(dc3);
               }
               else if (choice ==  6){
                   playerNow.addDestinationCards(dc1);
                   aDeck.discardDestinationCard(dc2);
                   aDeck.discardDestinationCard(dc3);
              }
            }
            board.displayBoard();
            System.out.print("These are the face-up train car cards: ");
            for (int i = 0; i < aDeck.getFaceUp().size(); i++){
                System.out.print(i + 1 + ". " + aDeck.getFaceUp().get(i).getcolorTrainCarCard() + " ");
              }
            System.out.println();
            if (playerNow.getName().equalsIgnoreCase(P1.getName())){
                P1 = playerNow;
                playerNow = P2;
            }
            else {
                P2 = playerNow;
                playerNow = P1;
            }
            
            //check if two or less train tokens left
            if(endCount >= 1){
                endCount++;
            }
            else if(playerNow.getnumTrains() <= 2 && endCount != 2){
                System.out.println("Someone has less than two train cars. So everyone will take one last turn.");
                endCount++;
            }            
            
            if(endCount == 3){
                choice = 9;
            }
            
            //if all routes are claimed
            //if(board)
            
            //display next players information
            System.out.println("Name: " + playerNow.getName() + ", Number of trains:" + playerNow.getnumTrains() + ",  Score: " + playerNow.getSM().getPosition());
            System.out.print("Train Car Cards: ");
            for (int i = 0; i < playerNow.getTC().size(); i++){
                System.out.print(playerNow.getTC().get(i).getcolorTrainCarCard() + ", ");
            }
            System.out.println();
            System.out.print("Destination Cards: ");
            for (int i = 0; i < playerNow.getDC().size(); i++){
                System.out.print(playerNow.getDC().get(i).getCity1().getName() + " to " + playerNow.getDC().get(i).getCity2().getName() + " for " + playerNow.getDC().get(i).getPoints() + " points.");
            }
            

            
        }while(choice != 9);
        

        //Calculate longest path bonue
        System.out.println("That is the end of the game. Calculating longest path...");
        

        
        
        //output scores one last time
        System.out.println(P1.getName() + "'s Score: " + P1.getSM().getPosition() + " | | | | " + P2.getName() + "'s Score: " + P2.getSM().getPosition());
        if(P1.getSM().getPosition() < P2.getSM().getPosition()){
            System.out.println("The Winner is " + P2.getName() + "!");
        }
        else if(P1.getSM().getPosition() > P2.getSM().getPosition()){
            System.out.println("The Winner is " + P1.getName() + "!");
        }
        else{
            System.out.println("It's a tie1");
        }
        


    }  
}
