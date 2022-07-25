public class Fighter extends Character {
    public int slash() {
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
