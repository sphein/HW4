
import java.util.ArrayList;

/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class Board {
    private ArrayList<City> cities;

    /**
     * constructor
     */
    public Board(){
        cities = new ArrayList();
    }

    /**
     * adds a city to the list
     * @param c object city
     */
    public void addCity(City c){
        this.cities.add(c);
    }

    /**
     * print board to user
     */
    public void displayBoard(){
        System.out.println("\t\t\t\t\tH\n" +
                            "\t\t\t\t/\t|\n" +
                            "\t\t\t/\t\t|\n" +
                            "\t\t/\t\t\t|\n" +
                            "\t/\t\t\t\t|\n" +
                            "O\t_\t_\t_\t_\tF");
    }
}
