package org.academiadecodigo.gitbusters.engine;

import org.academiadecodigo.gitbusters.objects.GameObject;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardEngine implements KeyboardHandler {

    private Keyboard keyboard;

    private Game game;
    private GameObject object;

    public KeyboardEngine(Game game, GameObject object){

        this.game = game;
        this.object = object;

        this.keyboard = new Keyboard(this);

        // Defining keys need for the game
        this.createKeyboardEvent(KeyboardEvent.KEY_UP);
        this.createKeyboardEvent(KeyboardEvent.KEY_DOWN);
        this.createKeyboardEvent(KeyboardEvent.KEY_LEFT);
        this.createKeyboardEvent(KeyboardEvent.KEY_RIGHT);
        this.createKeyboardEvent(KeyboardEvent.KEY_A);
        this.createKeyboardEvent(KeyboardEvent.KEY_Z);
        this.createKeyboardEvent(KeyboardEvent.KEY_SPACE);
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
                object.getPosition().moveUp(object.getSpeed());
                break;
            case KeyboardEvent.KEY_DOWN:
                // Make object move by speed based on is current position
                object.getPosition().moveDown(object.getSpeed());
                break;
            case KeyboardEvent.KEY_LEFT:
                // Make object move by speed based on is current position
                object.getPosition().moveLeft(object.getSpeed());
                break;
            case KeyboardEvent.KEY_RIGHT:
                // Make object move by speed based on is current position
                object.getPosition().moveRight(object.getSpeed());
                break;
            case KeyboardEvent.KEY_A:
                // Increase speed
                object.increaseSpeed();
                break;
            case KeyboardEvent.KEY_Z:
                // Decrease speed
                object.decreaseSpeed();
                break;
            case KeyboardEvent.KEY_SPACE:
                // Launch something?
                // FIRE
                break;
            default:
                throw new IllegalStateException("Something went terribly wrong with the keyboard.");
        }
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}