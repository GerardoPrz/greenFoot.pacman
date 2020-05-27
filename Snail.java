import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snail extends Actor
{
    private player player;
 
    public Snail(player player){
        this.player = player;
        resize();
    }

    /**
     * Act - do whatever the Snail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(intersects(player)){
            player.changeSpeed(-1);
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
