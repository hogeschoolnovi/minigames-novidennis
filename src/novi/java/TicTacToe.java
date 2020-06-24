package novi.java;

public class TicTacToe extends Game {

    private Player player1;
    private Player player2;

    private Field[] board;
    private int drawCount;

    public TicTacToe(Player player1, Player player2) {
        super(player1);
        board = new Field[9];

        // maximale aantal rondes opslaan
        maxRounds = board.length;

        this.player1 = player1;
        this.player2 = player2;

        drawCount = 0;
        activePlayer = player1;
    }

    public void resetBoard() {
        char fieldNumber = '1';
        for (int fieldIndex = 0; fieldIndex < 9; fieldIndex++) {
            board[fieldIndex] = new Field(fieldNumber);
            fieldNumber++;
        }
    }

    @Override
    public void play() {
        resetBoard();

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        int round = 1;
        while(round <= maxRounds) {

            String activePlayerName = activePlayer.getName();
            System.out.println(activePlayerName + ", please choose a field");

            int chosenField = PLAYERINPUT.getValidNumber(1, 9);
            int chosenIndex = chosenField - 1;

            if (setField(chosenIndex)) {

                printBoard();

                if (isGameWon()) {
                    winGame();
                    break;
                } else if (isLastRound(round)) {
                    drawGame();
                }

                changePlayer();
                round++;
            }
        }
    }

    public void changePlayer() {
        if(activePlayer == player1) {
            activePlayer = player2;
        } else {
            activePlayer = player1;
        }
    }

    public boolean setField(int chosenIndex) {
        boolean result = false;

        //als het veld leeg is, wanneer er geen token staat
        if (board[chosenIndex].isEmpty()) {
            // wanneer de speler een token op het bord kan plaatsen
            char token = activePlayer.getToken();
            board[chosenIndex].setValue(token);
            result = true;
        } else {
            System.out.println("this field is not available, choose another");
        }
        return result;
    }

    public void printBoard() {
        for (int fieldIndex = 0; fieldIndex < board.length; fieldIndex++) {
            System.out.print(board[fieldIndex].getValue() + " ");
            // als we het tweede veld geprint hebben of het vijfde veld geprint hebben
            // dan gaan we naar de volgende regel
            if(fieldIndex == 2 || fieldIndex == 5) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public boolean isGameWon() {
        int[][] winconditions = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };

        for (int[] wincondition: winconditions) {
            if( board[wincondition[0]].getValue() == board[wincondition[1]].getValue() &&
                    board[wincondition[1]].getValue() == board[wincondition[2]].getValue()) {
                return true;
            }
        }
        return false;
    }


    public boolean isLastRound(int round) {
        return round == maxRounds;
    }

    public void drawGame() {
        drawCount++;
        System.out.println("It's a draw!");
        System.out.println("That is draw number: " + drawCount);
    }

    @Override
    public void winGame() {
        super.winGame();
        System.out.println("Score " + player1.getName() + ": " + player1.getScore());
        System.out.println("Score " + player2.getName() + ": " + player2.getScore());
    }
}
