import java.util.LinkedList;
import java.util.Scanner;

class Pathfinder {

    private int xPos;
    private int yPos; //
    private Tile currentSpace; //The space pathfinder is currently on
    private LinkedList<Tile> path;
    private Grid grid;
    private Tile start;
    private Tile end;

    //Accessors and Mutators
    public void setXpos(int x) {xPos = x;}
    public int getXpos() {return xPos;}
    public void setYpos(int y) {yPos = y;}
    public int getYpos() {return yPos;}
    public void setStart(int x, int y) {start = new Tile(x, y);} 
    public void setEnd(int x, int y) {end = new Tile(x, y);}

    public void setup() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the grid");
        int size = input.nextInt();
        grid = new Grid(size);
        
        System.out.println("Enter the x and y position of the starting tile.");
        int x = input.nextInt();
        int y = input.nextInt();
        start = new Tile(x, y);
        //grid.set(x, y, start);

        System.out.println("Enter the x and y position of the ending tile.");
        x = input.nextInt();
        y = input.nextInt();
        end = new Tile(x, y);
        //grid.set(x, y, end);

        input.close();
    }

    /**
     * Determine which tile to move to next,
     * based on the movement cost.
     */
    public void findNext() {

    }

    public static void main(String[] args) {
        Pathfinder A = new Pathfinder();
        A.setup();
        A.grid.printGrid();
    }
}