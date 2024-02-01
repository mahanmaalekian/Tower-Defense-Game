package assignment1;

public class AngryBee extends  HoneyBee {
    private int attackDamage;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public AngryBee(Tile tile, int attackDamage) {
        super(tile,BASE_COST,BASE_COST);
        this.attackDamage = attackDamage;
    }
}
