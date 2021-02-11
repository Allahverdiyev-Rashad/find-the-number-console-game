import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int guess, health = 5,
                i = 0;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int number = rand.nextInt(100);
        boolean status = false,
                err = false;
        int[] guesses = new int[5];

        System.out.println(Color.GREEN + "Welcome to the game !\n" + Color.BLUE +
                "I kept a number between 0 and 99" + Color.RESET);
        while (health > 0) {
            System.out.print(Color.PURPLE + "Your guess : " + Color.RESET);
            guess = scan.nextInt();
            if ((guess < 0) || (guess > 99)) {
                if (err) {
                    System.out.println(Color.RED + "You entered 2 times unacceptable number and You lost 1 health\n" +
                            "Current health : " + Color.RESET + --health);
                } else {
                    err = true;
                }
                System.out.println(Color.RED + "Please enter a number between 0 and 99 : " + Color.RESET);
                continue;
            }
            guesses[i++] = guess;
            if (health > 1) {
                if (guess == number) {
                    status = true;
                    break;
                } else if (guess > number) {
                    System.out.println(Color.CYAN + "False, please try again ! Health : " + --health + Color.RESET);
                    System.out.println("DOWN");
                } else {
                    System.out.println(Color.CYAN + "False, please try again ! Health : "  + --health + Color.RESET);
                    System.out.println("UP");
                }
            } else {
                if (guess == number) {
                    status = true;
                    break;
                } else if (guess > number) {
                    System.out.println(Color.CYAN + "Your health is : " + --health + Color.RESET);
                } else {
                    System.out.println(Color.CYAN + "Your health is : "  + --health + Color.RESET);
                }
            }

        }
        if (status) {
            System.out.println(Color.GREEN + "Congratulations! " + Color.BLUE + "Your guess is true\n" +
                    "The number is : " + number +
                    "\nHealth : " + health + Color.RESET);
        } else {
            System.out.println(Color.RED + "You failed !" + Color.RESET);
        }
        System.out.print(Color.PURPLE + "Your guesses : " + Color.RESET);

        for (int j = 0; j < guesses.length; j++) {
            if (guesses[j] != 0 && j < guesses.length - 1) {
                System.out.print(Color.YELLOW + guesses[j] + "-" + Color.RESET);
            } else {
                System.out.print(Color.YELLOW + guesses[j] + Color.RESET);
            }
        }
    }
}
