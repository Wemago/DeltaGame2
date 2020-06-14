package org.academiadecodigo.gitbusters;

import org.academiadecodigo.gitbusters.engine.Game;

public class Main {

    public static void main(String[] args) {

        try {

            Game g = new Game();
            g.init();

            while( !g.getExit() ) {
                if( g.getEndGame() ) {
                    g = new Game();
                    g.init();
                }
            }

        } catch ( Exception error ) {
            System.out.println( error );
        }
    }
}
