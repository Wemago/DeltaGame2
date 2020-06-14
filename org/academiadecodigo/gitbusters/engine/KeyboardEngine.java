package org.academiadecodigo.gitbusters.engine;

import org.academiadecodigo.gitbusters.objects.GameObject;
import org.academiadecodigo.gitbusters.objects.character.player.Player;
import org.academiadecodigo.gitbusters.objects.weapons.Weapon;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardEngine implements KeyboardHandler {

    private Keyboard keyboard;
    private Game game;
    private GameObject object;

    public KeyboardEngine(Game game) {


        this.game = game;
        this.object = game.getPlayer();

        this.keyboard = new Keyboard(this);

        // Defining keys need for the game
        this.createKeyboardEvent(KeyboardEvent.KEY_UP);
        this.createKeyboardEvent(KeyboardEvent.KEY_DOWN);
        this.createKeyboardEvent(KeyboardEvent.KEY_LEFT);
        this.createKeyboardEvent(KeyboardEvent.KEY_RIGHT);
        this.createKeyboardEvent(KeyboardEvent.KEY_A);
        this.createKeyboardEvent(KeyboardEvent.KEY_Z);
        this.createKeyboardEvent(KeyboardEvent.KEY_SPACE);
        this.createKeyboardEvent(KeyboardEvent.KEY_I);
        this.createKeyboardEvent(KeyboardEvent.KEY_C);
        this.createKeyboardEvent(KeyboardEvent.KEY_E);
        this.createKeyboardEvent(KeyboardEvent.KEY_B);
        this.createKeyboardEvent(KeyboardEvent.KEY_S);
    }

    private void createKeyboardEvent(int key) {

        // Stat new keyboard event
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(key);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);
    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                // Make object move by speed based on is current position
                if (object instanceof Player) {
                    object.getPosition().moveUp(object.getSpeed());
                    ((Player) object).setCurrentDirection(Direction.UP);
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                // Make object move by speed based on is current position
                if (object instanceof Player) {
                    object.getPosition().moveDown(object.getSpeed());
                    ((Player) object).setCurrentDirection(Direction.DOWN);

                }
                break;
            case KeyboardEvent.KEY_LEFT:
                // Make object move by speed based on is current position
                if (object instanceof Player) {
                    object.getPosition().moveLeft(object.getSpeed());
                    ((Player) object).setCurrentDirection(Direction.LEFT);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                // Make object move by speed based on is current position
                if (object instanceof Player) {
                    object.getPosition().moveRight(object.getSpeed());
                    ((Player) object).setCurrentDirection(Direction.RIGHT);
                }
                break;
            case KeyboardEvent.KEY_A:
                // Increase speed
                if (object instanceof Player) {
                    object.increaseSpeed();
                }
                break;
            case KeyboardEvent.KEY_Z:
                // Decrease speed
                if (object instanceof Player) {
                    object.decreaseSpeed();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                // Launch something?
                if (object instanceof Player) {
                    ((Player) object).shoot();
                }
                // FIRE
                break;
            case KeyboardEvent.KEY_I:
                // Instructions
                game.instructions();
                break;
            case KeyboardEvent.KEY_C:
                // Credits
                game.credits();
                break;
            case KeyboardEvent.KEY_E:
                // Exit
                System.exit(0);
                break;
            case KeyboardEvent.KEY_B:
                // Game Menu
                game.menu();
                break;
            case KeyboardEvent.KEY_S:
                try {
                    game.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalStateException("Something went terribly wrong with the keyboard.");
        }
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}