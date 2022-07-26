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

    public void Encounter(String encounterName, int encounterLightDamage, int encounterFullDamage, int coinsOnDeath) {
        this.encounterName = encounterName;
        this.encounterLightDamage = encounterLightDamage;
        this.encounterFullDamage = encounterFullDamage;
        this.coinsOnDeath = coinsOnDeath;
    }

    Encounters[] encounter = new Encounters[5];
    encounter[0] = new Encounter("Goblins", 3, 8, 10),
    encounter[1] = new Encounter("a Lich", 5, 10, 15),
    encounter[0] = new Encounter("a band of Knight", 5, 9, 17),
    encounter[0] = new Encounter("a group of the Undead", 2, 6, 10),
    encounter[0] = new Encounter("the Leshy", 8, 15, 25);

    public void currEncounter(int num) {

        Scanner scnr = new Scanner(System.in);
        System.out.println("Oh no! You've run into" + encounter[num]);


        scnr.close();
    }
}
