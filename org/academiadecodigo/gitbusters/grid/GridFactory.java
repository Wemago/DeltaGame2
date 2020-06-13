package org.academiadecodigo.gitbusters.grid;

import org.academiadecodigo.gitbusters.gfx.simplegfx.SimpleGfxGrid;

/**
 * A factory of different types of grids
 */
public class GridFactory {

    /**
     * Creates a new grid
     *
     * @param gridType the type of grid to create
     * @param cols     the number of columns of the grid
     * @param rows     the number of rows of the grid
     * @return the new grid
     */
    public static Grid makeGrid(GridType gridType, int cols, int rows) {

        switch (gridType) {
            default:
                return new SimpleGfxGrid(cols,rows);
        }

    }

}
