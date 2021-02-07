import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int guess, health = 5;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int number = rand.nextInt(100);
        boolean status = false;

        System.out.println("Welcome to game !\n" +
                "I kept a number between 0 and 99");
        while (health > 0) {
            System.out.println("Your guess : ");
            guess = scan.nextInt();
            if ((guess < 0) || (guess > 99)) {
                System.out.println("Please enter a number between 0 and 99 :");
                continue;
            }
            if (guess == number) {
                status = true;
                break;
            } else {
                System.out.println("False, please try again ! Health : " + --health);
            }
        }
        if (status) {
            System.out.println("Congratulations! Your guess is true\n" +
                    "The number is : " + number +
                    "\nHealth : " + health);
        } else {
            System.out.println("You failed !");
        }
    }
}
