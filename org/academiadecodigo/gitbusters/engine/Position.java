package org.academiadecodigo.gitbusters.engine;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private Field field;
    private Picture picture;

    public Position(int x, int y, Field field, String path) {
        this.field = field;
        this.picture = new Picture(x, y, path);
    }

    public void show() {
        picture.draw();
    }

    public void hide() {
        picture.delete();
    }

    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public int getMaxX() {
        return picture.getMaxX();
    }

    public int getMaxY() {
        return picture.getMaxY();
    }

    public Picture getPicture() {
        return picture;
    }

    public boolean compare(Position position) {
        return (this.getMaxX()) > (position.getX()) &&
                (this.getX()) < (position.getMaxX()) &&
                (this.getMaxY()) > (position.getY()) &&
                (this.getY()) < (position.getMaxY());
    }

    public void moveUp(int distance) {
        if (picture.getY() > Field.PADDING) {
            picture.translate(0, -distance);
        }
    }

    public void moveDown(int distance) {
        if (picture.getMaxY() < field.getHeight() + Field.PADDING) {
            picture.translate(0, distance);
        }
    }

    public void moveRight(int distance) {
        if (picture.getMaxX() < field.getWidth() + Field.PADDING) {
            picture.translate(distance, 0);
        }
    }

    public void moveLeft(int distance) {
        if (picture.getX() > Field.PADDING) {
            picture.translate(-distance, 0);
        }
    }
}
