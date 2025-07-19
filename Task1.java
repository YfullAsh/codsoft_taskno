import java.util.Random;
import java.util.Scanner;

class Game {
    private int number;
    private int inputNumber;
    private int noOfGuesses;

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public int getNumber() {
        return number;
    }

    public Game() {
        Random rand = new Random();
        this.number = rand.nextInt(100);  // Random number between 0 and 99
    }

    public void takeUserInput() {
        System.out.print("Guess the number: ");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }

    public boolean isCorrectNumber() {
        noOfGuesses++;
        if (inputNumber == number) {
            System.out.println("Correct! You guessed it right.");
            return true;
        } else if (inputNumber < number) {
            System.out.println("Too low");
        } else {
            System.out.println("Too high");
        }
        return false;
    }
}

public class Task1 {
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println(" I'm thinking of a number between 0 and 99.");
        System.out.println(" Can you guess it in limited attempts?");
        System.out.println(" You can play multiple rounds and try to beat your score!");
        System.out.println("===================================\n");


        Scanner sc = new Scanner(System.in);
        int maxAttempts = 5;

        System.out.println("How many rounds would you like to play? ");
        int rounds = sc.nextInt();

        int score = 0;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\n Round " + round + " begins!");
            Game g = new Game();
            boolean isCorrect = false;

            while (!isCorrect && g.getNoOfGuesses() < maxAttempts) {
                g.takeUserInput();
                isCorrect = g.isCorrectNumber();

                if (isCorrect) {
                    System.out.println("You guessed the number in " + g.getNoOfGuesses() + " attempts.");
                    score++;
                } else if (g.getNoOfGuesses() == maxAttempts) {
                    System.out.println("Out of attempts!");
                    System.out.println("The correct number was: " + g.getNumber());
                }
            }
        }

        System.out.println("\n Game Over! You won " + score + " out of " + rounds + " rounds.");
    }
}
