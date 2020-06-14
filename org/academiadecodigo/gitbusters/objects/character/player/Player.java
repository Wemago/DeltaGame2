package org.academiadecodigo.gitbusters.objects.character.player;

import org.academiadecodigo.gitbusters.engine.Direction;
import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.engine.Sound;
import org.academiadecodigo.gitbusters.objects.Moveable;
import org.academiadecodigo.gitbusters.objects.character.Character;
import org.academiadecodigo.gitbusters.objects.weapons.Minigun;
import org.academiadecodigo.gitbusters.objects.weapons.Weapon;

import java.util.ArrayList;

public class Player extends Character implements Moveable {

    private PlayerType type;
    //private Weapon weapon;
    private Position position;
    private Direction currentDirection;
    private Field field;

<<<<<<< HEAD
=======
    private ArrayList<Weapon> weapons;

>>>>>>> 3aa68310be063ce202b8ad56033b058d2625b878
    private int speed;
    private int maxSpeed;

    public Player(PlayerType type, Position position, int speed, Field field) {
        this.type = type;
        this.position = position;
        this.speed = speed;
        this.maxSpeed = speed;
        this.currentDirection = Direction.RIGHT;
<<<<<<< HEAD
        this.weapon = new Minigun(position,getCurrentDirection(),field);
=======

        this.weapons = new ArrayList<>();

>>>>>>> 3aa68310be063ce202b8ad56033b058d2625b878
        this.field = field;
    }

    public void shoot(){
        Minigun minigun = new Minigun(position,getCurrentDirection(),field);
        minigun.getPosition().show();
        weapons.add(minigun);

        Sound shoot = new Sound("resources/sounds/sfx_shoot.wav");
        shoot.play(true);
    }

    public static void removeWeapon() { }

    public ArrayList<Weapon> getWeapons(){
        return this.weapons;
    }

    public void move() { }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    public Direction getCurrentDirection(){
        return currentDirection;
    }

    public void accelerate(Direction direction, int speed) { }

        /*
    public boolean isHittingWall() { }
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
