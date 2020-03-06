import java.util.Scanner;

public class Dungeon {

    public static void main(String[] args) {
        Hero theHero;
        Monster theMonster;
        String playGame;
        Scanner kb = new Scanner(System.in);
        do {
            theHero = chooseHero();
            theMonster = generateMonster();
            battle(theHero, theMonster);
            System.out.println("Play again (y/n)?");
            playGame = kb.nextLine();
        } while (playGame.equals("y"));
    }

    public static Hero chooseHero() {
        Scanner kb = new Scanner(System.in);
        HeroFactory factory = new HeroFactory();
        int choice;

        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Sorceress\n" +
                "3. Thief");
        choice = kb.nextInt();

    return factory.createHero(choice);

    }

    public static Monster generateMonster() {
        MonsterFactory factory =  new MonsterFactory();
        int choice;

        choice = (int) (Math.random() * 3) + 1;

    return factory.createMonster(choice);
    }

    public static void battle(Hero theHero, Monster theMonster) {
        Scanner kb = new Scanner(System.in);
        String pause = "p";
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName());
        System.out.println("---------------------------------------------");


        while (theHero.getHitPoints() > 0 && theMonster.getHitPoints() > 0 && !pause.equals("q")) {
            theHero.battleChoices(theMonster);
            if (theMonster.getHitPoints() > 0)
                theMonster.attack(theHero);
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = kb.nextLine();
        }

        if (theMonster.getHitPoints() == 0)
            System.out.println(theHero.getName() + " was victorious!");
        else if (theHero.getHitPoints() == 0)
            System.out.println(theHero.getName() + " was defeated :-(");
        else
            System.out.println("Quitters never win ;-)");
    }
}

