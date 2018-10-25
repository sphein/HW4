/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class Route implements Comparable<Route>{
    private String color;
    private int number;
    
    /**
     * constructor
     * @param c color name
     * @param n number of routes
     */
    public Route(String c, int n){
        this.color = c;
        this.number = n;
    }

    /**
     * @return color
     */
    public String getColor(){
        return this.color;
    }

    /**
     * @return number of routes
     */
    public int getNumber(){
        return this.number;
    }

    /**
     * compares two routes to check if they are identical
     */
    @Override
    public int compareTo(Route o) {
        if(this.color.equals(o.getColor()))
            return 1;
        return 0;
    }
}
