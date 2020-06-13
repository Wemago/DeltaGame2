package org.academiadecodigo.gitbusters.objects.weapons;

import org.academiadecodigo.gitbusters.engine.Direction;
import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.objects.GameObject;
import org.academiadecodigo.gitbusters.objects.Moveable;
import org.academiadecodigo.gitbusters.engine.Direction;

public class Weapon extends GameObject implements Moveable {

    private boolean fired;
    private Position position;
    private Direction direction;
    private int speed;

    //private int bulletDamage;


    public Weapon(Position pos, Direction direction, int speed, String path, Field field) {

        this.position = new Position(pos.getX(),pos.getY(),field,path);

        this.direction = direction;
        System.out.println(this.direction);
        this.speed = speed;
    }

    public void setFired(boolean fired) {

        /*if (!fired) {
            this.fired = false;
            this.position.hide();
            return;
        }*/

        this.fired = fired;
        if (fired){
            this.position.show();
        }

    }

    public boolean isFired() {
        return fired;
    }


    public Direction getDirection() {
        return direction;
    }



    @Override
    public void move() {
        System.out.println("direction");
        switch (this.direction) {
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
    public void increaseSpeed() {}

    @Override
    public void decreaseSpeed() {}

    @Override
    public boolean atEdge() {
        return false;
    }



    // depois metemos um construtor e tal...

   /* public void Shoot(Enemy enemy) {
        enemy.hit();
    }  */
}
