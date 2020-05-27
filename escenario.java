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
public class escenario extends World
{
    World mainScreen;
    ArrayList<ArrayList<String>> scenario = new ArrayList<ArrayList<String>>();
    fantasma fantasma;
    fantasma fantasma1;
    fantasma fantasma2;
    fantasma fantasma3;


    /**
     * Constructor for objects of class escenario.
     * 
     */
    public escenario(World mainScreen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 720, 1); 
        prepare();
        this.mainScreen = mainScreen;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        readScenario();

        player player = new player(scenario);
        addObject(player,180,48);
        
        fantasma = new fantasma(player,"Pink.png");
        addObject(fantasma, 420, 320);
        
        fantasma1 = new fantasma(player,"Blue.png");
        addObject(fantasma1, 460, 320);
        
        fantasma2 = new fantasma(player,"Red.png");
        addObject(fantasma2, 500, 320);
        
        fantasma3 = new fantasma(player,"Yellow.png");
        addObject(fantasma3, 540, 320);
        
        Clock clock = new Clock(this);

        Cherry cherry = new Cherry(player, this, clock);
        addObject(cherry, 780, 48);

        Snail snail = new Snail(player);
        addObject(snail, 780, 625);

        Chilli chilli = new Chilli(player);
        addObject(chilli, 185, 625);
        
        ReturnButton returnButton = new ReturnButton(mainScreen);
        addObject(returnButton, 70, 600);
        
        PantallaPrincipal.stopMusic();
        Square square = new Square();

        for(int i = 0; i< 30; i++){ 
            for(int j = 0; j < 31; j++){
                addObject(new Square(), 180 + j*20, 48 + i*20);
            }
        }
    }

    public void act(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
            if (Greenfoot.mouseClicked(null)) {
             int x = mouse.getX();
            int y = mouse.getY();
            System.out.println(x + "," + y);
        }

        
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
}
