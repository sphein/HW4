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
    private ArrayList<TrainCarCards> TC;
    
    /**
     * constructor
     * @param n name for player
     * @param t string color chosen for token
     */
    public Player(String n, TrainTokens t){
        this.name = n;
        this.trains = t;
        this.numTrains = 25;
        this.SM = new ScoreMarker();
        this.DC = new ArrayList();
        this.TC = new ArrayList();
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
    public void addTrainCarCards(TrainCarCards c, TrainCarCards c2){
        TC.add(c);
        TC.add(c2);
    }
    public void addDestinationCards(DestinationCards a1, DestinationCards a2){
        this.DC.add(a1);
        this.DC.add(a2);
    }
    public void addDestinationCards(DestinationCards a1){
        this.DC.add(a1);
    }
    public void addDestinationCards(DestinationCards a1, DestinationCards a2, DestinationCards a3){
        this.DC.add(a1);
        this.DC.add(a2);
        this.DC.add(a3);
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<TrainCarCards> getTC(){
        return this.TC;
    }
    public ArrayList<DestinationCards> getDC(){
        return this.DC;
    }

    public void addTrainCarCards(TrainCarCards c)
    {
        this.TC.add(c);
    }
    /**
     * compares two cities to determine points earned
     * @param c1 city object 
     * @param c2 city object
     * @return
     */

    public int PointsThisRound(Route r){
        if(r.getNumber() == 2){
            this.pointsEarned = 1;
        }
        else if(r.getNumber() == 3){
            this.pointsEarned = 4;
        }
        else if(r.getNumber() == 4){
            this.pointsEarned = 7;
        }
        else if(r.getNumber() == 5){
            this.pointsEarned = 10;
        }
             
             
             for (int i = 0; i < DC.size(); i++){
                 if(this.DC.get(i).getCity1().getRoute().size() == 3 && this.DC.get(i).getCity2().getRoute().size() == 3){
                     for(int j = 0; j < 3; j++){
                         if(this.DC.get(i).getCity1().getRoute().get(j).getrouteOrder().equalsIgnoreCase(r.getrouteOrder()) && this.DC.get(i).getCity2().getRoute().get(j).getrouteOrder().equalsIgnoreCase(r.getrouteOrder())){
                             this.pointsEarned = this.pointsEarned + this.DC.get(i).getPoints();
                             this.DC.remove(i);
                         }
                      }
                 }
                 else if((this.DC.get(i).getCity1().getRoute().size() == 3 || this.getDC().get(i).getCity2().getRoute().size() == 3)) {
                     for(int j = 0; j < 2; j++){
                         if (this.DC.get(i).getCity1().getRoute().get(j).getrouteOrder().equalsIgnoreCase(r.getrouteOrder()) && this.DC.get(i).getCity2().getRoute().get(j).getrouteOrder().equalsIgnoreCase(r.getrouteOrder())){
                             this.pointsEarned = this.pointsEarned + this.DC.get(i).getPoints();
                             this.DC.remove(i);
                         }
                         else if (this.DC.get(i).getCity1().getRoute().size() == 3){
                             if(this.DC.get(i).getCity2().getRoute().get(0).getrouteOrder().equalsIgnoreCase(r.getrouteOrder()) && this.DC.get(i).getCity1().getRoute().get(2).getrouteOrder().equalsIgnoreCase(r.getrouteOrder())){
                                 this.pointsEarned = this.pointsEarned + this.DC.get(i).getPoints();
                                 this.DC.remove(i);
                             }
                         else if(this.DC.get(i).getCity2().getRoute().get(1).getrouteOrder().equalsIgnoreCase(r.getrouteOrder()) && this.DC.get(i).getCity1().getRoute().get(2).getrouteOrder().equalsIgnoreCase(r.getrouteOrder())){
                                  this.pointsEarned = this.pointsEarned + this.DC.get(i).getPoints();
                                  this.DC.remove(i);
                             }
                                    
                         }
                     }
                 } 
                 else {
                     for(int j = 0; j < 2; j++){
                         if(this.DC.get(i).getCity1().getRoute().get(j).getrouteOrder().equalsIgnoreCase(r.getrouteOrder()) && this.DC.get(i).getCity2().getRoute().get(j).getrouteOrder().equalsIgnoreCase(r.getrouteOrder())){
                             this.pointsEarned = this.pointsEarned + this.DC.get(i).getPoints();
                             this.DC.remove(i);
                              
                         }
                 }
              }
             }
             
             
             
             
             
             return this.pointsEarned;
           
    }
    public void removeDC(int a){
        this.DC.remove(a);
    }
    public void removeTC(int a){
        this.TC.remove(a);
    }
    public void removeTrainTokens(int a){
        this.numTrains = this.numTrains - a;

    }
}
