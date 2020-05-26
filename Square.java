import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Actor
{
    public Square(){
        resize();
    }    
    
    /**
     * Act - do whatever the Square wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
        
            if (Greenfoot.isKeyDown("d")){
                    x++;
            } else{
                if (Greenfoot.isKeyDown("a")){
                        x--;
                } else { 
                    if (Greenfoot.isKeyDown("w")){
                            y--;
                    }else{ 
                        if (Greenfoot.isKeyDown("s")){
                            y++;
                        }else{      
                            if (Greenfoot.isKeyDown("q")){
                                System.out.println(x + "," + y);
                            }
                        }
                    } 
                }
            }
             setLocation(x,y);
    }    

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 21;
        int newWidth = 21;
        myImage.scale(newHeight, newWidth);
    }
}
