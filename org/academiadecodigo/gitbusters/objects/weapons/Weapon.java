package org.academiadecodigo.gitbusters.objects.weapons;

import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.objects.GameObject;
import org.academiadecodigo.gitbusters.objects.Moveable;

public class Weapon extends GameObject implements Moveable {

    private boolean fired;
    private Position position;
    //private Direction direction;
    private int speed;
    //private int bulletDamage;

    /*
    public Weapon(Position position, Direction direction, int speed) {

        this.position = position;
        this.direction = direction;
        this.speed = speed;
    }
     */

    public void setFired(boolean fired) {

        if (!fired) {
            this.fired = false;
            this.position.hide();
            return;
        }

        this.fired = true;
        this.position.show();
    }

    public boolean isFired() {
        return fired;
    }

    /*
    public Direction getDirection() {
        return direction;
    }
    */

    /*
    @Override
    public void move() {

        switch (direction) {
            case UP:
                position.moveUp(speed);
                break;
            case DOWN:
                position.moveDown(speed);
                break;
            case LEFT:
                position.moveLeft(speed);
                break;
            case RIGHT:
                position.moveRight(speed);
                break;
        }

    }
     */

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public void setSpeed(int speed) {

    }

    @Override
    public void increaseSpeed() {

    }

    @Override
    public void decreaseSpeed() {

    }

    @Override
    public boolean atEdge() {
        return false;
    }

    @Override
    public void move() {

    }

    // depois metemos um construtor e tal...

   /* public void Shoot(Enemy enemy) {
        enemy.hit();
    }  */
}
