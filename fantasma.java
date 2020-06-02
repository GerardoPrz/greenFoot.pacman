import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;

/**
 * Write a description of class fantasma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fantasma extends Actor
{
    private Actor player;
    private String nameImage;
    private ArrayList<ArrayList<String>> scenario;
    private boolean placed;
    private boolean crash;
    private int xi, yi, x, y, dirX, dirY;
    private int scared;
    private int dir, lastDir;
    

    /**
     * Act - do whatever the fantasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Fantasma(Actor player, String nameImage, ArrayList<ArrayList<String>> scenario){
        this.player = player;
        setImage(nameImage);
        resize();
        this.nameImage = nameImage;
        this.scenario = scenario;
        placed = false;
        crash = true;
        dirX = 0;
        dirY = -1;
        dir = 0;
        lastDir = dir;
        scared = 0;
    }
    
    public void act() 
    {

        if(!placed){
            if(x <= 477 || x >= 483){
                x += x<=477? 1 : -1;
                setLocation(x, y);
            }else{
                y--;
                setLocation(x, y);
            }
            if(x >= 477 && x <= 483 && y <= 255){
                placed = true;
            }
        }else{
            eatPacman(scared);
            
            movement();
            
        }
    } 
    
    public void eatPacman(int scared){
        Scenario scenario = (Scenario)getWorld();
        if(intersects(player)){
            switch(scared){
                case 0: 
                    scenario.gameOver();
                    break;
                case 1:
                    Player player1 = (Player)player;
                    player1.addScore(30);
                    scenario.refreshScore();
                    scare(0);
                    setLocation(xi, yi);
                    x = xi;
                    y = yi;
                    placed = false;
                    break;
            }
        }
    }

    private void movement(){
            
        int j = (x-175)/20;
        int i = (y-43)/20;
        
        if(crash){
            dir = Greenfoot.getRandomNumber(4);
            
            switch(dir){
                case 0:
                    dirX = 0;
                    dirY = -1;
                    break;
                case 1:
                    dirX = 1;
                    dirY = 0;
                    break;
                case 2:
                    dirX = 0;
                    dirY = 1;
                    break;
                case 3:
                    dirX = -1;
                    dirY = 0;
                    break;
            }
            if(lastDir != dir){
                crash = false;  
            }          
        }else{
            crash = true;
            switch(dir){
                case 0:
                    if(i>0 && scenario.get(i+dirY).get(j+dirX).equals("1")){
                        x += dirX;
                        y += dirY;
                        lastDir = dir;
                        setLocation(x, y);
                        crash = false;
                    }
                    break;
                case 1:
                    if(j<30 && scenario.get(i+dirY).get(j+dirX).equals("1")){
                        x += dirX;
                        y += dirY;
                        lastDir = dir;
                        setLocation(x, y);
                        crash = false;
                    }
                    break;
                case 2:
                    if(i<29 && scenario.get(i+dirY).get(j+dirX).equals("1")){
                        x += dirX;
                        y += dirY;
                        lastDir = dir;
                        setLocation(x, y);
                        crash = false;
                    }
                    break;
                case 3:
                    if(j>0 && scenario.get(i+dirY).get(j+dirX).equals("1")){
                        x += dirX;
                        y += dirY;
                        lastDir = dir;
                        setLocation(x, y);
                        crash = false;
                    }
                    break;
            }
        }
    }

    public void scare(int scared){
        this.scared = scared;
        switch(scared){
            case 0: 
                    setImage(nameImage);
                    resize();
                    break;
            case 1:
                    setImage("ScaredGhost.png");
                    resize(); 
                    break;
        }
    }

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 35;
        int newWidth = 35;
        myImage.scale(newHeight, newWidth);
    }

    public void initXY(){
        xi = getX();
        yi = getY();
        x = xi;
        y = yi;
    }
}
