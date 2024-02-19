package edu.wctc;

class LootableRoom extends Room implements Lootable {
    public LootableRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "The leaves make an arch, forming a makeshift ceiling, slightly dimming the room. You see the gleam of a golden apple sitting on the floor.";
    }

    @Override
    public String loot(Player player) {
        player.addToInventory("Golden Apple");
        player.addToScore(10);
        return "You found a golden apple! +10 points.";
    }
}