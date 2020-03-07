class Tile {
    private int xPos; //x-position of the tile on the grid
    private int yPos; //y-position of the tile on the grid
    private int G; //cost from starting point to tile
    private int H; //estimated cost from tile to end point
    private int F; //total cost
    private boolean wall; //Indicates whether the tile is a wall or not   

    public Tile(int x, int y) {
        xPos = x;
        yPos = y;
        wall = false;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setCost() {}

    public int getCost() {
        return F;
    }

}