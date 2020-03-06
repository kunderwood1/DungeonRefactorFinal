public abstract class Monster extends DungeonCharacter {
    private double chanceToHeal;
    private int minHeal, maxHeal;


    public Monster(String name, int hitPoints, int attackSpeed,
                   double chanceToHit, double chanceToHeal,
                   int damageMin, int damageMax,
                   int minHeal, int maxHeal) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        setChanceToHeal(chanceToHeal);
        setHealVariance(minHeal,maxHeal);

    }


    public void setChanceToHeal(final double chanceToHeal) { this.chanceToHeal = chanceToHeal; }
    public void setHealVariance(final int minHeal,final int maxHeal) { this.minHeal = minHeal; this.maxHeal = maxHeal; }
    public double getChanceToHeal() { return this.chanceToHeal; }



    public void heal() {
        boolean canHeal;
        int healPoints;

        canHeal = (Math.random() <= chanceToHeal) && (getHitPoints() > 0);

        if (canHeal) {
            healPoints = (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
            addHitPoints(healPoints);
            System.out.println(getName() + " healed itself for " + healPoints + " points.\n"
                    + "Total hit points remaining are: " + getHitPoints());
            System.out.println();
        }
    }

    public void subtractHitPoints(int hitPoints) {
        super.subtractHitPoints(hitPoints);
        heal();
    }
}
