/*
Project: Text Game - Mage Subclass of Character
Name: Benjamin Rojas-Ritchie
Email: brojasri@bruinmail.slcc.edu
Description: Subclass of Character for the Mage character type
Course: CSIS-1400
*/
public class Mage extends Character {
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
