import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordsScreen extends World
{
    private RecordsManager recordsManager;
    ArrayList<ArrayList<Character>> billboard;
    
    /**
     * Constructor for objects of class RecordsScreen.
     * 
     */
    public RecordsScreen(World mainScreen)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        ReturnButton returnButton = new ReturnButton(mainScreen);
        addObject(returnButton, 100, 330);
        recordsManager = new RecordsManager();

      billboard = new ArrayList<ArrayList<Character>>();
      printBillboard();
    }

    public void printBillboard(){
        initBillboard();
        
        int score;
        int digit;
        
        List<GameRecord> records = recordsManager.getList();
        
        Iterator recordsIterator = records.iterator();
        Iterator charactersListIterator = billboard.iterator();
    
        while(recordsIterator.hasNext() == true && charactersListIterator.hasNext() == true){
            ArrayList<Character> characters = (ArrayList<Character>)charactersListIterator.next();
            Iterator characterIterator = characters.iterator();
            GameRecord record = (GameRecord)recordsIterator.next();            
            
            score = record.getScore() / 10;
            for(int counter = 0; counter < 4; counter ++){
                digit = score % 10;
                score /= 10;
                Character character = (Character)characterIterator.next(); 
                character.changeImage(String.valueOf(digit));
            }

            String name = record.getPlayerName();
            for(int counter = 0; counter < name.length(); counter ++){
                Character character = (Character)characterIterator.next(); 
                character.changeImage(String.valueOf(name.charAt(counter)));
            }       
        }
        
        
    }

    private void initBillboard(){
        int i = 0;
        int j;
        int x, y = 110;
        
        i = 0;
        while(i < 5){
            x = 200;
            ArrayList<Character> characters = new ArrayList<Character>();
            j = 0;
            while(j < 4){
                Character character = new Character();
                addObject(character, x, y);
                characters.add(character);
                x+=30;
                j++;
            }
            x+=30;
            j = 0;
            while(j < 5){
                Character character = new Character();
                addObject(character, x, y);
                characters.add(character);
                x+=30;
                j++;
            }
            y+=50;
            i++;

            billboard.add(characters);
        }
    }
}
