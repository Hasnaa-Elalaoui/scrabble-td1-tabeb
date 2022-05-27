public class Player{
    private String name;
    private int id;

    public Player() {
        this.name = "Thomas";
        this.id = 1;
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
}