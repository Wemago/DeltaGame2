package org.academiadecodigo.gitbusters.objects.character.enemy;

import org.academiadecodigo.gitbusters.engine.Direction;
import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.objects.Destroyable;
import org.academiadecodigo.gitbusters.objects.Moveable;
import org.academiadecodigo.gitbusters.objects.character.Character;

public class Enemy extends Character implements Moveable, Destroyable {

    private EnemyType type;
    private Position position;
    private Direction currentDirection;
    private boolean destroyed = false;

    private int speed ;

    public Enemy(EnemyType type, Position position, int speed) {
            this.type = type;
            this.position = position;
            this.speed = speed;
    }

    @Override
    public void hit() {
        destroyed = true;
        //getPosition().hide();
    }

    @Override
    public boolean isDestroyed() {
        return destroyed ;
    }

    @Override
    public void move() {
        accelerate(Direction.LEFT, speed);
    }

    public void accelerate(Direction direction, int speed) { }

    public Position getPosition() {
        return position;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) { }

    @Override
    public void increaseSpeed() { }

    @Override
    public void decreaseSpeed() { }

    @Override
    public boolean atEdge() {
        if(this.position.getX() == Field.PADDING) {
            return true;
        }
        return false;
    }
}