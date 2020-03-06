import java.util.Scanner;

public abstract class Hero extends DungeonCharacter {
    private double chanceToBlock;
    protected int numTurns;

    public Hero(String name, int hitPoints, int attackSpeed,
                double chanceToHit, int damageMin, int damageMax,
                double chanceToBlock) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        setChanceToBlock(chanceToBlock);
        readName();
    }

    public void setChanceToBlock(final double chanceToBlock) {
        this.chanceToBlock = chanceToBlock;    
    }
    
    public double getChanceToBlock() {
        return this.chanceToBlock;
    }

    public int getNumTurns() {
        return this.numTurns;    
    }

    public void readName() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter character name: ");
        setName(kb.nextLine());
    }

    public boolean defend() {
        return Math.random() <= chanceToBlock;
    }

    public void subtractHitPoints(int hitPoints) {
        if (defend()) {
            System.out.println(getName() + " BLOCKED the attack!");
        } else {
            super.subtractHitPoints(hitPoints);
        }


    }
    public void battleChoices(DungeonCharacter opponent) {
        numTurns = getAttackSpeed() / opponent.getAttackSpeed();
        if (numTurns == 0)
            numTurns++;
        System.out.println("Number of turns this round is: " + numTurns);
    }

}
