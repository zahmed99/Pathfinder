class Grid {
    private int size;
    private Tile[][] matrix;

    public Grid(int size) {
        this.size = size;
        matrix = new Tile[size][size];
        int c = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) { 
                matrix[i][j] = new Tile(i, j);
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
                System.out.printf("%4d,%d ", t.getX(), t.getY());
            }
            System.out.println();
        }
    }
}
