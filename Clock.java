import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clock extends Actor
{
    private long start;
    int totalSeconds;
    Character minutes1; 
    Character minutes2; 
    Character seconds1;
    Character seconds2;

    public Clock(escenario scenario){
        start = System.currentTimeMillis();
        totalSeconds = 0;
        
        minutes1  = new Character(); 
        scenario.addObject(minutes1, 21, 225);
        minutes2  = new Character(); 
        scenario.addObject(minutes2, 48, 225);
        seconds1  = new Character(); 
        scenario.addObject(seconds1, 95, 225);
        seconds2  = new Character(); 
        scenario.addObject(seconds2, 122, 225);
    }
    
    /**
     * Act - do whatever the Clock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        long end = System.currentTimeMillis();
        totalSeconds = (int)((end - start) / 1000F);

        System.out.println(totalSeconds);

        int seconds = totalSeconds;
        int minutes = (int)seconds / 60;
        seconds -= minutes * 60;
        
        minutes2.changeImage(String.valueOf(minutes % 10));
        minutes /= 10;
        minutes1.changeImage(String.valueOf(minutes));
        
        seconds2.changeImage(String.valueOf(seconds % 10));
        seconds /= 10;
        seconds1.changeImage(String.valueOf(seconds));
    }    

    public int getTotalSeconds(){
        return totalSeconds;
    }
}
