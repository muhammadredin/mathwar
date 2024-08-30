package io.github.muhammadredin;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Hero hero = new Hero("Redin");
        Goblin goblin = new Goblin();
        while (game.getGameState() == GameState.START) {
            // Game control
            game.turn(hero, goblin);

            if(hero.getHpInfo() == 0) {
                System.out.println("GAME OVER!!! YOU LOSE!!!");
                game.endGame();
            } else if (goblin.getHpInfo() == 0) {
                System.out.println("CONGRATULATIONS YOU WIN!!!");
                game.endGame();
            }
        }
    }
}