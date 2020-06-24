package novi.java;

public abstract class Game {
    protected Player activePlayer;
    protected int maxRounds;

    public static Input PLAYERINPUT = new Input();

    public Game(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public abstract void play();

    protected void winGame() {
        activePlayer.addScore();
        System.out.println(activePlayer.getName() + " has won!");
    }
}
