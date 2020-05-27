import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clock
{
    private long start;
    float totalSeconds;

    public Clock(){
        start = System.currentTimeMillis();
        totalSeconds = 0;
    }
    
    /**
     * Act - do whatever the Clock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        long end = System.currentTimeMillis();
        
        totalSeconds = (end - start) / 1000F;
        float seconds = totalSeconds;
        int minutes = (int)seconds / 60;
        seconds -= minutes * 60;
    }    

    public float getTotalSeconds(){
        return totalSeconds;
    }
}
