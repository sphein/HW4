import java.util.ArrayList;

/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class City {
    private String name;
    private ArrayList<Route> list;

    /**
     *  //constructor
     * @param n for city name
     */
    public City(String n){
        this.name = n;
        this.list = new ArrayList();
    }

    /**
     * adds a route to the list
     * @param r object route
     */
    public void addRoute(Route r){
        this.list.add(r);
    }

    /**
     * getter returns list
     * @return list of routes
     */
    public ArrayList<Route> getRoute(){
        return this.list;
    }
    public String getName(){
        return this.name;
    }
}


