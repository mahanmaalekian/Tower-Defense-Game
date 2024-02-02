package assignment1;

public class Tile {
    private int food;
    private boolean hive;
    private boolean nest;
    private boolean path;
    private Tile towardHive;
    private Tile towardNest;
    private HoneyBee bee;
    private SwarmOfHornets swarm;

    public Tile() {
        food = 0;
        hive = false;
        nest = false;
        path = false;
        towardHive = null;
        towardNest = null;
        bee = null;
        swarm = null;
    }

    public Tile(int food, boolean hive, boolean nest,
                boolean path, Tile towardHive, Tile towardNest,
                HoneyBee bee, SwarmOfHornets swarm) {
        this.food = food;
        this.hive = hive;
        this.nest = nest;
        this.path = path;
        this.towardHive = towardHive;
        this.towardNest = towardNest;
        this.bee = bee;
        this.swarm = swarm;
    }

    public boolean isHive() {
        return hive;
    }

    public boolean isNest() {
        return nest;
    }

    public void buildHive() {
        hive = true;
    }

    public void buildNest() {
        nest = true;
    }

    public boolean isOnThePath() {
        return path;
    }

    public Tile towardTheHive() {
        return towardHive;
    }

    public Tile towardTheNest() {
        return towardNest;
    }

    public void createPath(Tile towardHive, Tile towardNest) {
        if (towardHive == null) {
            if (hive && path) {
                this.towardNest = towardNest;
            } else {
                throw new IllegalArgumentException("Next tile on the path toward the hive cannot be null.");
            }
        } else if (towardNest == null) {
            if (nest && path) {
                this.towardHive = towardHive;
            } else {
                throw new IllegalArgumentException("Next tile on the path toward the nest cannot be null.");
            }
        } else {
            path = true;
            this.towardHive = towardHive;
            this.towardNest = towardNest;
        }

    }

    public int collectFood() {
        int tmp = food;
        food = 0;
        return tmp;
    }

    public void storeFood(int food) {
        this.food = food;
    }

    public int getNumOfHornets() {
        return swarm.sizeOfSwarm();
    }

    public HoneyBee getBee() {
        return bee;
    }

    public Hornet getHornet() {
        return swarm.getFirstHornet();
    }

    public Hornet[] getSwarm() {
        return swarm.getHornets();
    }

    public boolean addInsect(Insect insect) {
        if (insect instanceof HoneyBee && bee != null && !nest) {
            bee = (HoneyBee) insect;
            bee.setPosition(this);
            return true;


        }
        if (insect instanceof Hornet && towardHive != null) {
            swarm.addHornet((Hornet) insect);
            int size = swarm.sizeOfSwarm();
            swarm.getHornets()[size - 1].setPosition(this);
            return true;
        }
        return false;
    }

    public boolean removeInsect(Insect insect) {
        if (insect instanceof HoneyBee && bee != null && bee == insect) {
            insect.setPosition(null);
            bee = null;
            return true;
        }
        if (insect instanceof Hornet && swarm != null) {
            if (swarm.removeHornet((Hornet) insect)) {
                insect.setPosition(null);
                if (swarm.sizeOfSwarm() == 0) {
                    swarm = null;
                }
                return true;
            }
        }
        return false;
    }
}

