

public class Skeleton extends Monster {

    public Skeleton() {
        super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
    }

    public void Attack(DungeonCharacter opponent) {
        System.out.println(getName() + " slices his rusty blade at " +
                opponent.getName() + ":");
        super.attack(opponent);
    }
}