package edu.wctc;

class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished;

    public Maze() {
        this.player = new Player();
        this.isFinished = false;

        Room startRoom = createMaze();
        this.currentRoom = startRoom;
    }

    private Room createMaze() {
        Room room1 = new BasicRoom("Starting Area");
        Room room2 = new BasicRoom("Narrow Hallway");
        Room room3 = new InteractableRoom("Strange Wall");
        Room room4 = new BasicRoom("Wide Hallway4");
        Room room5 = new LootableRoom("Golden Apple Room");
        Room room6 = new BasicRoom("Bright Hallway");
        Room room7 = new ExitableRoom("The Exit");

        room1.setNorth(room2);
        room2.setSouth(room1);

        room2.setEast(room3);
        room3.setWest(room2);

        room3.setSouth(room4);
        room3.setEast(room5);
        room4.setNorth(room3);

        room5.setWest(room3);
        room5.setNorth(room6);

        room6.setNorth(room7);
        room6.setSouth(room5);

        room7.setSouth(room6);

        return room1;
    }


    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable) {
            isFinished = true;
            return ((Exitable) currentRoom).exit(player);
        } else {
            return "There are no exits in sight.";
        }
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable) {
            return ((Interactable) currentRoom).interact(player);
        } else {
            return "There is nothing to interact with.";
        }
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable) {
            return ((Lootable) currentRoom).loot(player);
        } else {
            return "No loot here.";
        }
    }

    public boolean move(char direction) {
        Room newRoom = currentRoom.getAdjoiningRoom(direction);
        if (newRoom != null) {
            currentRoom = newRoom;
            System.out.println("Moved to: " + currentRoom.getName());
            return true;
        } else {
            System.out.println("No room in that direction.");
            return false;
        }
    }


    public int getPlayerScore() {
        return player.getScore();
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public boolean isFinished() {
        return isFinished;
    }
}
