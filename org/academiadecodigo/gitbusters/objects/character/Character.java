package org.academiadecodigo.gitbusters.objects.character;

import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.objects.GameObject;

abstract public class Character extends GameObject {

    private Position pos;

    private String name;
    private int speed;
    private int maxSpeed;

  /*  public Character(GridPosition pos){
        this.pos = pos;
    }*/

    public Position getPos() {
        return pos;
    }

    /*
    public Character(ObjectType type, GridPosition pos) {
        super(type, pos);
    }
    */

    @Override
    public String getMessage() {
        return null;
    }
}