import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String name;
        String[] classes = new String[]{"Archer", "Fighter", "Mage"};
        String chosenClass;

        System.out.println("Welcome to [GAME TITLE]! Please enter the your name:");
        name = scnr.nextLine();
        System.out.println("Hi " + name + "! Ready for the adventure? Please pick your character class.");
        System.out.println("Your options are:");
        for (String s : classes) {
            System.out.println(s);
        }
        System.out.println("Please type the character class you’d like to play: ");
        chosenClass = scnr.nextLine();
        while (!Arrays.asList(classes).contains(chosenClass)) {
            System.out.println("That is not a valid class.");
            System.out.println("Your options are:");
            for (String s : classes) {
                System.out.println(s);
            }
            System.out.println("Please type the character class you’d like to play: ");
            chosenClass = scnr.nextLine();
        }
        System.out.println("You chose " + chosenClass + "! A fine choice!");
        Character theChar = new Character();
        switch (chosenClass) {
            case "Archer":
                theChar = new Archer();
            case "Fighter":
                theChar = new Fighter();
            case "Mage":
                theChar = new Mage();
        }
        System.out.println("The kingdom of [kingdomName] is in the middle of a war with [enemyKingdom]. You’ve been instructed to go to the castle to fight an invading enemy force. You’re in the forest, headed towards the castle on the hill. You come across a fork in the road. On the LEFT, the path becomes obscured with overgrown plants and the trees seem to be more densely packed. On the RIGHT, the path is clear, but there’s clear prints - a group of people on horseback have been through here. Which path do you choose: RIGHT or LEFT?");
    }
}