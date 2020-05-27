import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line
{
    private ArrayList<Character> cName = new ArrayList<Character>();
    private ArrayList<String> name = new ArrayList<String>();
    private int score;

    public Line(int score, World saveScreen){
        this.score = score;
        prepare(score, saveScreen);
    }
    
    /**
     * Act - do whatever the Line wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int i = 0;
        String key = Greenfoot.getKey();

        if(key != null){
            if(key.equals("backspace") && name.size() > 0){
                name.remove(name.size()-1);
            }else{
                if(name.size() < 5 && key.equals("backspace") == false){
                    name.add(key);
                }
            }
        }
        

        while(i < name.size()){
            cName.get(i).changeImage(name.get(i));
            i++;
        }
        while(i < 5){
            cName.get(i).changeImage("blank");
            i++;
        }
    }    

    public void prepare(int score, World saveScreen){
        Character score1 = new Character(); 
        Character score2 = new Character();
        Character score3 = new Character();

        score3.changeImage(String.valueOf(score % 10));
        score /= 10;
        score2.changeImage(String.valueOf(score % 10));
        score /= 10;
        score1.changeImage(String.valueOf(score % 10));

        saveScreen.addObject(score1, 350, 175);
        saveScreen.addObject(score2, 385, 175);
        saveScreen.addObject(score3, 420, 175);

        Character name1 = new Character();
        saveScreen.addObject(name1, 350, 265);
        cName.add(name1);
        Character name2 = new Character();
        saveScreen.addObject(name2, 385, 265);
        cName.add(name2);
        Character name3 = new Character();
        saveScreen.addObject(name3, 420, 265);
        cName.add(name3);
        Character name4 = new Character();
        saveScreen.addObject(name4, 455, 265);
        cName.add(name4);
        Character name5 = new Character();
        saveScreen.addObject(name5, 490, 265);
        cName.add(name5);
    }

    public String getName(){
        String finalName = "";
        
        Iterator iterator = name.iterator();

        while(iterator.hasNext()){
            finalName += iterator.next();
            System.out.println(finalName);
        }

        return finalName;
    }

    public int getScore(){
        return score;
    }
}