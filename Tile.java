class Tile implements Comparable<Tile>{
    private int xPos; //x-position of the tile on the grid
    private int yPos; //y-position of the tile on the grid
    private int G; //cost from starting point to tile
    private int H; //estimated cost from tile to end point
    private int F; //total cost
    private boolean wall; //Indicates whether the tile is a wall or not   

    public int compareTo(Tile t) {
        return ((this.xPos - t.xPos) - (this.yPos - t.yPos));
    }

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

    public void setCost() {
        F = G + H;
    }

    public int getCost() {
        return F;
    }

}