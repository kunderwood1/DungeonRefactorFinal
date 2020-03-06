import java.util.Scanner;

public class Thief extends Hero {

    public Thief() {
        super("Thief", 75, 6, .8, 20, 40, .5);
    }

    public void Attack(DungeonCharacter opponent) {
        double surprise = Math.random();
        if (surprise <= .4) {
            System.out.println("Surprise attack was successful!\n" +
                    getName() + " gets an additional turn.");
            numTurns++;
            attack(opponent);
        }
        else if (surprise >= .9) {
            System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
                    " blocked your attack!");
        } else
            attack(opponent);
    }

    public void battleChoices(DungeonCharacter opponent) {
        Scanner kb = new Scanner(System.in);
        super.battleChoices(opponent);
        int choice;


        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Surprise Attack");
            System.out.print("Choose an option: ");
            choice = kb.nextInt();

            switch (choice) {
                case 1:
                    attack(opponent);
                    break;
                case 2:
                    Attack(opponent);
                    break;
                default:
                    System.out.println("invalid choice!");
            }//end switch

            numTurns--;
            if (numTurns > 0)
                System.out.println("Number of turns remaining is: " + numTurns);

        } while (numTurns > 0);

    }
}