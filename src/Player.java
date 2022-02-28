import java.util.Objects;

public class Player {

    private String name;
    private int playerScore;
    private int CORRECTANSWERS;

    public Player(String name) {
        this.name = name;
        this.playerScore= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (playerScore != player.playerScore) return false;
        if (CORRECTANSWERS != player.CORRECTANSWERS) return false;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + playerScore;
        result = 31 * result + CORRECTANSWERS;
        return result;
    }
}
