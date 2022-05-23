public class Game{
    // Max length 2 - Min length 0
    private String[Player] playersList;
    private int maxPlayer = 2;
    private int id;
    private;

    public Game() {
        this.playersList = new Player[];
        this.id = 1;
    }

    void getPlayersList(){
        return this.playersList;
    }
    void setPlayersList(Player[] newPlayersList){
        if(newPlayersList.length < maxPlayer){
            this.playersList = newPlayersList;
        }
        return 0;
    }
    void getId(){
        return this.id;
    }
}