
import java.util.ArrayList;

/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class Board {
    private ArrayList<City> cities;
    
    public Board(){
        cities = new ArrayList();
    }
    
    public void initializeBoard(City c1, City c2, City c3, City c4, City c5, City c6){
           cities.add(c1);
           cities.add(c2);
           cities.add(c3);
           cities.add(c4);
           cities.add(c5);
           cities.add(c6);
    }
    public ArrayList<City> getCities(){
        return this.cities;
    }
    
    public void displayBoard(){
        System.out.println("Oakland - Blue(5) - Hayward - Yellow(4) - Fremont");
        System.out.println(" |                      |                     |");
        System.out.println("Red(2)               Green(3)               Red(2)");
        System.out.println(" |                      |                     | ");
        System.out.println("SF  - Yellow(4) -   Daly City - Blue(5) - San Jose");
    }
}
