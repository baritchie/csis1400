
/*
Project: Text Game - Character Class
Name: Benjamin Rojas-Ritchie
Email: brojasri@bruinmail.slcc.edu
Description: Main character class
Course: CSIS-1400
*/
import java.util.Scanner;

public class Character {
    String characterName = "";
    int characterHealth = 50;
    String weapon = "";
    String secWeapon = "";
    int special;
    String armor = "";
    String[] inventory = new String[9];
    Scanner scnr = new Scanner(System.in);

    public int takeDamage(int damage) {
        return characterHealth - damage;
    }

    public String inputName(String name) {
        return characterName = name;
    }

    public int heal(int hitPoints) {
        return characterHealth + hitPoints;
    }

    public void checkEquipment() {
        if (weapon == "" || secWeapon == "" || armor == "") {
            System.out.println("I am missing equipment. I should go to the Barracks and get ready for battle");
        } else {
            System.out.println("I have " + weapon + " as my primary weapon ");
            System.out.println("I have " + secWeapon + " as my secondary weapon ");
            System.out.println("and " + armor + " as my armor of choice. I'm so ready. ");
        }
    }

    public boolean checkInventorySpace() {
        for (String s : inventory) {
            if (s == null) {
                return true;
            }
        }
        return false;
    }

    public int removeFromInventory() {
        System.out.println("Please choose an item to replace in your inventory:");
        for (int i = 0; i < inventory.length; ++i) {
            System.out.println(i + " - " + inventory[i]);
        }
        return scnr.nextInt();
    }

    public String[] modifyInventory(String add) {
        String[] newInventory = new String[9];
        if (checkInventorySpace()) {
            for (int i = 0; i < inventory.length; ++i) {
                if (inventory[i] == null) {
                    inventory[i] = add;
                    break;
                } else {
                    newInventory[i] = inventory[i];
                }
            }
        } else {
            int index = removeFromInventory();
            inventory[index] = add;
        }
        return newInventory;
    }

    public int characterAttacks() {
        int min;
        int max;
        if (this.weapon != "" && this.secWeapon != "") {
            min = 1;
            max = 7;
        } else {
            min = 1;
            max = 15;
        }
        return (int) (Math.random() * (max - min)) + min;
    }

    public boolean characterAttackMisses() {
        int missed = (int) (Math.random() * (50 - 5 + 1) + 5);
        if (missed % 2 == 0) {
            return true;
        }
        return false;
    }
}
