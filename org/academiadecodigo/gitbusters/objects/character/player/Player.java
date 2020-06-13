package org.academiadecodigo.gitbusters.objects.character.player;

import org.academiadecodigo.gitbusters.engine.Direction;
import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.objects.Moveable;
import org.academiadecodigo.gitbusters.objects.character.Character;
import org.academiadecodigo.gitbusters.objects.weapons.Minigun;
import org.academiadecodigo.gitbusters.objects.weapons.Weapon;

public class Player extends Character implements Moveable {

    private PlayerType type;
    private Weapon weapon;
    private Position position;
    private Direction currentDirection;
    private Field field;


    private int speed;
    private int maxSpeed;

    public Player(PlayerType type, Position position, int speed, Field field) {
        this.type = type;
        this.position = position;
        this.speed = speed;
        this.maxSpeed = speed;
        this.weapon = new Minigun(position,getCurrentDirection(),field);
        this.field = field;
    }

    public Weapon getWeapon(){
        return weapon;
    }
    public void move() {

    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    public Direction getCurrentDirection(){
        return currentDirection;
    }

    public void accelerate(Direction direction, int speed) {

        //GridDirection newDirection = direction;

        //turns back if bumped against wall
        //if (isHittingWall()) {
        //    return;
        //}

        //accelerate in the chosen direction
        //this.currentDirection = newDirection;
        //for (int i = 0; i < speed; i++) {
            //getPos().moveInDirection(newDirection, 1);
        //    break;
        //}
    }

        /*
    public boolean isHittingWall() {
        switch (currentDirection) {
            case UP:
                if (getPos().getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (getPos().getRow() == getGrid().getRows() - 1) {
                    return true;
                }
        }

        return false;
    }
         */

    public Position getPosition() {
        return position;
    }

    public  int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void increaseSpeed() {
        this.speed++;
    }

    public void decreaseSpeed() {
        if(this.speed > 0) {
            this.speed--;
        }
    }

    @Override
    public boolean atEdge() {
        return false;
    }
}
