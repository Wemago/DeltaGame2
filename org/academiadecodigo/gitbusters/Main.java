package org.academiadecodigo.gitbusters;

import org.academiadecodigo.gitbusters.engine.Game;

public class Main {

    public static void main(String[] args) {


        try {

            Game g = new Game();

            g.menu();

        } catch ( Exception error ) {
            System.out.println( error );
        }
    }
}
