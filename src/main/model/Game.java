package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private List<Monster> monsters;
    private int currentMonsterIndex;
    private boolean gameOver;

    public Game() {
        // Initialize player
        player = new Player(100, 20, 10, 1.5,"Player"); // HP, damage, defence, multiplier, name of player

        // Initialize monsters
        monsters = new ArrayList<>();
        monsters.add(new Monster(80, 15, 5, 1.2,"Homework")); // HP, damage, defence, multiplier
        monsters.add(new Monster(100, 20, 8, 1.3, "The final exam"));
        monsters.add(new Monster(120, 25, 10, 1.4,"The life"));

        currentMonsterIndex = 0;
        gameOver = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (!gameOver) {
            Monster currentMonster = monsters.get(currentMonsterIndex);
            System.out.println("Current HP: " + player.getHP());
            System.out.println("Monster HP: " + currentMonster.getHP());
    
            // Player's turn
            System.out.println("Choose your action (1: Attack, 2: Defence, 3: Boost, 4: Heal):");
            int playerAction = scanner.nextInt();
            switch (playerAction) {
                case 1:
                    System.out.println(player.getName()+ " : "+player.useAttack(currentMonster));
                    break;
                case 2:
                    System.out.println(player.getName()+ " : "+player.useDefence());
                    break;
                case 3:
                    System.out.println(player.getName()+ " : "+player.useBooster());
                    break;
                case 4:
                    System.out.println(player.getName()+ " : "+player.useHealing());
                    break;
                default:
                    System.out.println("Invalid action. Please choose again.");
            }
    
            // Check if player wins
            if (currentMonster.check()) {
                System.out.println("Good job, you defeated" + currentMonster.getName());
                currentMonsterIndex++;
                if (currentMonsterIndex >= monsters.size()) {
                    System.out.println("Never fogget to work hard and keep going");
                    gameOver = true;
                    break;
                }
                player.setHP(100); // Reset player's HP
                System.out.println("Get ready for." + currentMonster.getName());
            }
    
            // Delay before the monster's turn
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
    
            // Monster's turn
            int monsterAction = random.nextInt(3) + 1; // Random action (1: Attack, 2: Defence, 3: Boost)
            switch (monsterAction) {
                case 1:
                    System.out.println(currentMonster.getName() + ": "+currentMonster.useAttack(player));
                    break;
                case 2:
                    System.out.println(currentMonster.getName() + ": "+currentMonster.useDefence());
                    break;
                case 3:
                    System.out.println(currentMonster.getName() + ": "+currentMonster.useBooster());
                    break;
            }
    
            // Check if player loses
            if (player.check()) {
                System.out.println("Game over! You were defeated by the monster.");
                gameOver = true;
            }
        }
        scanner.close();
    }
    
}
