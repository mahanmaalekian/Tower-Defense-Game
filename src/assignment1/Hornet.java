package assignment1;

public class Hornet extends Insect{
    private int attackDamage;
    public static int BASE_FIRE_DMG;
    private boolean isQueeen = false;
    private static int numQueens = 0;

    public Hornet (Tile tile, int hp, int attackDamage) {
        super(tile, hp);
        this.attackDamage = attackDamage;
    }

    public boolean takeAction() {
        this.takeDamage(BASE_FIRE_DMG);
        if (this.getHealth() <= 0) return false;
        Tile tile = this.getPosition();
        HoneyBee bee = tile.getBee();
        if (tile.isHive() && bee == null) {
            return false;
        }
        if (bee != null) {
            bee.takeDamage(attackDamage);
            return true;
        }
        else {
            this.getPosition().removeInsect(this);
            this.setPosition(this.getPosition().towardTheNest());
            this.getPosition().addInsect(this);
            return true;
        }
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Hornet) || !super.equals(o)) {
            return false;
        }
        Hornet hornet = (Hornet) o;
        return hornet.attackDamage == this.attackDamage;
    }

    public boolean isTheQueen(){
        return isQueeen;
    }
    public void promote(){
        if (numQueens == 0) {
            isQueeen = true;
        }
    }


}
