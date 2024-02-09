package assignment1;

public abstract class HoneyBee extends Insect {
    private int cost;
    public static double HIVE_DMG_REDUCTION;

    public HoneyBee(Tile tile, int hp, int foodCost) {
        super(tile,hp);
        this.cost = foodCost;
    }

    public int getCost() {
        return this.cost;
    }

    public void takeDamage(int damage) {
        if (this.getPosition().isHive()) {
            //round towards 0
            damage = (int) (damage * (100 - HIVE_DMG_REDUCTION) / 100);
        }
        super.takeDamage(damage);
    }
}
