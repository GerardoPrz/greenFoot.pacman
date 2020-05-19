import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpScreen extends World
{

    /**
     * Constructor for objects of class HelpScreen.
     * 
     */
    public HelpScreen(World mainScreen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 370, 1); 
        
        ReturnButton returnButton = new ReturnButton(mainScreen);
        addObject(returnButton, 100, 330);
    }

    public void act(){
        
    }
}
