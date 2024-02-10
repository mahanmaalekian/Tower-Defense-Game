package assignment1;

public abstract class Insect {
    private Tile tile;
    private int hp;

    public Insect(Tile tile, int hp) {
        this.hp = hp;
        this.tile = tile;
        if (!this.tile.addInsect(this)) {
            throw new IllegalArgumentException("Cannot add insect");
        }
    }

    public final Tile getPosition() {
        return this.tile;
    }

    public final int getHealth() {
        return this.hp;
    }

    public void setPosition(Tile tile) {
        this.tile = tile;
    }

    public void takeDamage(int damage) {
        hp = hp - damage;
        if (hp <= 0) {
            tile.removeInsect(this);
        }
     }

    public abstract boolean takeAction();

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Insect)) return false;
        Insect insect = (Insect) o;
        return insect.hp == this.hp && insect.tile == this.tile;

        //if (o instanceof Insect) {
          //  if (((Insect) o).getHealth() == hp && ((Insect) o).getPosition() == tile) {
         //       return true;
          //  }
     //   }
        //return false;
    }

    public void regenerateHealth(double healthPercentage) {
        hp = (int) (hp * (1 + healthPercentage));
    }

}
