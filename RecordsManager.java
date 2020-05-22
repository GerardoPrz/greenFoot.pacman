import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class RecordsManager
{
    private File recordsFile;
    private List<GameRecord> inputRecords = new ArrayList<GameRecord>();

    public RecordsManager(){
       recordsFile = new File("records.csv");
       list();
       imprimir();
       writeOnFile();
       System.out.println("2");
    }

    public void list(){

        try {
           List<String> lines = Files.readAllLines(Paths.get("records.csv"));
            int x=0;
           Iterator<String> linesIterator = lines.iterator();

           while (linesIterator.hasNext()) {
               String csvLine = linesIterator.next();
               GameRecord record = new GameRecord();
               
               String[] nameAndScore = csvLine.split(",", 2);

               record.setScore(Integer.parseInt(nameAndScore[0]));
               record.setPlayerName(nameAndScore[1]);
               sort(record);
                x++;
                System.out.println(x);
           }
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeOnFile(){
        int timesWritten = 0;

        Iterator recordsIterator = inputRecords.iterator();
        
        while(recordsIterator.hasNext() && timesWritten < 5){
            GameRecord record = (GameRecord)recordsIterator.next();

            try(FileWriter writer = new FileWriter("records.csv", true)) {
                if(timesWritten < 4) {
                    writer.append(String.valueOf(record.getScore())).append(",").append(record.getPlayerName()).append("\n");
                } else {
                    writer.append(String.valueOf(record.getScore())).append(",").append(record.getPlayerName());
                }
            } catch (IOException e) {
            }
            
            timesWritten++;
        }
        
    }

    public void imprimir(){
        Iterator<GameRecord> iterator = inputRecords.iterator();

        while (iterator.hasNext()) {
            GameRecord record1 = (GameRecord) iterator.next();
            System.out.print(record1.getScore());
            System.out.print(",");
            System.out.println(record1.getPlayerName());
        }
        System.out.println(" 1\n");
    }

    private void sort(GameRecord record){
        if (inputRecords.size() > 0) {
            Iterator<GameRecord> iterator = inputRecords.iterator();
            int counter = -1;

            while (iterator.hasNext()) {
                GameRecord record1 = (GameRecord) iterator.next();
                counter++;

                if (record1.getScore() < record.getScore()) {
                    inputRecords.add(counter, record);
                    break;
                }
            }
            if (iterator.hasNext() == false) {
                inputRecords.add(record);
            }
        } else {
            inputRecords.add(record);
        }
    }
}
