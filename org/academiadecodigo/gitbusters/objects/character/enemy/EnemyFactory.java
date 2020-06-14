package org.academiadecodigo.gitbusters.objects.character.enemy;

import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.Utils;

public class EnemyFactory {

    public static Enemy getNewEnemy(Field field) {

        int random = (int) (Math.random() * EnemyType.values().length);
        EnemyType enemyType = EnemyType.values()[random];

        Enemy enemy;

        int[] lanes = {65, 135, 205, 275, 345};

        switch (enemyType) {
            case PP:
                enemy = new Enemy(EnemyType.PP,
                        new Position(
                                field.getWidth() - (Field.PADDING * 20),
                                lanes[Utils.getRandom(5)],
                                field,
                                "resources/images/characters/enemies/pp.png"),
                        2
                );
                break;
            case PG:
                enemy = new Enemy(EnemyType.PG,
                        new Position(
                                field.getWidth() - (Field.PADDING * 20),
                                lanes[Utils.getRandom(5)],
                                field,
                                "resources/images/characters/enemies/pg.png"),
                        1
                );
                break;
            case SORAIA:
                enemy = new Enemy(EnemyType.SORAIA,
                        new Position(
                                field.getWidth() - (Field.PADDING * 20),
                                lanes[Utils.getRandom(5)],
                                field,
                                "resources/images/characters/enemies/soraia.png"),
                        2
                );
                break;
            case RICARDO:
                enemy = new Enemy(EnemyType.RICARDO,
                        new Position(
                                field.getWidth() - (Field.PADDING * 20),
                                lanes[Utils.getRandom(5)],
                                field,
                                "resources/images/characters/enemies/ricardo.png"),
                        3
                );
                break;
            case MIGUEL:
                enemy = new Enemy(EnemyType.MIGUEL,
                        new Position(
                                field.getWidth() - (Field.PADDING * 20),
                                lanes[Utils.getRandom(5)],
                                field,
                                "resources/images/characters/enemies/miguel.png"),
                        3
                );
                break;
            default:
                throw new IllegalStateException("Enemy Factory : something went wrong");
        }

        return enemy;
    }
}
