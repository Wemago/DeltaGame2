package org.academiadecodigo.gitbusters.engine;

import org.academiadecodigo.gitbusters.objects.character.enemy.Enemy;
import org.academiadecodigo.gitbusters.objects.character.enemy.EnemyFactory;
import org.academiadecodigo.gitbusters.objects.character.player.Player;
import org.academiadecodigo.gitbusters.objects.character.player.PlayerFactory;
import org.academiadecodigo.gitbusters.objects.weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;

public class Game {

    private int delay;
    private boolean endGame;

    private Field field;
    private Player player;
    private ArrayList<Enemy> enemies;

    public Game() {

        // Set game delay
        // This is related to game loop rounds
        this.delay = 3;

        // Load our game field
        this.field = new Field("resources/images/fields/field_one.png");

        // Initiate enemies container
        this.enemies = new ArrayList<>();
    }

    public void init() {
        // Create new player in the field
         this.player = PlayerFactory.getNewPlayer(field);

        // Draw player character
        player.getPosition().show();

        // Initiate listeners for keyboard press
        new KeyboardEngine(this, player);
    }

    public void start() throws InterruptedException  {

        int creationTimer = 0;
        int moveTimer = 0;
        int score = 0;

        String textScore = "Your Score: "+score;
        Text textShow = new Text((Math.round(field.getWidth()/2)), Field.PADDING*3, textScore);
        textShow.grow(Field.PADDING*6, Field.PADDING*2);
        textShow.setColor(Color.WHITE);
        textShow.draw();

        // Goes on until enemy gets to the last column
        while(!endGame) {

            setGame();

            ArrayList<Weapon> weapons = player.getWeapons();

            for(Weapon weapon : new ArrayList<>(weapons)) {

                weapon.move(field);

                for(Enemy enemy : new ArrayList<>(enemies)) {

                    if(enemy.getPosition().compare(weapon.getPosition())) {
                        enemy.getPosition().hide();
                        enemies.remove(enemy);
                        weapon.getPosition().hide();
                        weapons.remove(weapon);
                        score++;
                    }
                }
            }

            textShow.setText("Your score: "+score);

            // Create an enemy and add to the enemies container
            // counter that works as a timer to control the creating of enemies
            if(creationTimer == 350) {
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
        //POR A IMAGEM GAME OVER!!!!!!!!!!!!!!!
    }

    public boolean gomeOver(){
        return false;
    }

    public Field getField(){
        return field;
    }

    public void setGame(){

        //enemies.iterator();
        for(Enemy enemy : enemies) {

            //if enemy reaches edge
            if(enemy.atEdge()) {
                this.endGame = true;
            }

            //if enemy touch player
            if(enemy.getPosition().compare(player.getPosition())) {
                this.endGame = true;
            }
        }
    }

    public Player getPlayer() {
        return player;
    }
}