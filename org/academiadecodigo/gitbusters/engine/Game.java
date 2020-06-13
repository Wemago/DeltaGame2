package org.academiadecodigo.gitbusters.engine;

import org.academiadecodigo.gitbusters.objects.character.enemy.Enemy;
import org.academiadecodigo.gitbusters.objects.character.enemy.EnemyFactory;
import org.academiadecodigo.gitbusters.objects.character.player.Player;
import org.academiadecodigo.gitbusters.objects.character.player.PlayerFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Game {

    private int delay;

    private Field field;

    private Player player;

    private ArrayList<Enemy> enemies;

    public Game() {

        // Set game delay
        // This is related to game loop rounds
        this.delay = 1;

        // Load our game field
        this.field = new Field("resources/images/fields/field_one.png");

        // Initiate enemies container
        this.enemies = new ArrayList<>();
    }

    public void init() {

        // Create new player in the field
        Player player = PlayerFactory.getNewPlayer(field);

        // Draw player character
        player.getPosition().show();

        // Initiate listeners for keyboard press
        new KeyboardEngine(this, player);
    }

    public void start() throws InterruptedException {

        int creationTimer = 0;
        int moveTimer = 0;

        // Goes on until enemy gets to the last column
        // TODO: Condition for wwile no enemy is at the wall
        while(true) {
            if (player.getWeapon().isFired()){
                player.getWeapon().move();
            }
            // Create an enemy and add to the enemies container
            // counter that works as a timer to control the creating of enemies
            if(creationTimer == 625) {
                // Create new enemy at field
                Enemy enemy = EnemyFactory.getNewEnemy(field);
                // Draw enemy in its position
                enemy.getPosition().show();
                // Add enemy to enemies array
                enemies.add(enemy);
                // Start new creation timer
                creationTimer = 0;
            }
            creationTimer++;

            Thread.sleep(delay);

            // Move all enemies objects
            // Counter that works like a timer to control the enemy movement
            if(moveTimer > 10) {
                for (Enemy enemy : enemies) {
                    // Move enemy in lane with its specific velocity
                    enemy.getPosition().moveLeft(enemy.getSpeed());
                }
                moveTimer = 0;
            }
            moveTimer++;

        }
    }

    public boolean gomeOver(){
        return false;
    }
    public Field getField(){
        return field;
    }

    public Player getPlayer() {
        return player;
    }
}