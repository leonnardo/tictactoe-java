public class Player {
    private String name;
    private Boolean isPlayerTurn;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.isPlayerTurn = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(Boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
