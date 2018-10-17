
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class City {
    private String name;
    private ArrayList<Route> list;
    
    public City(String n){
        this.name = n;
        this.list = new ArrayList();
    }


    
    public void addRoute(Route r){
        this.list.add(r);
    }
}


