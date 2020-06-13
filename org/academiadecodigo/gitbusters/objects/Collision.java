package org.academiadecodigo.gitbusters.objects;

import org.academiadecodigo.gitbusters.objects.character.enemy.Enemy;
import org.academiadecodigo.gitbusters.objects.character.player.Player;
import org.academiadecodigo.gitbusters.objects.weapons.Weapon;

public class Collision {

    private boolean hasCollided;

    //if enemy gets first line
    public void hasReachedPlayer(Enemy enemy, Player player) {
        if (enemy.getPosition().getX() == player.getPosition().getX()) {
            hasCollided = true;
        }
    }

    // if bullet hits enemy
    public void hasHitEnemy(Enemy enemy, Weapon bullet) {
        if (enemy.getPosition().getX() == bullet.getPosition().getX()) {
            hasCollided = true;
        }
    }

    public boolean getHasCollided() {
        return hasCollided;
    }
}
