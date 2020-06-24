package novi.java;

import java.util.Scanner;

public class Input {
    private Scanner consoleInput;

    public Input() {
        consoleInput = new Scanner(System.in);
    }

    public int getValidNumber(int min, int max) {
        boolean success = false;
        int value = -1;

        while(!success) {
            try {
                value = consoleInput.nextInt();
                if(value >= min && value <= max) {
                    success = true;
                } else {
                    System.out.println("Enter a number between " + min + " and " + max);
                }
            } catch (Exception e) {
                System.out.println("That is not a number");
                consoleInput.nextLine();
            }
        }
        return value;
    }

    public String getPlayerName() {
        return consoleInput.next();
    }
}
