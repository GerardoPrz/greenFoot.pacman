import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReturnButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReturnButton extends Actor
{
    private int isNew;

    public ReturnButton(int isNew){
        this.isNew = isNew;
        resize();
    }
    /**
     * Act - do whatever the ReturnButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.playSound("Select.mp3");
            Greenfoot.setWorld(new PantallaPrincipal(isNew));
        }
    }    

    private void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = (int)myImage.getHeight()/3-30;
        int newWidth = (int)myImage.getWidth()/2-70;
        myImage.scale(newWidth, newHeight);
    }
}
