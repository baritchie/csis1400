// Project: Text Adventure Game - Encounters Class
// Authors: Zachary Royer
// Description: This class allows the story teller in 'Game.java' to select different encounters for the character to run through.
// Course: CSIS-1400

import java.util.ArrayList;
import java.util.Scanner;

// Takes num corresponding to desired encounter
class Encounters {

    public void Encounter(int num) {

        Scanner scnr = new Scanner(System.in);
        String[] encounterName = new String[] { "Goblins", "a Lich", "A Band of Knights", "the Undead" }; // An Array containing encounter names
        int[] encounterLightDamage = new int[] { 3, 5, 4, 2 }; // An Array containing light damage as a result of making a mistake
        int[] encounterFullDamage = new int[] { 8, 10, 9, 7 }; // An Array containing the full damage as a result of failing the encounter
        System.out.println("Oh no! You've run into" + encounterName[num]);


        scnr.close();
    }
}
