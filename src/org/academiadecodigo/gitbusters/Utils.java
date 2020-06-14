package org.academiadecodigo.gitbusters;

public class Utils {

    // Get random value by max number
    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }

    // Get random number by min and max numbers
    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}