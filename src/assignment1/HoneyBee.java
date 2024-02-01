package assignment1;

public class HoneyBee extends Insect {
    private int foodCost;

    public HoneyBee(Tile tile, int hp, int foodCost) {
        super(tile,hp);
        this.foodCost = foodCost;
    }

    public int getCost() {
        return this.foodCost;
    }
}
