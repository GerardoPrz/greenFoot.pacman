import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class escenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class escenario extends World
{

    /**
     * Constructor for objects of class escenario.
     * 
     */
    public escenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 720, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        player player = new player();
        addObject(player,666,321);
    }
}
