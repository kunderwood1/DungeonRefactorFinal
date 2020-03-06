import java.util.Scanner;



public class Sorceress extends Hero {

    //-----------------------------------------------------------------
    public Sorceress() {
        super("Sorceress", 75, 5, .7, 25, 50, .3);
    }
    public void increaseHitPoints() {
        int hPoints;

        int MAX_ADD = 50;
        int MIN_ADD = 25;
        hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
        addHitPoints(hPoints);
        System.out.println(getName() + " added [" + hPoints + "] points.\n"
                + "Total hit points remaining are: "
                + getHitPoints());
        System.out.println();

    }
    public void Attack(DungeonCharacter opponent) {
        System.out.println(getName() + " casts a spell of fireball at " +
                opponent.getName() + ":");
        super.attack(opponent);
    }
    public void battleChoices(DungeonCharacter opponent) {
        Scanner kb = new Scanner(System.in);
        super.battleChoices(opponent);
        int choice;

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Increase Hit Points");
            System.out.print("Choose an option: ");
            choice = kb.nextInt();

            switch (choice) {
                case 1:
                    attack(opponent);
                    break;
                case 2:
                    increaseHitPoints();
                    break;
                default:
                    System.out.println("invalid choice!");
            }

            numTurns--;
            if (numTurns > 0)
                System.out.println("Number of turns remaining is: " + numTurns);

        } while (numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);
    }
}