package org.academiadecodigo.gitbusters.objects.weapons;

import org.academiadecodigo.gitbusters.engine.Direction;
import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.engine.Direction;

public class Minigun extends Weapon {

    private Position position;

    public Minigun(Position position, Direction direction, Field field) {
        super(position, direction, 2,"resources/images/souts/sout-branco.png",field);

    }


    public Position getPosition() {
        return position;
    }
}