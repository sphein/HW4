
import java.util.ArrayList;

/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class Board {
    private ArrayList<City> cities;
    private ArrayList<Route> routes;
    
    public Board(){
        cities = new ArrayList();
        routes = new ArrayList();
    }
    
    public void initializeBoard(City c1, City c2, City c3, City c4, City c5, City c6){
           cities.add(c1);
           cities.add(c2);
           cities.add(c3);
           cities.add(c4);
           cities.add(c5);
           cities.add(c6);
    }
    public void addroutes(Route r1, Route r2, Route r3, Route r4, Route r5, Route r6, Route r7){
        routes.add(r1);
        routes.add(r2);
        routes.add(r3);
        routes.add(r4);
        routes.add(r5);
        routes.add(r6);
        routes.add(r7);
    }
    public ArrayList<City> getCities(){
        return this.cities;
    }
    public ArrayList<Route> getRoutes(){
        return this.routes;
    }
    
    public void displayBoard(){
        //display the first line of the output for board
        System.out.print("Oakland - ");
        if (this.routes.get(1).getClaimed() == 0){
            System.out.print(this.routes.get(1).toString() + " - ");
        }
        else {
            System.out.print("xxxxxxx - ");
        }
        System.out.print("Hayward - ");
        if(routes.get(2).getClaimed() == 0){
            System.out.print(this.routes.get(2).toString() + " - ");
        }
        else{
            System.out.print("xxxxxxxxx - ");
        }
        System.out.println("Fremont");
        
        //output the middle line of the board
        System.out.println(" |                      |                     |");
        if(routes.get(0).getClaimed() == 0){
            System.out.print(this.routes.get(0).toString() + "               ");
        }
        else{
            System.out.print(" xxxxxx             ");
        }
        if(routes.get(6).getClaimed() == 0){
            System.out.print(this.routes.get(6).toString() + "               ");
        }
        else{
            System.out.print("xxxxxxxx                  ");
        }
        if (routes.get(3).getClaimed() == 0){
            System.out.println(this.routes.get(3).toString());
        }
        else{
            System.out.println("x");
        }
        System.out.println(" |                      |                     | ");
        
        
        //output the last line of the board
        System.out.print("SF - ");
        if (routes.get(5).getClaimed() == 0){
            System.out.print(this.routes.get(5).toString() + " -   ");
        }
        else{
            System.out.print("xxxxxxxxx - ");
        }
        System.out.print("Daly City - ");
        if (this.routes.get(4).getClaimed() == 0){
            System.out.print(this.routes.get(4).toString() + " - ");
        }
        else{
            System.out.print("xxxxxxx - ");
        }
        System.out.println("San Jose");
        /**
        System.out.println("Red(2)               Green(3)               Red(2)");
        System.out.println("SF  - Yellow(4) -   Daly City - Blue(5) - San Jose");
        **/
    }
}
