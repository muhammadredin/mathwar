package io.github.muhammadredin;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        Hero hero = new Hero("Redin");

        while (game.getGameState() == GameState.START) {
            // Game control0
            Waves waves = new Waves();
            ArrayList<Entity> wave = waves.getWave();

            for (Entity entity : wave) {
                System.out.println(entity.getName() + " has been appeared!");
                Thread.sleep(2000);

                while(true) {
                    game.turn(hero, entity);
                    if (hero.getHpInfo() == 0) {
                        System.out.println("GAME OVER!!! YOU LOSE!!!");
                        Thread.sleep(2000);
                        break;
                    } else if (entity.getHpInfo() == 0) {
                        System.out.println("YOU DEFEATED " + entity.getName());
                        Thread.sleep(2000);
                        break;
                    }
                }

                if (hero.getHpInfo() == 0) {
                    break;
                }
            }
            game.endGame();
        }
    }
}