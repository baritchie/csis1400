
/*
Project: Text-Adventure Game
Authors: Marta Osuna-Gallardo, Benjamin Rojas-Ritchie, and Zachary Royer
Description: Text-Adventure Game
Course: CSIS-1400
*/
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        // GAME VARIABLES
        Scanner scnr = new Scanner(System.in);
        Boolean gameEnd = false;
        int encounterNumber = 0;
        String name;
        String userInput = "";
        Character theChar = new Character();
        String[] classes = new String[] { "Archer", "Fighter", "Mage" };
        String chosenClass;

        // GAME START

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
        switch (chosenClass) {
            case "ARCHER":
                theChar = new Archer();
                break;
            case "FIGHTER":
                theChar = new Fighter();
                break;
            case "MAGE":
                theChar = new Mage();
                break;
        }
        ;

        /*
         * System.out.
         * println("The kingdom of [kingdomName] is in the middle of a war with [enemyKingdom]."
         * +
         * "You’ve been instructed to go to the castle to fight an invading enemy force. You’re in the forest, headed towards the castle on the hill. "
         * +
         * "You come across a fork in the road. On the LEFT, the path becomes obscured with overgrown plants and the trees seem to be more densely packed. "
         * +
         * "On the RIGHT, the path is clear, but there’s clear prints - a group of people on horseback have been through here. Which path do you choose: RIGHT or LEFT?"
         * );
         */

        // The initial decision on what the player can decide to do Barracks takes user
        // to an area where they can select their weapons
        // Castle takes them to the castle to start the fights.
        // Object of the game is to defeat all the monsters in the encounters class.
        // Total of 5 fights.

        System.out.println(
                "Choices are Barracks or Castle. You can also surrender and your legacy will be that of a coward.");

        userInput = scnr.nextLine();

        do {
            switch (userInput.toUpperCase()) {
                // TODO: Go to barracks and pick out main weapon and secondary weapon and armor
                case "BARRACKS":
                    Barracks barracks = new Barracks();
                    barracks.startHere(theChar.weapon, theChar.secWeapon, theChar.armor, chosenClass);
                    if (barracks.inventorySet) {
                        theChar.weapon = barracks.getPrimaryWeaponSelection();
                        theChar.secWeapon = barracks.getSecondaryWeaponSelection();
                        theChar.armor = barracks.getArmorSelection();
                        theChar.checkEquipment();
                        System.out.println();
                        System.out.println(
                                "You return from the barracks with your shiny new equipment and face the same fork. Where do you go? Castle or return to the barracks? ");
                    } else {
                        System.out.println();
                        System.out.println(
                                "You wasted your time at the barracks and face the same fork. Where do you go? Castle or return to the barracks? ");
                    }

                    userInput = scnr.nextLine();
                    break;

                // TODO: Go to castle and fight army
                case "CASTLE":
                    Castle castlePath = new Castle();
                    encounterNumber = castlePath.getEncounterNumber();
                    // This starts path for castle
                    castlePath.startHere();
                    if (theChar.characterHealth <= 0) {
                        System.out.println("Game Over");
                        gameEnd = true;
                    } else {
                        System.out.println();
                        encounterNumber = castlePath.getEncounterNumber();
                        System.out.println(
                                "You return from the castle and face the same fork. Where do you go? The Barracks or return to the Castle? ");
                        userInput = scnr.nextLine();
                    }
                    break;
                case "SURRENDER":
                    System.out.println("Farewell coward");
                    gameEnd = true;
                    break;
                default:
                    System.out.println(
                            "As you stand here indecisive the army in the castle gets stronger. So? Barracks, castle, or surrender?");
                    userInput = scnr.nextLine();
                    break;
            }

        } while (!gameEnd);

        scnr.close();
    }
}