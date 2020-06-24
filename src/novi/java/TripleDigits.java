package novi.java;

import java.util.Random;

public class TripleDigits extends Game {

    private int safeCodeA;
    private int safeCodeB;
    private int safeCodeC;

    private int safeCodeSum;
    private int safeCodeProduct;

    private Random random = new Random();

    public TripleDigits(Player player) {
        super(player);
        maxRounds = 3;
    }

    @Override
    public void play() {
        int round = 1;
        while (round <= maxRounds) {
            System.out.println("Round: " + round);
            System.out.println("What are the 3 digits of the safe?");

            generateSafeCode(round);

            // Vragen aan de speler om de getallen in te voeren
            System.out.println(activePlayer.getName() + ", please enter the 3 digits now:");

            int playerGuessA = PLAYERINPUT.getValidNumber(1, round);
            int playerGuessB = PLAYERINPUT.getValidNumber(1, round);
            int playerGuessC = PLAYERINPUT.getValidNumber(1, round);

            int playerGuessSum = playerGuessA + playerGuessB + playerGuessC;
            int playerGuessProduct = playerGuessA * playerGuessB * playerGuessC;

            // Als het antwoord goed is
            if (safeCodeSum == playerGuessSum && safeCodeProduct == playerGuessProduct) {
                // Zeggen dat het goed is en de speler gewonnen heeft
                System.out.println("You're so right!");
                round++;
            }
            // Anders
            else {
                // Zeggen dat het fout is en de speler het opnieuw moet proberen
                System.out.println("That's not correct, try again");
            }
        }

        winGame();
        System.out.println("Your score is: " + activePlayer.getScore());
    }

    private void generateSafeCode(int round) {
        safeCodeA = random.nextInt(round) + 1;
        safeCodeB = random.nextInt(round) + 1;
        safeCodeC = random.nextInt(round) + 1;

        // Bereken de som - A + B + C - en het product - A * B * C - van de getallen
        safeCodeSum = safeCodeA + safeCodeB + safeCodeC;
        safeCodeProduct = safeCodeA * safeCodeB * safeCodeC;
        System.out.println(safeCodeA + " " + safeCodeB + " " + safeCodeC);

        // Som en product weergeven
        System.out.println("The sum of the digits is: " + safeCodeSum);
        System.out.println("The product of the digits is: " + safeCodeProduct);
    }
}
