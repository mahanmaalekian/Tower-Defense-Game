package assignment1;

public class AngryBee extends HoneyBee {
    private int attackDamage;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public AngryBee(Tile tile, int attackDamage) {
        super(tile,BASE_COST,BASE_COST);
        this.attackDamage = attackDamage;
    }

    public boolean takeAction() {
        Tile tile = this.getPosition();
        if (!tile.isOnThePath()){
            return false;
        }
        if (tile.getNumOfHornets() != 0 && !tile.isNest()) {
            tile.getHornet().takeDamage(attackDamage);
            return true;
        }
        else if (tile.towardTheNest().getNumOfHornets() != 0 && !tile.towardTheNest().isNest()) {
            tile.towardTheNest().getHornet().takeDamage(attackDamage);
            return true;
        }
        return false;
    }
}
