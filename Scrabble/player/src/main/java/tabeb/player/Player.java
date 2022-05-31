package tabeb.player;

import org.springframework.stereotype.Component;

@Component
public class Player {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }
}
