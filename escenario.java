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
        super(900, 720, 1); 
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
        PantallaPrincipal.stopMusic();
        Square square = new Square();
        
        //addObject(square, 175, 40);

        for(int i = 0; i< 30; i++){ 
            for(int j = 0; j < 31; j++){
                addObject(new Square(), 180 + j*20, 48 + i*20);
            }
        }
    }

    public void act(){
        /*MouseInfo mouse = Greenfoot.getMouseInfo();
            if (Greenfoot.mouseClicked(null)) {
             int x = mouse.getX();
            int y = mouse.getY();
            System.out.println(x + "," + y);
        }*/

        
    }
}
