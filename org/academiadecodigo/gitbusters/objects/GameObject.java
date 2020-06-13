package org.academiadecodigo.gitbusters.objects;

import org.academiadecodigo.gitbusters.Position;

public abstract class GameObject {

    private Position position;

    public abstract String getMessage();

    public abstract Position getPosition();

    public abstract int getSpeed();

    public abstract void setSpeed(int speed);

    public abstract void increaseSpeed();

    public abstract void decreaseSpeed();

    public abstract boolean atEdge();
}