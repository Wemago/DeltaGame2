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
    private int menu;

    private boolean state = false;
    private boolean exit =false;
    private boolean endGame;

    private Field screen;
    private Player player;
    private ArrayList<Enemy> enemies;
    private Sound sound;

    public Game() {

        // Set game delay
        // This is related to game loop rounds
        this.delay = 3;

        // Initiate enemies container
        this.enemies = new ArrayList<>();

        new KeyboardEngine(this);
    }

    public void init() throws InterruptedException {

        boolean state = false;

        while (!endGame) {

            new KeyboardEngine(this);

            this.screen = new Field("resources/images/menus/menu.png");

            if(!state) {
                this.sound = new Sound("/resources/sounds/menu_song.wav");
                sound.play(false);
                state = true;
            }

            if (menu == 2) {
                this.closeScreen();
                this.screen = new Field("resources/images/menus/instructions.png");
            }

            if (menu == 3) {
                this.closeScreen();
                this.screen = new Field("resources/images/menus/credits.png");
            }

            if (menu == 4) {

                this.closeScreen();

                // Battle Arena
                this.screen = new Field("resources/images/fields/field_one.png");

                //if(!state) {
                    // Create new player in the field
                    this.player = PlayerFactory.getNewPlayer(screen);
                    //state = true;
                //}

                // Draw player character
                player.getPosition().show();

                sound.stop();

                // Start game and create enemies
                this.start();
            }

        }
    }

    public void start() throws InterruptedException {

        sound = new Sound("/resources/sounds/game_song.wav");
        sound.play(true);

        new KeyboardEngine(this);

        int creationTimer = 0;
        int moveTimer = 0;
        int score = 0;

        String textScore = "Your score: " + score;
        Text textShow = new Text((Math.round(screen.getWidth() / 2)), Field.PADDING * 3, textScore);
        textShow.grow(Field.PADDING * 6, Field.PADDING * 2);
        textShow.setColor(Color.WHITE);
        textShow.draw();

        while(!endGame) {

            // Set game state
            setGame();

            ArrayList<Weapon> weapons = player.getWeapons();

            for (Weapon weapon : new ArrayList<>(weapons)) {

                weapon.move(screen);

                for (Enemy enemy : new ArrayList<>(enemies)) {

                    if (enemy.getPosition().compare(weapon.getPosition())) {
                        enemy.getPosition().hide();
                        enemies.remove(enemy);
                        weapon.getPosition().hide();
                        weapons.remove(weapon);
                        score++;
                    }
                }
            }

            textShow.setText("Your score: " + score);

            // Create an enemy and add to the enemies container
            // counter that works as a timer to control the creating of enemies
            if (creationTimer == 350) {
                // Create new enemy at field
                Enemy enemy = EnemyFactory.getNewEnemy(screen);
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
            if (moveTimer > 10) {
                for (Enemy enemy : enemies) {
                    // Move enemy in lane with its specific velocity
                    enemy.getPosition().moveLeft(enemy.getSpeed());
                }
                moveTimer = 0;
            }
            moveTimer++;
        }

        textShow.delete();

        sound.stop();
        sound = new Sound("/resources/sounds/gameover_song.wav");
        sound.play(true);

        this.screen = new Field("resources/images/gameover.png");
        Thread.sleep(10000);
        sound.stop();
    }

    public void setGame() {

        //enemies.iterator();
        for (Enemy enemy : enemies) {

            //if enemy reaches edge
            if (enemy.atEdge()) {
                this.endGame = true;
            }

            //if enemy touch player
            if (enemy.getPosition().compare(player.getPosition())) {
                this.endGame = true;
            }
        }
    }

    public boolean getEndGame() {
        return endGame;
    }

    public void setMenu(int number) {
        this.menu = number;
    }

    public void setExit() {
        this.exit = true;
    }

    public boolean getExit() {
        return exit;
    }

    public void closeScreen() {
        screen.getField().delete();
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies(){
        return this.enemies;
    }
}