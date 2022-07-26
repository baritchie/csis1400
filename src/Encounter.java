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

    //Encounters constructor
    Encounters(String encounterName, int encounterLightDamage, int encounterFullDamage, int coinsOnDeath) {
        this.encounterName = encounterName;
        this.encounterLightDamage = encounterLightDamage;
        this.encounterFullDamage = encounterFullDamage;
        this.coinsOnDeath = coinsOnDeath;
    }

    // Method creates an Object array detailing encounter information
    public Encounters[] setEncounters() {
        Encounters[] encounter = new Encounters[5];
        encounter[0] = new Encounters("Goblins", 3, 8, 10);
        encounter[1] = new Encounters("a Lich", 5, 10, 15);
        encounter[2] = new Encounters("a band of Knight", 5, 9, 17);
        encounter[3] = new Encounters("a group of the Undead", 2, 6, 10);
        encounter[4] = new Encounters("the Leshy", 8, 15, 25);
        return encounter;
    }

    // Main method, will compare character class from Game.java through different enemy encounters.
    public void currEncounter(int num) {
        Encounters[] encounter = setEncounters();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Oh no! You've run into" + encounter[num]);
        scnr.close();
    }
}
