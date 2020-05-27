import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpButton extends Actor
{
    int appeared;
    
    public HelpButton(){
        resize();
        appeared = 0;
    }
        
    public int appear(){
        setImage("HelpButton.png");
        resize();
        return 1;
    }    

    /**
     * Act - do whatever the ExitButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(appeared == 0){
           appeared = appear();
       }
       if(Greenfoot.mouseClicked(this)){
            Greenfoot.playSound("Select.mp3");
            Greenfoot.setWorld(new HelpScreen(getWorld()));
        }
    }    


    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = (int)myImage.getHeight()/1+10;
        int newWidth = (int)myImage.getWidth()/4-30;
        myImage.scale(newHeight, newWidth);
    }
}
