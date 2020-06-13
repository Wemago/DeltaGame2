package org.academiadecodigo.gitbusters.objects.weapons;

import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.engine.Direction;

public class Minigun extends Weapon {

    private Position position;


    public Minigun(Position position, Direction direction) {
        super(position, direction, 2);
    }

    public Position getPosition() {
        return position;
    }
}