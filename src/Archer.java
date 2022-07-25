public class Archer extends Character {
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
