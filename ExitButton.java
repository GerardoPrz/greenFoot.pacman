    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
    * Write a description of class ExitButton here.
    * 
    * @author (your name) 
    * @version (a version number or a date)
    */
    public class ExitButton extends Actor implements Button
    {
    int appeared;
    
    public ExitButton(){
        resize();
        appeared = 0;
    }
        
    public int appear(){
        setImage("ExitButton.png");
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
        }
    }    


    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = (int)myImage.getHeight()/1+10;
        int newWidth = (int)myImage.getWidth()/4-30;
        myImage.scale(newHeight, newWidth);
    }
}
