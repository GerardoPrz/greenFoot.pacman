import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Logo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Logo extends Actor
{
    int lightsIn;

    public Logo(){
        resize();
        lightsIn = 0;
    }
    
    /**
     * Act - do whatever the Logo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(lightsIn == 0){
            lightsIn = turnOn();
        }
    }    

    public int turnOn(){
        int turn=1;
                
        Greenfoot.playSound("Neon Logo.mp3");
        
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        
        setImage("1585603796585.png");
        resize();
        
        return turn;
    }

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = (int)myImage.getHeight()*5/3+70;
        int newWidth = (int)myImage.getWidth()/2;
        myImage.scale(newHeight, newWidth);
    }
}
