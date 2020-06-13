package org.academiadecodigo.gitbusters;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    public static final int PADDING = 10;
    private Picture field;

    public Field(String path) {
        // Creating game field
        field = new Picture(PADDING, PADDING, path);
        // Show game field
        field.draw();
    }

    public int getWidth() {
        return field.getWidth();
    }

    public int getHeight() {
        return field.getHeight();
    }

    public int getX() {
        return field.getX();
    }

    public int getY() {
        return field.getY();
    }

    public int getMaxX() {
        return field.getMaxX();
    }

    public int getMaxY() {
        return field.getMaxY();
    }

    public boolean isEdge() {
        return (getX() == 0 || getX() == (getHeight() - 1)) || (getY() == 0 || getY() == (getWidth() - 1));
    }
}
