// Project: Text Adventure Game - Encounters Class
// Authors: Zachary Royer
// Description: This class allows the story teller in 'Game.java' to select different encounters for the character to run through.
// Course: CSIS-1400

import java.util.ArrayList;
import java.util.Scanner;

// Takes num corresponding to desired encounter
class Encounters {
    public String encounterName;
    public int encounterLightDamage;
    public int encounterFullDamage;
    public int coinsOnDeath;

    Encounters(String encounterName, int encounterLightDamage, int encounterFullDamage, int coinsOnDeath) {
        this.encounterName = encounterName;
        this.encounterLightDamage = encounterLightDamage;
        this.encounterFullDamage = encounterFullDamage;
        this.coinsOnDeath = coinsOnDeath;
    }

    public static void main(String[] args) {
        Encounters[] encounter = new Encounters[5];
        encounter[0] = new Encounters("Goblins", 3, 8, 10);
        encounter[1] = new Encounters("a Lich", 5, 10, 15);
        encounter[2] = new Encounters("a band of Knight", 5, 9, 17);
        encounter[3] = new Encounters("a group of the Undead", 2, 6, 10);
        encounter[4] = new Encounters("the Leshy", 8, 15, 25);
    }
    public void currEncounter(int num) {

        Scanner scnr = new Scanner(System.in);
        String[] encounterName = new String[] { "Goblins", "a Lich", "A Band of Knights", "the Undead" }; // An Array containing encounter names
        int[] encounterLightDamage = new int[] { 3, 5, 4, 2 }; // An Array containing light damage as a result of making a mistake
        int[] encounterFullDamage = new int[] { 8, 10, 9, 7 }; // An Array containing the full damage as a result of failing the encounter
        System.out.println("Oh no! You've run into" + encounterName[num]);


        scnr.close();
    }
}
