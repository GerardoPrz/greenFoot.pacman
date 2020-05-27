import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cherry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cherry extends Actor
{
    private player player;
    private escenario scenario;
    private float scaredStart = 0;
    Clock clock;
    int scare;
 
    public Cherry(player player, escenario scenario, Clock clock){
        this.player = player;
        this.scenario = scenario;
        this.clock = clock;
        resize();
        scare = 0;
    }
    
    /**
     * Act - do whatever the Chilli wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(intersects(player) && scare == 0){
            scenario.eatGhost(1);
            scaredStart = clock.getTotalSeconds();
            scare = 1;
        }
        
        if(scare == 1 && clock.getTotalSeconds() - scaredStart >= 15.0){
            scenario.eatGhost(0);
            scenario.removeObject(this);
        }
    }  

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 35;
        int newWidth = 35;
        myImage.scale(newHeight, newWidth);
    }  
}
