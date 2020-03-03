
class Grid {
    private Tile[] closedList;
    private Tile[] openList;


    private static class Tile {
        private int xPos; //x-position of the tile on the grid
        private int yPos; //y-position of the tile on the grid
        private int G; //cost from starting point to tile
        private int H; //estimated cost from tile to end point
        private int F; //total cost
        private boolean wall; //Indicates whether the tile is a wall or not
        
    }

}