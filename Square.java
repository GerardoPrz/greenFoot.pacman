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
    }    

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 21;
        int newWidth = 21;
        myImage.scale(newHeight, newWidth);
    }
}
