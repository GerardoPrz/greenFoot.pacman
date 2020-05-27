import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SaveScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveScreen extends World
{
    Line line;

    /**
     * Constructor for objects of class SaveScreen.
     * 
     */
    public SaveScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        line = new Line(score, this);

        SaveButton saveButton = new SaveButton(line);
        addObject(saveButton, 300, 350);
    }

    public void act(){
        line.act();
    }
}
