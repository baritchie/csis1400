import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String name;
        String[] names = new String[]{"Archer","Fighter","Mage"};
        String chosenName;

        System.out.println("Welcome to [GAME TITLE]! Please enter the your name:");
        name = scnr.nextLine();
        System.out.println("Hi " + name + "! Ready for the adventure? Please pick your character class.");
        System.out.println("Your options are:");
        for (String s : names) {
            System.out.println(s);
        }
        System.out.println("Please type the character class you’d like to play: ");
        chosenName = scnr.nextLine();
        while (!Arrays.asList(names).contains(chosenName)) {
            System.out.println("That is not a valid class.");
            System.out.println("Your options are:");
            for (String s : names) {
                System.out.println(s);
            }
            System.out.println("Please type the character class you’d like to play: ");
            chosenName = scnr.nextLine();
        }
    }
}