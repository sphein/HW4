/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class ScoreMarker {
    private int position;
    
    /**
     * constructor
     */
    public ScoreMarker(){
        this.position = 0;
    }
    
    /**
     * @return position of ScoreMarker
     */
    public int getPosition(){
        return this.position;
    }

    /**
     * updates position of ScoreMarker
     * @param a distance to move
     */
    public void changePosition(int a){
        this.position  = a + this.position;
    }
           
}
