public class Character {
    String characterName = "";
    int characterHealth = 50;
    String weapon = "";
    String secWeapon = "";
    int special;
    String armor = "";
    String[] inventory = new String[9];

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
