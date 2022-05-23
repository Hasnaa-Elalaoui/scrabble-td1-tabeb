public class Player{
    private String name;
    private int id;
    private int score;
    private int scoreTotal;

    public Player() {
        this.name = "Thomas";
        this.id = 1;
        this.score = 0;
        this.scoreTotal = 0;
    }

    void getName(){
        return this.name;
    }
    void setName(String newName){
        this.name = newName;
    }
    void getId(){
        return this.id;
    }
    void getScore(){
        return this.score;
    }
    void getScoreTotal(){
        return this.scoreTotal;
    }



}