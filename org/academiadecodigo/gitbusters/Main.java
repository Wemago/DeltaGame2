package org.academiadecodigo.gitbusters;

public class Main {

    public static void main(String[] args) {

        try {

            Game g = new Game();

            g.init();
            g.start();

        } catch ( Exception error ) {
            System.out.println( error );
        }
    }
}
