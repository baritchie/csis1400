// Project: Text Adventure Game - Encounters Class
// Authors: Zachary Royer
// Description: This class allows the story teller in 'Game.java' to select different encounters for the character to run through.
// Course: CSIS-1400

import java.util.Random;
//import java.util.Arrays;

// Takes num corresponding to desired encounter
public class Encounters {
    private String encounterName;
    private int encounterLightDamage;
    private int encounterFullDamage;
    private int encounterHealthPoints;
    private int coinsOnDeath;

    Random rand = new Random();

    // Default Constructor
    public Encounters() {
    }

    // Encounters constructor
    Encounters(String encounterName, int encounterLightDamage, int encounterFullDamage, int encounterHealthPoints,
            int coinsOnDeath) {
        this.encounterName = encounterName;
        this.encounterLightDamage = encounterLightDamage;
        this.encounterFullDamage = encounterFullDamage;
        this.encounterHealthPoints = encounterHealthPoints;
        this.coinsOnDeath = coinsOnDeath;
    }

    public void setCurrentEncounter(int encounterNumber) {
        Encounters[] encounter = setEncounters();
        encounterName = encounter[encounterNumber].encounterName;
        encounterLightDamage = encounter[encounterNumber].encounterLightDamage;
        encounterFullDamage = encounter[encounterNumber].encounterFullDamage;
        encounterHealthPoints = encounter[encounterNumber].encounterHealthPoints;
        coinsOnDeath = encounter[encounterNumber].coinsOnDeath;
    }

    public String getEncounterName() {
        return this.encounterName;
    }

    public int getEncounterLightDamage() {
        return this.encounterLightDamage;
    }

    public int getEncounterFullDamage() {
        return this.encounterFullDamage;
    }

    public int getEncounterHealthPoints() {
        return this.encounterHealthPoints;
    }

    public int getCoinsOnDeath() {
        return this.coinsOnDeath;
    }

    // Method creates an Object array detailing encounter information
    public Encounters[] setEncounters() {
        Encounters[] encounter = new Encounters[5];
        encounter[0] = new Encounters("Goblins", 2, 8, 10, 10);
        encounter[1] = new Encounters("a Lich", 5, 10, 15, 15);
        encounter[2] = new Encounters("a band of Knight", 5, 9, 20, 17);
        encounter[3] = new Encounters("a group of the Undead", 2, 6, 25, 10);
        encounter[4] = new Encounters("the Leshy", 8, 15, 30, 25);
        return encounter;
    }

    // Main method, will compare character class from Game.java through different
    // enemy encounters.
    public void currEncounter(int num) {
        Encounters[] encounter = setEncounters();
        System.out.println("Oh no! You've run into " + encounter[num].encounterName + "!");
    }

    public void setEncounterHealthPoints(int damage) {
        this.encounterHealthPoints = getEncounterHealthPoints() - damage;
    }

    public int calculateRandomDamage(int min, int max) {
        int damage = (int) (Math.random() * (max - min + 1) + min);
        return damage;
    }

    public boolean encounterMisses() {
        int missed = (int) (Math.random() * (50 - 5 + 1) + 5);
        if (missed % 2 == 0) {
            return true;
        }
        return false;
    }
}
