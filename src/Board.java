
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
public class Board {
    private ArrayList<City> cities;
    
    public Board(){
        cities = new ArrayList();
    }
    
    public void addCity(City c){
        this.cities.add(c);
    }
    
    
}
