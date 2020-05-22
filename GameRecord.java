import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class GameRecord
{
    
    private String playerName;
    private int score;

    public GameRecord(){}

    public GameRecord(int score, String playerName){
        this.playerName = playerName;
        this.score = score;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
