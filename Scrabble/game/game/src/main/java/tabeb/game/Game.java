package tabeb.game;

public class Game{
    // Max length 2 - Min length 0
    private int[] playersIdList;
    private int maxPlayer = 2;
    private int id;

    public Game() {
        this.id = 1;
    }

    public int[] getPlayersIdList() {
        return playersIdList;
    }

    public void setPlayersIdList(int[] playersIdList) {
        this.playersIdList = playersIdList;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}