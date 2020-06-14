package org.academiadecodigo.gitbusters.objects.decor;

import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.objects.GameObject;

public class Decor extends GameObject {

    private Position position;

    public Decor(DecorType type, Position pos) {

    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public Position getPosition() {
        return this.position;
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
}