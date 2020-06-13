package org.academiadecodigo.gitbusters.objects;

import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.objects.character.enemy.Enemy;
import org.academiadecodigo.gitbusters.objects.character.player.Player;
import org.academiadecodigo.gitbusters.objects.weapons.Weapon;

public class Collision {

    private boolean hasCollided;

    /*
    //if enemy gets to edge
    public boolean hasReachedEdge(Enemy enemy, Field field) {
        if (enemy.getPosition().getX() == field.getX() + Field.PADDING) {
            return true;
        }
        return false;
    }
    */

    //if enemy touch player
    public void hasReachedPlayer(Enemy enemy, Player player) {
        if (enemy.getPosition().getX() == player.getPosition().getX()) {
            hasCollided = true;
        }
    }

    /*public boolean getHasCollided() {
        return hasCollided;
    }*/
}
