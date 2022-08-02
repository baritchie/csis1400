import java.util.Scanner;

public class Castle {
    String userInputCastle = "";
    Scanner castleScnr = new Scanner(System.in);
    Boolean castleEndsession = false;
    private int playerSustainedDamage = 0;
    private int monsterSustainedDamage = 0;
    private int encounterNumber = 0;
    private boolean playerDead = false;
    private boolean castleComplete = false;

    // GETTERS
    public int getMonsterSustainedDamage() {
        return monsterSustainedDamage;
    }

    public int getPlayerSustainedDamage() {
        return playerSustainedDamage;
    }

    public int getEncounterNumber() {
        return encounterNumber;
    }
    public boolean getCastleComplete() {
        return castleComplete;
    }

    // SETTERS
    public void setMonsterSustainedDamage(int monsterSustainedDamage) {
        this.monsterSustainedDamage = monsterSustainedDamage;
    }

    public void setPlayerSustainedDamage(int playerSustainedDamage) {
        this.playerSustainedDamage = playerSustainedDamage;
    }

    public void setEncounterNumber(int newNumber) {
        this.encounterNumber = newNumber;
    }
    public void setCastleComplete(boolean status) {
        this.castleComplete = status;
    }

    public void startHere(Character theChar, int castleEncounterNumber) {
        System.out.println("You arrive at the castle");
        setEncounterNumber(castleEncounterNumber);

        Encounters encounter = new Encounters();
        encounter.setCurrentEncounter(getEncounterNumber());
        encounter.currEncounter(getEncounterNumber());
        System.out.println("Do you fight or retreat");
        userInputCastle = castleScnr.nextLine();

        System.out.println(userInputCastle);
        do {
            switch (userInputCastle.toUpperCase()) {
                case "FIGHT":
                    System.out.println("Time for some action!");
                    controlEncounter(theChar);
                    if (playerDead) {
                        System.out.println("A pity that you are not a good soldier");
                        castleEndsession = true;
                    } else {
                        if(getEncounterNumber() == 5) {
                            setCastleComplete(true);
                            castleEndsession = true;
                            break;
                        }
                        System.out.println("Your health is now: " + theChar.getCharacterHealth());
                        encounter.setCurrentEncounter(getEncounterNumber());
                        encounter.currEncounter(getEncounterNumber());
                        System.out.println("Do you fight or retreat");
                        userInputCastle = castleScnr.nextLine();
                    }

                    break;
                case "RETREAT":
                    System.out.println("You escape with your life, but not your dignity.");
                    castleEndsession = true;
                    break;
                default:
                    System.out.println("Umm, let's try that again: fight or retreat?");
                    userInputCastle = castleScnr.nextLine();
                    break;
            }
        } while (!castleEndsession);

    }

    public void controlEncounter(Character theChar) {
        int damageCalc = 0;
        String turnChecker = "Player";
        int turnCount = 0;
        int encounterNumber = getEncounterNumber();
        boolean hitCheck = false;

        Encounters encounter = new Encounters();
        encounter.setCurrentEncounter(getEncounterNumber());

        do {
            //System.out.println("checkin: " + turnChecker);
            switch (turnChecker) {
                case "Player":
                    System.out.println();
                   // System.out.println("before attack: " + encounter.getEncounterHealthPoints());

                    //System.out.println();
                    
                    if (theChar.weapon == "") {
                        System.out.println(
                                "You use your bare fists against " + encounter.getEncounterName());
                    } else if (turnCount % 2 == 0) {
                        System.out.println(
                                "You use your " + theChar.weapon + " against " + encounter.getEncounterName());
                    } else {
                        System.out.println("You use your " + theChar.secWeapon + " against "
                                + encounter.getEncounterName());
                    }
                    hitCheck = theChar.characterAttackMisses();

                    if (hitCheck) {
                        damageCalc = theChar.characterAttacks();
                        System.out.println("You hit and deal " + damageCalc + " damage!!!");
                        encounter.setEncounterHealthPoints(damageCalc);
                    } else {
                        System.out.println("You totally missed. Be better.");
                    }
                    System.out.println();

                    //System.out.println("after attack: " + encounter.getEncounterHealthPoints());

                    System.out.println();
                    turnChecker = "Monster";
                    turnCount++;
                    if (encounter.getEncounterHealthPoints() <= 0) {
                        turnChecker = "FightOver";
                        System.out.println("Monster Dead");
                        encounterNumber++;
                        setEncounterNumber(encounterNumber);
                        break;
                    }
                    System.out.println("Press enter to continue the fight.");
                    userInputCastle = castleScnr.nextLine();
                    break;
                /*
                 * if (encounter.getEncounterHealthPoints() <= 0) {
                 * System.out.println("You took care of that pest... on to the next one!");
                 * encounterNumber++;
                 * monsterDead = true;
                 * break;
                 * }
                 * turnChecker = "Monster";
                 * turnCount++;
                 * break;
                 */

                case "Monster":
                    System.out.println(encounter.getEncounterName() + " takes a swing at you");
                    hitCheck = encounter.encounterMisses();
                    if (hitCheck) {
                        damageCalc = encounter.calculateRandomDamage(encounter.getEncounterLightDamage(),
                                encounter.getEncounterFullDamage());
                        System.out.println("You get hit and take " + damageCalc + " damage!!!");
                        theChar.takeDamage(damageCalc);
                    } else {
                        System.out.println("Look at you dodging that attack. Good for you!");
                    }
                    turnChecker = "Player";
                    turnCount++;
                    if (theChar.getCharacterHealth() <= 0) {
                        System.out.println("The monsters trample over your lifeless body as they invade further into Castle Rush. Shame that you couldn't stop them.");
                        turnChecker = "FightOver";
                        playerDead = true;
                        break;
                    }
                    break;

            }

        } while (turnChecker != "FightOver");

    }
}
