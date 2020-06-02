import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chilli here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chilli extends Actor
{
    private Player player;
 
    public Chilli(Player player){
        this.player = player;
        resize();
    }
    
    /**
     * Act - do whatever the Chilli wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(intersects(player)){
            player.changeSpeed(1);  
            player.addScore(10);
            Scenario scenario = (Scenario)getWorld();
            scenario.refreshScore();
            Greenfoot.playSound("Chilli.mp3");
            getWorld().removeObject(this);
        }
    }  

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 35;
        int newWidth = 35;
        myImage.scale(newHeight, newWidth);
    }  
}
