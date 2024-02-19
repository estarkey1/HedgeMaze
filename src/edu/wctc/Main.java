package edu.wctc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);

        System.out.println("You wake up, and you surrounded by walls of leaves. You have no memory of how you got here.");

        while (!maze.isFinished()) {
            System.out.println(maze.getCurrentRoomDescription());
            System.out.println(maze.getCurrentRoomExits());

            System.out.print("Enter your command (n/s/e/w/i/l/x/v): ");
            char command = scanner.next().toLowerCase().charAt(0);

            switch (command) {
                case 'n':
                case 's':
                case 'e':
                case 'w':
                case 'u':
                case 'd':
                    boolean moved = maze.move(command);
                    if (!moved) {
                        System.out.println("Try a different direction.");
                    }
                    break;
                case 'i':
                    System.out.println(maze.interactWithCurrentRoom());
                    break;
                case 'l':
                    System.out.println(maze.lootCurrentRoom());
                    break;
                case 'x':
                    System.out.println(maze.exitCurrentRoom());
                    break;
                case 'v':
                    System.out.println("Inventory: " + maze.getPlayerInventory());
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }

        System.out.println("Your final score: " + maze.getPlayerScore());

        scanner.close();
    }
}
