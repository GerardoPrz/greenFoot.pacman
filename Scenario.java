import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;

/**
 * Write a description of class escenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario extends World
{
    ArrayList<ArrayList<String>> scenario = new ArrayList<ArrayList<String>>();
    Player player;    
    Fantasma fantasma;
    Fantasma fantasma1;
    Fantasma fantasma2;
    Fantasma fantasma3;
    Clock clock;
    RecordsManager recordsManager;
    public static GreenfootSound sound = new GreenfootSound("Music.mp3");
     private int playSound;
    private Character score1;
    private Character score2;
    private Character score3;
    private Character score4;
    private String[] targetsMap={
    "1,1,1,1,1,1,1,1,1,1,1,1,1,1,,,,,,,,,,, 1,1,1,1,1,1,1,1,1,1,1,1",
    "1,0,0,0,0,0,1,0,0,0,0,0,0,1,,,,,,,,,,, 1,0,0,0,0,0,0,1,0,0,0,1",
    "1,0,0,0,0,0,1,0,0,0,0,0,0,1,,,,,,,,,,, 1,0,0,0,0,0,0,1,0,0,0,1",
    "1,0,0,0,0,0,1,0,0,0,0,0,0,1,,,,,,,,,,, 1,0,0,0,0,0,0,1,0,0,0,1",
    "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1",
    "1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1",
    "1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1",
    "1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1",
    "0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0",
    "0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0",
    "0,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0",
    "0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0",
    "0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0",
    "1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1",
    "1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1",
    "0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0",
    "0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0",
    "0,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0",
    "0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0",
    "0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0",
    "1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1",
    "1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1",
    "1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1",
    "1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1",
    "0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0",
    "0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0",
    "1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1",
    "1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1",
    "1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1",
    "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1",
    
    };


    /**
     * Constructor for objects of class escenario.
     * 
     */
    public Scenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 720, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        readScenario();

        player = new Player(scenario);
        addObject(player,180,48);
        
        fantasma = new Fantasma(player,"Pink.png", scenario);
        addObject(fantasma, 420, 320);
        fantasma.initXY();
        
        fantasma1 = new Fantasma(player,"Blue.png", scenario);
        addObject(fantasma1, 460, 320);
        fantasma1.initXY();
        
        fantasma2 = new Fantasma(player,"Red.png", scenario);
        addObject(fantasma2, 500, 320);
        fantasma2.initXY();
        
        fantasma3 = new Fantasma(player,"Yellow.png", scenario);
        addObject(fantasma3, 540, 320);
        fantasma3.initXY();
        
        clock = new Clock(this);

        Cherry cherry = new Cherry(player, this, clock);
        addObject(cherry, 780, 48);

        Snail snail = new Snail(player);
        addObject(snail, 780, 625);

        Chilli chilli = new Chilli(player);
        addObject(chilli, 185, 625);
        
        ReturnButton returnButton = new ReturnButton(1);
        addObject(returnButton, 70, 600);
        
        PantallaPrincipal.stopMusic();

        recordsManager = new RecordsManager();

        score1 = new Character();
        addObject(score1 , 35, 470);
        score2 = new Character();
        addObject(score2 , 62, 470);
        score3 = new Character();
        addObject(score3 , 89, 470);
        score4 = new Character();
        addObject(score4 , 116, 470);

        dibujaEscenario();
    }

    public void act(){
        if(playSound == 0)
            playSound = playMusic();        

        /*MouseInfo mouse = Greenfoot.getMouseInfo();
            if (Greenfoot.mouseClicked(null)) {
             int x = mouse.getX();
            int y = mouse.getY();
            System.out.println(x + "," + y);
            }*/
        
        clock.time();
    }

    public void readScenario(){
        try {
           List<String> lines = Files.readAllLines(Paths.get("scenario.csv"));
           Iterator<String> linesIterator = lines.iterator();

           while (linesIterator.hasNext()) {
               String csvLine = linesIterator.next();
               ArrayList<String> xArray = new ArrayList<String>();
               
               String[] line = csvLine.split(",", 31);

               for(int j = 0; j < 31; j++){
                    xArray.add(line[j]);
                }

               scenario.add(xArray);
           }
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        //imprimir();
    }
    
    public void imprimir(){
        
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 31; j++){    
                System.out.print(scenario.get(i).get(j));
            }
            System.out.print("\n");
        }
    }

    public void eatGhost(int scared){
        fantasma.scare(scared);
        fantasma1.scare(scared);
        fantasma2.scare(scared);
        fantasma3.scare(scared);
    }

    public void gameOver(){
        sound.stop();
        Greenfoot.playSound("GameOver.mp3");
        Greenfoot.setWorld(new SaveScreen(player.getScore()));
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

    public void refreshScore(){
        int score = player.getScore();

        score4.changeImage(String.valueOf(score % 10));
        score /= 10;
        score3.changeImage(String.valueOf(score % 10));
        score /= 10;
        score2.changeImage(String.valueOf(score % 10));
        score /= 10;
        score1.changeImage(String.valueOf(score));
    }    
    
    public void dibujaEscenario(){
           
           for(int i = 0; i<targetsMap.length; i++){
               String mapline = targetsMap[i];
               for(int j = 0; j < mapline.length(); j++){
                   char mapchar = mapline.charAt(j);
                   
                   int y = (i*20)+48;
                   int x = (j*10)+180;
                   
                   switch(mapchar){
                       case '1' : 
                                    addObject(new Punto(player),x,y);
                                    break;
                                    
                       default:
                                     break;
                                    
                    }
                }
            }
        
        
        }
}
