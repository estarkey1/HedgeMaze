package edu.wctc;

public abstract class Room {
    private String name;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room up;
    private Room down;

    public Room(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public Room getAdjoiningRoom(char direction) {
        switch (Character.toUpperCase(direction)) {
            case 'N':
                return north;
            case 'S':
                return south;
            case 'E':
                return east;
            case 'W':
                return west;
            case 'U':
                return up;
            case 'D':
                return down;
            default:
                return null;
        }
    }

    public String getExits() {
        StringBuilder exits = new StringBuilder("Paths to take: ");
        if (north != null) exits.append("N ");
        if (south != null) exits.append("S ");
        if (east != null) exits.append("E ");
        if (west != null) exits.append("W ");
        if (up != null) exits.append("U ");
        if (down != null) exits.append("D ");

        return exits.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }
}
