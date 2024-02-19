package edu.wctc;

import java.util.ArrayList;

public class Player {
    private int score;
    private ArrayList<String> inventory;

    public Player() {
        this.score = 0;
        this.inventory = new ArrayList<>();
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void addToScore(int points) {
        score += points;
    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "Inventory is empty.";
        } else {
            StringBuilder inventoryString = new StringBuilder("Inventory: ");
            for (String item : inventory) {
                inventoryString.append(item).append(" ");
            }
            return inventoryString.toString().trim();
        }
    }

    public int getScore() {
        return score;
    }
}
