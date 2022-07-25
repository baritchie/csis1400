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

    // Need to add way to add/remove from inventory

    public int takeDamage(int damage) {
        return characterHealth - damage;
    }

    public String inputName(String name) {
        return characterName = name;
    }

    public int heal (int hitPoints) {
        return characterHealth + hitPoints;
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
            System.out.println(i + inventory[i]);
        }
        return scnr.nextInt();
    }

    public String[] modifyInventory (String add) {
        String[] newInventory = new String[9];
        if (checkInventorySpace()) {
            for (int i = 0; i < inventory.length; ++i) {
                if (inventory[i] == null) {
                    inventory[i] = add;
                    break;
                }
                else {
                    newInventory[i] = inventory[i];
                }
            }
        }
        else {
            int index = removeFromInventory();
            inventory[index] = add;
        }
        return newInventory;
    }
}

class Archer extends Character {
    public int shootBow() {
        int min = 1;
        int max = 10;
        return (int) (Math.random()*(max-min)) + min;
    }
    public static void main(String[] args) {
        Archer theChar = new Archer();

        theChar.weapon = "Bow";
        theChar.secWeapon = "Arrows";
        theChar.special = 10;
    }
}

class Fighter extends Character {
    public int slash() {
        int min = 1;
        int max = 10;
        return (int) (Math.random()*(max-min)) + min;
    }
    public static void main(String[] args) {
        Fighter theChar = new Fighter();

        theChar.weapon = "Short Sword";
        theChar.secWeapon = "Shield";
        theChar.special = 25;
    }
}

class Mage extends Character {
    public int cast() {
        int min = 1;
        int max = 10;
        return (int) (Math.random()*(max-min)) + min;
    }
    public static void main(String[] args) {
        Mage theChar = new Mage();

        theChar.weapon = "Staff";
        theChar.secWeapon = "Spell-book";
        theChar.special = 10;
    }
}
