package io.github.muhammadredin;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

enum GameState {
    START, GAME_OVER;
}

enum GameTurn {
    PLAYER, CPU;
}

public class Game {
    private GameState gameState;
    private GameTurn gameTurn = GameTurn.PLAYER;

    public Game() {
        this.gameState = GameState.START;
    }

    public GameState getGameState() {
        return gameState;
    }

    public static Integer getInputWithTimeout(int timeoutSeconds) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        });

        try {
            return future.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            future.cancel(true); // Cancel the input task
            return 0; // Indicate timeout
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            return 0;
        } finally {
            executor.shutdown(); // Shutdown the executor
        }
    }

    public void turn(Entity player, Entity cpu) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        if (this.gameTurn == GameTurn.PLAYER) {
            int number1 = rand.nextInt(10);
            int number2 = rand.nextInt(10);
            int answer = number1 + number2;
            System.out.println("Solve This to Attack: " + number1 + " + " + number2);
            Integer userInput = getInputWithTimeout(10);


            if (userInput == null) {
                cpu.attack(player);
                System.out.println("You've been attacked!");
                System.out.println(player.getName() + " HP left: " +
                        player.getHpInfo());
            } else {
                if (answer == userInput) {
                    player.attack(cpu);
                    System.out.println("You attacked!");
                    System.out.println(cpu.getName() + " HP left: " +
                            cpu.getHpInfo());
                } else {
                    cpu.attack(player);
                    System.out.println("You've been attacked!");
                    System.out.println(player.getName() + " HP left: " +
                            player.getHpInfo());
                }
            }
        }
    }

    public void endGame() {
        this.gameState = GameState.GAME_OVER;
    }
}


