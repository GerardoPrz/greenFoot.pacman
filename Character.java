import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{   
    
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    public void changeImage(String image){
        String imageName = image + ".png";
        setImage(imageName);
    }

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 50;
        int newWidth = 50;
        myImage.scale(newHeight, newWidth);
    }      
}
