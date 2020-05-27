import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class PacMan extends Actor
{
    private GreenfootImage image;
    int changeImage;
    int wasRelocated;
    /**
     * 
     */
    public PacMan()
    {
        GreenfootImage myImage = getImage();
        int newHeight = (int)myImage.getHeight()/2;
        int newWidth = (int)myImage.getWidth()/2;
        myImage.scale(newHeight, newWidth);
        changeImage=1;
        wasRelocated = 0;
    }

    /**
     * Act - do whatever the PacMan0 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
            movement();
            wasRelocated = relocate();
    }

    public void resizeImage(int changeImage ){
        int x=2;
        if(changeImage == 1){
           x=8;
        }
        
        GreenfootImage myImage = getImage();
        int newHeight = (int)myImage.getHeight()/x;
        int newWidth = (int)myImage.getWidth()/x;
        myImage.scale(newHeight, newWidth);
    }

    public void movement(){
        move(20);
        if(changeImage == 0){
            setImage("PacManR0.png");
        }else{
            setImage("PacManR1.png");
        }

        try
        {
            Thread.sleep(200);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        resizeImage(changeImage);
        changeImage= 1 - changeImage;
    }

    public int relocate(){
    int wasRelocated = 0;
        if(isAtEdge()){
            setLocation(57,342);
            wasRelocated = 1;
        }
    return wasRelocated;
    }
}
