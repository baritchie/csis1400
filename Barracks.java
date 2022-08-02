/*
Project: Text Game - Barracks Class
Name: Marta Osuna-Gallardo
Email: mosunaga@bruinmail.slcc.edu
Description: Barracks Story Class
Course: CSIS-1400
*/

import java.util.Scanner;

public class Barracks {
    private String primaryWeaponSelection;
    private String secondaryWeaponSelection;
    private String armorSelection;
    boolean returnFromBarracks = false;
    boolean inventorySet = false;
    Scanner barracksScnr = new Scanner(System.in);
    String userBarracksInput = "";

    // GETTERS
    // METHODS TO USE IN Game class to retrieve inventory and pass the data to the
    // Character class using theChar.{getMethodBelow}
    public String getArmorSelection() {
        return armorSelection;
    }

    public String getSecondaryWeaponSelection() {
        return secondaryWeaponSelection;
    }

    public String getPrimaryWeaponSelection() {
        return primaryWeaponSelection;
    }

    // SETTERS
    // METHODS USED TO SET VALUES TO THE PRIVATE VARIABLES ESTABLISHED IN THE
    // Barracks class
    public void setArmorSelection(String armorSelection) {
        this.armorSelection = armorSelection;
    }

    public void setPrimaryWeaponSelection(String primaryWeaponSelection) {
        this.primaryWeaponSelection = primaryWeaponSelection;
    }

    public void setSecondaryWeaponSelection(String secondaryWeaponSelection) {
        this.secondaryWeaponSelection = secondaryWeaponSelection;
    }

    public void startHere(String primaryWeapon, String secondaryWeapon, String armor, String characterClass) {
        System.out.println("You arrive at the barracks and enter the armory. You are greeted by the Master-At-Arms.");
        System.out.println();
        if (primaryWeapon == "" || secondaryWeapon == "" || armor == "") {
            System.out.println(" He looks at you, unimpressed and shouts: 'Soldier! How will you fare against the armies of evil without the proper equipment?' ");
        } else {
            System.out.println(
                    "He looks at you and nods, 'Hello soldier. You appear to have all your equipment. Would you like to change anything?' ");
        }

        do {
            switch (userBarracksInput.toUpperCase()) {
                case "CHANGE EQUIPMENT":
                    System.out.println("You respond to the Master-At-Arms:"); 
                    System.out.println("'Sir, I would like to adjust my equipment.'");
                    System.out.println();
                                       
                    setEquipmentItems(characterClass);

                    System.out.println("The master at arms looks you up and down and says");
                    System.out.println("'You're ready for battle. Go slay some monsters for me!'");
                    System.out.println();
                    System.out.println("You depart the barracks and make your way back to the road between the Barracks and Castle.");
                    returnFromBarracks = true;
                    inventorySet = true;
                    break;
                case "LEAVE":
                    System.out.println("You respond to the Master-At-Arms:); 
                    System.out.println("'Sir, I have made a mistake. Sorry for wasting your time.' ");
                    returnFromBarracks = true;
                    break;
                default:
                    System.out.println("'Soldier, stop wasting my time. What do you need?' ");
                    System.out.println("How do you respond to the master at arms? ");
                    System.out.println();
                    System.out.println("Change Equipment or Leave");
                    userBarracksInput = barracksScnr.nextLine();
                    break;
            }
        } while (!returnFromBarracks);

    }

    public void setEquipmentItems(String characterClass) {
        String[] options = new String[3];

        switch (characterClass.toUpperCase()) {
            case "ARCHER":
                Archer archerOptions = new Archer();
                options = archerOptions.getPrimaryWeapons();
                selectPrimaryWeapon(options);
                options = archerOptions.getSecondaryWeapons();
                selectSecondaryWeapon(options);
                options = archerOptions.getArmor();
                selectArmor(options);
                break;
            case "FIGHTER":
                Fighter fighterOptions = new Fighter();
                options = fighterOptions.getPrimaryWeapons();
                selectPrimaryWeapon(options);
                options = fighterOptions.getSecondaryWeapons();
                selectSecondaryWeapon(options);
                options = fighterOptions.getArmor();
                selectArmor(options);
                break;
            case "MAGE":
                Mage mageOptions = new Mage();
                options = mageOptions.getPrimaryWeapons();
                selectPrimaryWeapon(options);
                options = mageOptions.getSecondaryWeapons();
                selectSecondaryWeapon(options);
                options = mageOptions.getArmor();
                selectArmor(options);
                break;
        }
    }

    /**********************************************************************************************************/
    /**************
     * Select Primary Weapon
     *********************************************************************/
    /**********************************************************************************************************/

    public void selectPrimaryWeapon(String options[]) {
        boolean primaryWeaponSelected = false;

        System.out.println("What will your primary weapon be?");
        System.out.println("Options: ");
        System.out.println("-------------------");
        System.out.println("1 - " + options[0]);
        System.out.println("2 - " + options[1]);
        System.out.println("3 - " + options[2]);
        System.out.println();
        userBarracksInput = barracksScnr.nextLine();
        do {
            switch (userBarracksInput) {
                case "1":
                    System.out.println("I choose " + options[0]);
                    setPrimaryWeaponSelection(options[0]);
                    primaryWeaponSelected = true;
                    break;
                case "2":
                    System.out.println("I choose " + options[1]);
                    setPrimaryWeaponSelection(options[1]);
                    primaryWeaponSelected = true;
                    break;
                case "3":
                    System.out.println("I choose " + options[2]);
                    setPrimaryWeaponSelection(options[2]);
                    primaryWeaponSelected = true;
                    break;
                default:
                    System.out.println("The Master-At-Arms rolls his eyes.");
                    System.out.println("'Has all that mead gone to your head? I'll make it easy for you 1, 2 or 3?'");
                    System.out.println();
                    System.out.println("-------------------");
                    System.out.println("1 - " + options[0]);
                    System.out.println("2 - " + options[1]);
                    System.out.println("3 - " + options[2]);
                    System.out.println();
                    userBarracksInput = barracksScnr.nextLine();
                    break;
            }
        } while (!primaryWeaponSelected);
    }

    /**********************************************************************************************************/
    /**************
     * Select Secondary Weapon
     *******************************************************************/
    /**********************************************************************************************************/

    public void selectSecondaryWeapon(String options[]) {
        boolean secondaryWeaponSelected = false;

        System.out.println("'What will your secondary weapon be?'");
        System.out.println("Options: ");
        System.out.println("-------------------");
        System.out.println("1 - " + options[0]);
        System.out.println("2 - " + options[1]);
        System.out.println("3 - " + options[2]);
        System.out.println();
        userBarracksInput = barracksScnr.nextLine();
        do {
            switch (userBarracksInput) {
                case "1":
                    System.out.println("I choose " + options[0]);
                    setSecondaryWeaponSelection(options[0]);
                    secondaryWeaponSelected = true;
                    break;
                case "2":
                    System.out.println("I choose " + options[1]);
                    setSecondaryWeaponSelection(options[1]);
                    secondaryWeaponSelected = true;
                    break;
                case "3":
                    System.out.println("I choose " + options[2]);
                    setSecondaryWeaponSelection(options[2]);
                    secondaryWeaponSelected = true;
                    break;
                default:
                    System.out.println("The Master-At-Arms rolls his eyes.");
                    System.out.println("'Has all that mead gone to your head? I'll make it easy for you 1, 2 or 3?'");
                    System.out.println();
                    System.out.println("Options: ");
                    System.out.println("-------------------");
                    System.out.println("1 - " + options[0]);
                    System.out.println("2 - " + options[1]);
                    System.out.println("3 - " + options[2]);
                    System.out.println();
                    userBarracksInput = barracksScnr.nextLine();
                    break;
            }
        } while (!secondaryWeaponSelected);
    }

    /**********************************************************************************************************/
    /**************
     * Select Armor
     ******************************************************************************/
    /**********************************************************************************************************/

    public void selectArmor(String options[]) {
        boolean armorSelected = false;

        System.out.println("'What will your armor choice be?'");
        System.out.println("Options: ");
        System.out.println("-------------------");
        System.out.println("1 - " + options[0]);
        System.out.println("2 - " + options[1]);
        System.out.println("3 - " + options[2]);
        System.out.println();
        userBarracksInput = barracksScnr.nextLine();
        do {
            switch (userBarracksInput) {
                case "1":
                    System.out.println("I chooseth " + options[0]);
                    setArmorSelection(options[0]);
                    armorSelected = true;
                    break;
                case "2":
                    System.out.println("I chooseth " + options[1]);
                    setArmorSelection(options[1]);
                    armorSelected = true;
                    break;
                case "3":
                    System.out.println("I chooseth " + options[2]);
                    setArmorSelection(options[2]);
                    armorSelected = true;
                    break;
                default:
                    System.out.println("The Master-At-Arms rolls his eyes.");
                    System.out.println("'Has all that mead gone to your head? I'll make it easy for you 1, 2 or 3?'");
                    System.out.println();
                    System.out.println("Options: ");
                    System.out.println("-------------------");
                    System.out.println("1 - " + options[0]);
                    System.out.println("2 - " + options[1]);
                    System.out.println("3 - " + options[2]);
                    System.out.println();
                    userBarracksInput = barracksScnr.nextLine();
                    break;
            }
        } while (!armorSelected);
    }

}
