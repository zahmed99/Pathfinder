

class Grid {
    private int size;
    private Tile[] closedList;
    private Tile[] openList;
    private Tile[][] matrix;

    public Grid(int size) {
        this.size = size;
        matrix = new Tile[size][size];
        openList = new Tile[size*size];
        int c = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) { 
                matrix[i][j] = new Tile(i, j);
                openList[c] = matrix[i][j];
                c++;
            }
        }
    }

    public Tile[][] matrix() {
        return matrix;
    }

    public Tile get(int x, int y) {
        return matrix[x][y];
    }

    public void set(int x, int y, Tile tile) {
        matrix[x][y] = tile;
    }

    public void printGrid() {
        for (Tile[] arr : matrix) {
            for (Tile t : arr) {
                System.out.print(t.getX() + "," + t.getY() + " ");
            }
            System.out.println();
        }
    }
}
