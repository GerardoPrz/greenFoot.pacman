import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    private ArrayList<ArrayList<String>> scenario = new ArrayList<ArrayList<String>>();
    private int i, j;

    public player(ArrayList<ArrayList<String>> scenario){
        this.scenario = scenario;
        resize();
        i = 0;
        j = 0;
    }

    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
            
            j = (x-180)/20;
            i = (y-48)/20;
        
            if (Greenfoot.isKeyDown("right") && j < 31){
                if(scenario.get(i).get(j+1) == "1"){
                    x+=3;
                    System.out.println("right");
                }
            } else{
                if (Greenfoot.isKeyDown("left") && j > 0){
                    if(scenario.get(i).get(j-1) == "1"){
                        x--;
                    }
                } else { 
                    if (Greenfoot.isKeyDown("up") && i > 0){
                        if(scenario.get(i-1).get(j) == "1"){
                            y--;
                        }
                    }else{ 
                        if (Greenfoot.isKeyDown("down") && i < 30){
                            if(scenario.get(i+1).get(j) == "1"){
                                 y++;
                            }
                        }
                    } 
                }
            }
        setLocation(x,y);
    }    

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 35;
        int newWidth = 35;
        myImage.scale(newHeight, newWidth);
    }
}
