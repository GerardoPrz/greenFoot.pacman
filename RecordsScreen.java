import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class RecordsScreen extends World
{
    private RecordsManager recordsManager = new RecordsManager();
    
    
    /**
     * Constructor for objects of class RecordsScreen.
     * 
     */
    public RecordsScreen(World mainScreen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        ReturnButton returnButton = new ReturnButton(mainScreen);
        addObject(returnButton, 100, 330);
    }
}
