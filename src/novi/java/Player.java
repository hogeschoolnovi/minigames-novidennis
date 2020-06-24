package novi.java;

public class Player {

    private String name;
    private char token;
    private int score;

    public Player(String name, char token) {
        this.name = name;
        this.token = token;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public char getToken() {
        return token;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }

    private static int playerIndex = 1;
    public static Player create(char token) {
        System.out.println("Player " + playerIndex  + ", please enter your name");
        String name = Game.PLAYERINPUT.getPlayerName();
        playerIndex = playerIndex == 1 ? 2 : 1;
        return new Player(name, token);
    }
}
