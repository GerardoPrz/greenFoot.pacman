import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SaveButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveButton extends Actor
{
    RecordsManager recordsManager;
    Line line;

    public SaveButton(Line line){
        recordsManager = new RecordsManager();
        this.line = line;
        resize();
    }    

    /**
     * Act - do whatever the SaveButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            GameRecord record = new GameRecord(line.getScore(), line.getName());
            recordsManager.sort(record);
            recordsManager.imprimir();
            recordsManager.writeOnFile();
            Greenfoot.setWorld(new PantallaPrincipal());
        }
    }   

    public void resize(){
        GreenfootImage myImage = getImage();
        int newHeight = 50;
        int newWidth = 100;
        myImage.scale(newWidth, newHeight);
    }     
}
