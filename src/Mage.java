/*
Project: Text Game - Mage Subclass of Character
Name: Benjamin Rojas-Ritchie
Email: brojasri@bruinmail.slcc.edu
Description: Subclass of Character for the Mage character type
Course: CSIS-1400
*/
public class Mage extends Character {
    private String PrimaryWeapons[] = { "Fire Staff", "Ice Staff", "Staff of the Undead" };
    private String secondaryWeapons[] = { "Flaming Sword", "Animated Dead", "Ice Knife" };
    private String armor[] = { "Cloth Robe", "Hide", "Cloak" };

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
        Mage theChar = new Mage();

        theChar.weapon = "Staff";
        theChar.secWeapon = "Spell-book";
        theChar.special = 10;
    }
}
