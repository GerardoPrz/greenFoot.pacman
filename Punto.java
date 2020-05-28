import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Punto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto extends Actor
{
    private player player;
    /**
     * Act - do whatever the Punto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Punto(player player){
        this.player = player;
        resize();
    }
    
    public void act()
    {
        if(intersects(player)){
            player.addScore(10);
            escenario scenario = (escenario)getWorld();
            scenario.refreshScore();
            getWorld().removeObject(this);
        }
    } 
    

    
    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 10;
        int newWidth = 10;
        myImage.scale(newHeight, newWidth);
    }  
}
