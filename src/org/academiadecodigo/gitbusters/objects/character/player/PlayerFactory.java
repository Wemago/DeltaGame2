package org.academiadecodigo.gitbusters.objects.character.player;

import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.engine.Position;

public class PlayerFactory {

    public static Player getNewPlayer(Field field) {

        int random = (int) (Math.random() * PlayerType.values().length);
        PlayerType playerType = PlayerType.values()[random];
        Player player;
        int padding = 17;

        switch (playerType) {
            case MONIKE:
                player = new Player( PlayerType.MONIKE,
                        new Position(
                                field.getX() + (Field.PADDING * padding),
                                field.getHeight() / 2,
                                field,
                                "resources/images/characters/players/monica.png"),
                        2,
                        field

                );
                break;
            case TT:
                player = new Player( PlayerType.TT,
                        new Position(
                                field.getX() + (Field.PADDING * padding),
                                field.getHeight() / 2,
                                field,
                                "resources/images/characters/players/tiago.png"),
                        3,
                        field

                );
                break;
            case RICKY:
                player = new Player( PlayerType.RICKY,
                        new Position(
                                field.getX() + (Field.PADDING * padding),
                                field.getHeight() / 2,
                                field,
                                "resources/images/characters/players/ricardo.png"),
                        2,
                        field

                );
                break;
            case CAPTAIN:
                player = new Player( PlayerType.CAPTAIN,
                        new Position(
                                field.getX() + (Field.PADDING * padding),
                                field.getHeight() / 2,
                                field,
                                "resources/images/characters/players/philip.png"),
                        2,
                        field

                );
                break;
            case NEMYBOY:
                player = new Player( PlayerType.NEMYBOY,
                        new Position(
                                field.getX() + (Field.PADDING * padding),
                                field.getHeight() / 2,
                                field,
                                "resources/images/characters/players/flavio.png"),
                        2,
                        field

                );
                break;
            default:
                throw new IllegalStateException("something went wrong");
        }

        return player;
    }
}
