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
    String lastDir = "R";

    public player(ArrayList<ArrayList<String>> scenario){
        this.scenario = scenario;
        resize();
        i = 0;
        j = 0;
        speed = 4;
        score = 0;
    }

    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }    

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 35;
        int newWidth = 35;
        myImage.scale(newHeight, newWidth);
    }

    public void changeSpeed(int acceleration){
        speed += 2*acceleration;
    }

    public int getScore(){
        return score;
    }

    private void changeImage(String lastDir, int image, String upDown){
        
        if(upDown.equals("U") || upDown.equals("D")){
            setImage("PacMan" + lastDir + upDown +String.valueOf(image) + ".png");
        }else{
            setImage("PacMan" + lastDir + String.valueOf(image) + ".png");
        }   
        resize();
    }

    private void movement(){
        int x = getX();
        int y = getY();
            
        j = (x-175)/20;
        i = (y-43)/20;
    
        if (Greenfoot.isKeyDown("right") && j < 30 && x < 800){
            if(scenario.get(i).get(j+1).equals("1")){
                lastDir = "R";
                changeImage(lastDir, 1, ""); 
                Greenfoot.delay(1); 
                x+=speed;
                changeImage(lastDir, 0, ""); 
                
            }else{
                if(scenario.get(i).get(j+1).equals("2")){
                    lastDir = "R";
                    changeImage(lastDir, 1, ""); 
                    Greenfoot.delay(1); 
                    x = 201;
                    changeImage(lastDir, 0, ""); 
                }
            }
        } else{
            if (Greenfoot.isKeyDown("left") && j > 0 && x > 180){
                if(scenario.get(i).get(j-1).equals("1")){
                    lastDir = "L";
                    changeImage(lastDir, 1, "");  
                    Greenfoot.delay(1);    
                    x-=speed;
                    changeImage(lastDir, 0, ""); 
                }else{
                    if(scenario.get(i).get(j-1).equals("2")){
                        lastDir = "L";
                        changeImage(lastDir, 1, ""); 
                        Greenfoot.delay(1); 
                        x = 789;
                        changeImage(lastDir, 0, ""); 
                    }
                }
            } else { 
                if (Greenfoot.isKeyDown("up") && i > 0 & y > 53){
                    if(scenario.get(i-1).get(j).equals("1")){
                        changeImage(lastDir, 1, "U"); 
                        Greenfoot.delay(1); 
                        y-=speed;
                        changeImage(lastDir, 0,"U"); 
                    }
                }else{ 
                    if (Greenfoot.isKeyDown("down") && i < 29 && y < 648 ){
                        if(scenario.get(i+1).get(j).equals("1")){
                            changeImage(lastDir, 1, "D"); 
                            Greenfoot.delay(1); 
                            y+=speed;
                            changeImage(lastDir, 0, "D"); 
                        }
                    }
                } 
            }
        }
        setLocation(x,y);
    }

    public void addScore(int score){
        this.score += score;
    }
}
