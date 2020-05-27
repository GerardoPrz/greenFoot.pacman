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
    int speed;
    int score;

    public player(ArrayList<ArrayList<String>> scenario){
        this.scenario = scenario;
        resize();
        i = 0;
        j = 0;
        speed = 2;
        score = 0;
    }

    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
            
            j = (x-175)/20;
            i = (y-43)/20;
        
            if (Greenfoot.isKeyDown("right") && j < 30 && x < 800){
                if(scenario.get(i).get(j+1).equals("1")){
                    x+=speed;
                }
            } else{
                if (Greenfoot.isKeyDown("left") && j > 0 && x > 0){
                    if(scenario.get(i).get(j-1).equals("1")){
                        x-=speed;
                    }
                } else { 
                    if (Greenfoot.isKeyDown("up") && i > 0 & y < 648){
                        if(scenario.get(i-1).get(j).equals("1")){
                            y-=speed;
                        }
                    }else{ 
                        if (Greenfoot.isKeyDown("down") && i < 29 && y > 0){
                            if(scenario.get(i+1).get(j).equals("1")){
                                 y+=speed;
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

    public void changeSpeed(int acceleration){
        speed += acceleration;
    }

    public int getScore(){
        return score;
    }
}
