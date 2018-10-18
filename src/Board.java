
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
    
    public void addCity(City c){
        this.cities.add(c);
    }
    
    public void displayBoard(){
        System.out.println("\t\t\t\t\tH\n" +
                            "\t\t\t\t/\t|\n" +
                            "\t\t\t/\t\t|\n" +
                            "\t\t/\t\t\t|\n" +
                            "\t/\t\t\t\t|\n" +
                            "O\t_\t_\t_\t_\tF");
    }
}
