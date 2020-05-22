import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class PantallaPrincipal extends World
{
    private int playSound;
    private static GreenfootSound sound = new GreenfootSound("PAC-MAN theme.mp3");

    /**
     * Constructor for objects of class PantallaPrincipal.
     */
    public PantallaPrincipal()
    {
        super(600, 400, 1);
        prepare();
        playSound = 0;
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        PacMan pacMan = new PacMan();
        addObject(pacMan,123,313);
        pacMan.setLocation(57,342);
        Logo logo = new Logo();
        addObject(logo,315,245);
        logo.setLocation(315,245);
        logo.setRotation(-5);

        PlayButton playButton = new PlayButton(); 
        addObject(playButton,120,350);
        HelpButton helpButton = new HelpButton();
        addObject(helpButton,245,350);
        RecordsButton recordsButton = new RecordsButton();
        addObject(recordsButton,375,350);
        ExitButton exitButton = new ExitButton();
        addObject(exitButton,500,350);
    }

    public void act(){
        if(playSound == 0){
        playSound = playMusic();

        
    }
    }

    public int playMusic(){
        int wasPlayed = 0;
        if(playSound == 0){
            sound.play();
            wasPlayed = 1;
        }
        return wasPlayed;
    }

    public static void stopMusic(){
        sound.stop();
    }
}
