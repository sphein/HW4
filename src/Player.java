
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
    
    public Player(String n, TrainTokens t){
        this.name = n;
        this.trains = t;
        this.numTrains = 45;
        this.SM = new ScoreMarker();
        this.DC = new ArrayList();
        this.DC.add(new DestinationCards());
    }
    
    //public void need a fcn for updating numTrains
          
    public int getnumTrains(){
        return this.numTrains;
    }
    
    public ScoreMarker getSM(){
        return this.SM;
    }
    public ArrayList<DestinationCards> getDestinationCards(){
        return this.DC;
    }
    
    /**
     *
     * @param c1
     * @param c2
     * @return
     */
    public int PointsThisRound(City c1, City c2){
         Route r = null;
             for (int i = 0; i < c1.getRoute().size(); i++){
                 if (c1.getRoute().get(i) == c2.getRoute().get(0))
                     r = c1.getRoute().get(i);
                 else if (c1.getRoute().get(i) == c2.getRoute().get(1))
                     r = c1.getRoute().get(i);
             }
             this.pointsEarned = r.getNumber();
             for (int i = 0; i < DC.size(); i++){
                 if (DC.get(i).getCity1().getRoute() == DC.get(i).getCity2().getRoute()){
                     this.pointsEarned = this.pointsEarned + this.DC.get(i).getPoints();
                 }
             }
             return this.pointsEarned;
             
    }
}
