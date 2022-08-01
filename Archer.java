/*
Project: Text Game - Archer Subclass of Character
Name: Benjamin Rojas-Ritchie
Email: brojasri@bruinmail.slcc.edu
Description: Subclass of Character for the Archer character type
Course: CSIS-1400
*/
public class Archer extends Character {
    private String PrimaryWeapons[] = { "Long Bow", "Short Bow", "CrossBow" };
    private String secondaryWeapons[] = { "Short Sword", "Dagger", "Throwing Knives" };
    private String armor[] = { "Hide", "Leather", "Cloak" };

    // Getters for inventory options
    public String[] getArmor() {
        return armor;
    }

    public String[] getPrimaryWeapons() {
        return PrimaryWeapons;
    }

    public String[] getSecondaryWeapons() {
        return secondaryWeapons;
    }

    public int attack() {
        int min = 1;
        int max = 10;
        return (int) (Math.random() * (max - min)) + min;
    }

    public static void main(String[] args) {
        Archer theChar = new Archer();

        theChar.weapon = "Bow";
        theChar.secWeapon = "Arrows";
        theChar.special = 10;
    }
}
