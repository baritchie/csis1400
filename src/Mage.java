public class Mage extends Character {
    public int cast() {
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
