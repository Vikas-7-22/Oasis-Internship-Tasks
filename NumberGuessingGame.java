import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int number = rand.nextInt(100) + 1;
        int attempts = 0, guess = 0;

        System.out.println("Guess the number between 1 and 100!");

        while (guess != number) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < number) {
                System.out.println("Too Low!");
            } else if (guess > number) {
                System.out.println("Too High!");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
            }
        }
        sc.close();
    }
}
