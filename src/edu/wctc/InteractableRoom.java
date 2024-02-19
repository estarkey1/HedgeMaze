package edu.wctc;

public class InteractableRoom extends Room implements Interactable {
    private static final int APPLE_POINTS = 10;
    private static final int SNAKE_POINTS = -10;

    public InteractableRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "The leafy walls of this room have an inexplicable force drawing you in. Do you dare to stick your hand inside the hedge?";
    }

    @Override
    public String interact(Player player) {
        double random = Math.random();

        if (random < 0.5) {
            // 50% pull an apple
            player.addToInventory("Apple");
            player.addToScore(APPLE_POINTS);
            return "You bravely stick your hand into the hedge, and you grab onto something. Pulling it out, you reveal a diamond apple! (+10 points)";
        } else {
            // 50% pull a snake
            player.addToInventory("Snake");
            player.addToScore(SNAKE_POINTS);
            return "You nervously stick your hand into the hedge. You feel something slithering up your arm, and when you pull it out, you reveal a snake! (-10 points)";
        }
    }
}
