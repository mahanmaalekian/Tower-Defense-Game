package assignment1;

public abstract class HoneyBee extends Insect {
    private int cost;

    public HoneyBee(Tile tile, int hp, int foodCost) {
        super(tile,hp);
        this.cost = foodCost;
    }

    public int getCost() {
        return this.cost;
    }
}
