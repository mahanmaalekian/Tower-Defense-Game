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

    public boolean isOnThePath () {
        return path;
    }

    public Tile towardTheHive () {
        return towardHive;
    }

    public Tile towardTheNest () {
        return towardNest;
    }

    public 
}
