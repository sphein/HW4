/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class DestinationCards {
    private City City1;
    private City City2;
    private int points;
    
    public DestinationCards(){
        Route r = new Route("Red", 3);
        this.City1 = new City("Hayward");
        this.City1.addRoute(r);
        this.City2 = new City("Fremont");
        this.City2.addRoute(r);
        this.points = 3;
    }
    public City getCity1(){
        return this.City1;
    }
        public City getCity2(){
        return this.City2;
    }
        public int getPoints(){
            return this.points;
        }
    
}
