import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int min = 1, max = 100, score = 0;

        System.out.println("Number Guessing Game!");
        System.out.println("Guess a number between " + min + " and " + max + ".");

        boolean continuePlaying = true;
        while (continuePlaying) {
            int guess = rand.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                if (scan.hasNextInt()) {
                    int userGuess = scan.nextInt();
                    attempts++;

                    if (userGuess < guess) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > guess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You've guessed the number.");
                        System.out.println("Number of attempts: " + attempts);
                        score += attempts;
                        guessedCorrectly = true;
                    }
                } else {
                    System.out.println("Please enter a valid integer.");
                    scan.next(); // Consume the invalid input
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scan.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                continuePlaying = false;
            }
        }

        System.out.println("Thanks for playing! Your total score is: " + score);
        scan.close();
    }
}
