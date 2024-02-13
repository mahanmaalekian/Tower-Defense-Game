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
        boolean actionTaken;
        if (isQueeen) {
            actionTaken = miniTakeAction();
            if (!actionTaken) return false;
            actionTaken = miniTakeAction();
            return actionTaken;
        }
        else {
            actionTaken = miniTakeAction();
            return actionTaken;
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
            numQueens++;
        }
    }

    private boolean miniTakeAction() {
        Tile tile = this.getPosition();
        if (tile == null) return false;
        if (tile.isOnFire()) this.takeDamage(BASE_FIRE_DMG);
        if (this.getHealth() <= 0) return false;

        HoneyBee bee = tile.getBee();
        if (tile.isHive() && this.getPosition().getBee() == null) {
            return false;
        }
        if (bee != null) {
            bee.takeDamage(attackDamage);
            return true;
        }
        else {
            //when you remove an insect it could become null
            //you could have reached the nest
            Tile temp = this.getPosition().towardTheHive();
            this.getPosition().removeInsect(this);
            this.setPosition(temp);
            temp.addInsect(this);
            return true;
        }
    }

}
