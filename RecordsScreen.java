import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordsScreen extends World
{
    private RecordsManager recordsManager;
    
    /**
     * Constructor for objects of class RecordsScreen.
     * 
     */
    public RecordsScreen(World mainScreen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        recordsManager = new RecordsManager();
        printBillboard();

        ReturnButton returnButton = new ReturnButton(mainScreen);
        addObject(returnButton, 100, 330);
       
    }

    public void printBillboard(){
        
        int score;
        int digit;
        int x, y = 110;
        
        List<GameRecord> records = recordsManager.getList();
        
        Iterator<GameRecord> recordsIterator = records.iterator();

        Character recordLogo = new Character();
        recordLogo.changeImage("RecordsLogo");
        recordLogo.resize();
        addObject(recordLogo, 100, 180);
    
        while(recordsIterator.hasNext() == true){
            GameRecord record = (GameRecord)recordsIterator.next();            
            x = 230;
            
            String scoreString = String.valueOf(record.getScore());
            for(int counter = 0; counter < scoreString.length(); counter ++){
                Character character = new Character();
                
                character.changeImage(String.valueOf(scoreString.charAt(counter)));
                addObject(character, x, y);
                x+=40;
            }
            x+=45;
            
            String name = record.getPlayerName();
            for(int counter = 0; counter < name.length(); counter ++){
                Character character = new Character();
                character.changeImage(String.valueOf(name.charAt(counter)));
                addObject(character, x, y);
                x+=40;
            }
            y += 50;       
        }
    }
}
