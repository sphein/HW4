/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class Route implements Comparable<Route>{
    private String color;
    private int number;
    
    public Route(String c, int n){
        this.color = c;
        this.number = n;
    }
    
    public void setColor(String c){
        this.color = c;
    }
    public String getColor(){
        return this.color;
    }
    public void setNumber(int n){
        this.number = n;
    }
    public int getNumber(){
        return this.number;
    }

    @Override
    public int compareTo(Route o) {
        if(this.color.equals(o.getColor()))
            return 1;
        return 0;
    }



}
