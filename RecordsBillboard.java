import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class RecordsBillboard extends Actor
{
   RecordsManager recordsManager;
    
   public RecordsBillboard(RecordsManager recordsManager){
        this.recordsManager = recordsManager;
        printRecords();
    }
   
    public void act() 
    {
        // Add your action code here.
    }

   public void printRecords(){
        List<GameRecord> records = recordsManager.getList();

        
   }    
}
