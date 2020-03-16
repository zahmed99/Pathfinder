class Tile implements Comparable<Tile>{
    private int xPos; //x-position of the tile on the grid
    private int yPos; //y-position of the tile on the grid
    private int G = 0; //cost from starting point to tile
    private int H = 0; //estimated cost from tile to end point
    private int F = 0; //total cost
    private boolean wall; //Indicates whether the tile is a wall or not   

    public int compareTo(Tile t) {
        if (this.xPos == t.xPos && this.yPos == t.yPos) {
            return 0;
        }
        return 1;
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

    public void calculateCost(Tile curr, Tile end) {
        G = (int)(10 * Math.sqrt(Math.pow(this.xPos - curr.xPos, 2) + Math.pow(this.yPos - curr.yPos, 2)));
        H = (int)(10 * Math.sqrt(Math.pow(this.xPos - end.xPos, 2) + Math.pow(this.yPos - end.yPos, 2)));
        F = G + H;
    }

    public int getCost() {
        return F;
    }

    public boolean wall() {
        return wall;
    }

}