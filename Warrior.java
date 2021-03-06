import java.util.Scanner;



public class Warrior extends Hero {

    public Warrior() {
        super("Warrior", 125, 4, .8, 35, 60, .2);
    }
    public void crushingBlow(DungeonCharacter opponent) {
        if (Math.random() <= .4){
            int blowPoints = (int) (Math.random() * 76) + 100;
            System.out.println(getName() + " lands a CRUSHING BLOW for " + blowPoints
                    + " damage!");
            opponent.subtractHitPoints(blowPoints);
        }
        else {
            System.out.println(getName() + " failed to land a crushing blow");
            System.out.println();
        }
    }

    public void Attack(DungeonCharacter opponent) {
        System.out.println(getName() + " swings a mighty sword at " +
                opponent.getName() + ":");
        super.attack(opponent);
    }


    public void battleChoices(DungeonCharacter opponent) {
        Scanner kb = new Scanner(System.in);
        int choice;

        super.battleChoices(opponent);

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Crushing Blow on Opponent");
            System.out.print("Choose an option: ");
            choice = kb.nextInt();

            switch (choice) {
                case 1:
                    attack(opponent);
                    break;
                case 2:
                    crushingBlow(opponent);
                    break;
                default:
                    System.out.println("invalid choice!");
            }
            numTurns--;
            if (numTurns > 0)
                System.out.println("Number of turns remaining is: " + numTurns);
        } while (numTurns > 0);
    }
}