package assignment1;

public class SniperBee extends HoneyBee{
    private int attackDamage;
    private int piercingPower;
    public static int BASE_HEALTH;
    public static int BASE_COST;
    private Tile aiming = null;

    public SniperBee(Tile tile, int attackDamage, int piercingPower) {
        super(tile, BASE_HEALTH,BASE_COST);
        this.attackDamage = attackDamage;
        this.piercingPower = piercingPower;
    }

    public boolean takeAction(){
        Tile tile = this.getPosition();
        int n;
        if (tile.getNumOfHornets() >= piercingPower){
            n = piercingPower;
        }
        else {
            n = tile.getNumOfHornets();
        }
        if (!tile.isOnThePath()) return false;
        tile = tile.towardTheNest();

        while (!tile.isNest()) {
            if (tile.getNumOfHornets() == 0) {
                tile = tile.towardTheNest();
            }
            else {
                if (aiming != tile){
                    aiming  = tile;
                    return false;
                }
                else {
                    aiming = null;
                    Hornet[] hornets = tile.getHornets();
                    for (int i = 0; i < n; i++){
                        hornets[i].takeDamage(attackDamage);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
