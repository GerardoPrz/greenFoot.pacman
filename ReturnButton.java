import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReturnButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReturnButton extends Actor
{
    World mainScreen;
    public ReturnButton(World mainScreen){
        this.mainScreen = mainScreen;
        resize();
    }
    /**
     * Act - do whatever the ReturnButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(mainScreen);
        }
    }    

    private void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = (int)myImage.getHeight()-40;
        int newWidth = (int)myImage.getWidth()/4-30;
        myImage.scale(newHeight, newWidth);
    }
}
