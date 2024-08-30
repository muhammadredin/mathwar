package io.github.muhammadredin;

import java.util.Random;
import java.util.Scanner;

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

    public void turn(Entity player, Entity cpu) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        if (this.gameTurn == GameTurn.PLAYER) {
            int number1 = rand.nextInt(100);
            int number2 = rand.nextInt(100);
            int answer = number1 + number2;

            System.out.println("Solve This to Attack: " + number1 + " " + number2);
            int userInput = input.nextInt();

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

    public void endGame() {
        this.gameState = GameState.GAME_OVER;
    }
}


