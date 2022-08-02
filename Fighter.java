/*
Project: Text Game - Fighter Subclass of Character
Name: Benjamin Rojas-Ritchie
Email: brojasri@bruinmail.slcc.edu
Description: Subclass of Character for the Fighter character type
Course: CSIS-1400
*/
public class Fighter extends Character {
    private String PrimaryWeapons[] = { "Long Sword", "Battle Axe", "Warhammer" };
    private String secondaryWeapons[] = { "Short Sword", "Dagger", "Shield" };
    private String armor[] = { "Chain", "Plate", "Mythril" };

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
        Fighter theChar = new Fighter();

        theChar.weapon = "Short Sword";
        theChar.secWeapon = "Shield";
        theChar.special = 25;
    }
}
