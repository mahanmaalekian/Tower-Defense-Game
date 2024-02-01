package assignment1;

public class Hornet extends Insect{
    private int attackDamage;

    public Hornet (Tile tile, int hp, int attackDamage) {
        super(tile, hp);
        this.attackDamage = attackDamage;
    }

}
