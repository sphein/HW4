/**
 * Title: HW4
 * Date: 10/17/2018
 * @author sphein; oouk
 */
public class ScoreMarker {
    private int position;
    
    
    public ScoreMarker(){
        this.position = 0;
    }
    
    public int getPosition(){
        return this.position;
    }
    public void changePosition(int a){
        this.position  = a + this.position;
    }
           
}
