package novi.java;

public class Menu {

    private Player player1;
    private Player player2;

    private Game currentGame;
    private int currentState;

    private int playerIndex = 1;

    public Menu() {
        currentState = 1;
        next();
    }

    public Player createPlayer(char token) {
        System.out.println("Player " + playerIndex  + ", please enter your name");
        String name = Game.PLAYERINPUT.getPlayerName();
        playerIndex = playerIndex == 1 ? 2 : 1;
        if(playerIndex == 1) {
            playerIndex = 2;
        } else {
            playerIndex = 1;
        }
        return new Player(name, token);
    }

    public Game chooseGame() {
        System.out.println("Which game would you like to play?");
        System.out.println("1: Triple Digits");
        System.out.println("2: Tic Tac Toe");

        int chosenGame = Game.PLAYERINPUT.getValidNumber(1, 2);
        if(chosenGame == 1) {
            return new TripleDigits(player1);
        }
        else {
            return new TicTacToe(player1, player2);
        }
    }

    public int resetGameOptions() {
        System.out.println("What do you want to do next?");
        System.out.println("1: Change players");
        System.out.println("2: Switch Players");
        System.out.println("3: Change Game");
        System.out.println("4: Replay Game");
        System.out.println("0: Quit game");

        return Game.PLAYERINPUT.getValidNumber(0, 4);
    }

    public void next() {

        switch (currentState) {
            case 1:
                player1 = createPlayer('X');
                player2 = createPlayer('O');
            case 2:
                Player temp = player1;
                player1 = player2;
                player2 = temp;
            case 3:
                currentGame = chooseGame();
            case 4:
                currentGame.play();
            case 5:
                currentState = resetGameOptions();
                break;
            case 0:
                return;
        }

        next();
    }

    public static void start() {
        Menu menu = new Menu();
        menu.next();
    }
}
