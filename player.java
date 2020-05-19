import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
        
            if (Greenfoot.isKeyDown("right")){
                    x++;
            } else{
                if (Greenfoot.isKeyDown("left")){
                        x--;
                } else { 
                    if (Greenfoot.isKeyDown("up")){
                            y--;
                    }else{ 
                        if (Greenfoot.isKeyDown("down")){
                            y++;
                        }
                    } 
                }
            }
             setLocation(x,y);
    }    
}
