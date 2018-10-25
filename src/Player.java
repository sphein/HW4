import java.util.ArrayList;

/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class Player {
    private String name;
    private TrainTokens trains;
    private int numTrains;
    private ScoreMarker SM;
    private int pointsEarned;
    private ArrayList<DestinationCards> DC;
    
    /**
     * constructor
     * @param n name for player
     * @param t string color chosen for token
     */
    public Player(String n, TrainTokens t){
        this.name = n;
        this.trains = t;
        this.numTrains = 45;
        this.SM = new ScoreMarker();
        this.DC = new ArrayList();
        this.DC.add(new DestinationCards());
        this.pointsEarned = 0;
    }
    
    //public void need a fcn for updating numTrains

    /**
     * @return total number of train player has remaining
     */
          
    public int getnumTrains(){
        return this.numTrains;
    }
    
    /**
     * @return returns position of user on the board
     */
    public ScoreMarker getSM(){
        return this.SM;
    }

    /**
     * @return deck of destination card
     */
    public ArrayList<DestinationCards> getDestinationCards(){
        return this.DC;
    }
    
    /**
     * compares two cities to determine points earned
     * @param c1 city object 
     * @param c2 city object
     * @return
     */
    public int PointsThisRound(City c1, City c2){

        Route r = null;
       
        if (c1.getRoute().get(0).compareTo(c2.getRoute().get(0)) == 1) {
            r = c1.getRoute().get(0);
        }
             
        this.pointsEarned = r.getNumber();
        
        for (int i = 0; i < DC.size(); i++){
            if (DC.get(i).getCity1().getRoute().get(0).compareTo(DC.get(i).getCity2().getRoute().get(0)) == 1){
                this.pointsEarned = this.pointsEarned + this.DC.get(i).getPoints();
            }
        }
        return this.pointsEarned;   
    }
}
