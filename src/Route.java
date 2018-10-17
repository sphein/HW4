/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Route {
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
}
