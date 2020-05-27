import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class fantasma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fantasma extends Actor
{
    private Actor player;
    String nameImage;

    /**
     * Act - do whatever the fantasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public fantasma(Actor player, String nameImage){
        this.player = player;
        setImage(nameImage);
        resize();
        this.nameImage = nameImage;
    }
    
    public void act() 
    {
        move(4);
        if(Greenfoot.getRandomNumber(100)<30){
            turn(Greenfoot.getRandomNumber(15)-30);
        }    
        eatPacman();
    } 
    
    public void eatPacman(){
        if(intersects(player)){
            getWorld().showText("You lose!",300,200);
            Greenfoot.stop();
        }
    }

    public void scare(int scared){
        if(scared == 1){
            setImage("ScaredGhost.png");
            resize();
        }else{
            setImage(nameImage);
            resize();
        }
    }

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 35;
        int newWidth = 35;
        myImage.scale(newHeight, newWidth);
    }
}
