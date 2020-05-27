import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RecordsLogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecordsLogo extends Actor
{
    public RecordsLogo(){
        resize();
    }
        
    /**
     * Act - do whatever the RecordsLogo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 80;
        int newWidth = 160;
        myImage.scale(newWidth ,newHeight);
    }  
}
