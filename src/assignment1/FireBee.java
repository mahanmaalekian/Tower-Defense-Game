package assignment1;

public class FireBee extends HoneyBee {
    private int maxAttackRange;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public FireBee(Tile tile, int maxAttackRange) {
        super(tile, BASE_HEALTH, BASE_COST);
        this.maxAttackRange = maxAttackRange;
    }

    public boolean takeAction() {
        int range = 0;
        Tile tile = this.getPosition();
        if (!tile.isOnThePath()) return false;
        tile = tile.towardTheNest();
        while(!tile.isNest() && range <= maxAttackRange) {
            if (tile.isOnFire()){
                tile = tile.towardTheNest();
            }
            else {
                tile.setOnFire();
                return true;
            }
        }
        return false;
    }
}