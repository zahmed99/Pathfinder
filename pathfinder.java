import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */
class Pathfinder {
    /** Vertical position of the pathfinder */
    private int xPos = 0;
    /** Horizontal position of the pathfinder */
    private int yPos = 0;
    /** List that holds the optimal path to the end node */
    private LinkedList<Tile> path = null;
    /** List of tiles currently available for evaluation */
    private LinkedList<Tile> openList = null; 
    /** List of tiles that are not available for evaluation */
    private LinkedList<Tile> closedList = null; 
    /** The matrix of nodes that the pathfinder will traverse */
    private Grid grid = null;
    /** The starting node */
    private Tile start = null;
    /** The ending node */
    private Tile end = null;
    /** The node that the pathfinder is currently on */
    private Tile current; 

    /**
     * Constructs a new pathfinder
     */
    Pathfinder() {}
    
    /** 
     * Sets the vertical positon of pathfinder
     * @param x The vertical positon of pathfinder
     */
    public void setXpos(int x) {xPos = x;}
    
    /** 
     * Returns the current vertical position of the pathfinder 
     * @return The current vertical position of the pathfinder
     */
    public int getXpos() {return xPos;}
    
    /** 
     * Sets the horizontal positon of pathfinder
     * @param x The horizontal positon of pathfinder
     */
    public void setYpos(int y) {yPos = y;}
    
    /** 
     * Returns the current horizontal position of the pathfinder 
     * @return The horitonal position of the pathfinder
     */ 
    public int getYpos() {return yPos;}
    
    /** 
     * Returns the starting node
     * @return The starting node 
     */
    public Tile getStart() {return start;}

    /**
     * Sets the starting node 
     * @param x The x-position of the starting node
     * @param y The y-position of the starting node
     */
    public void setStart(int x, int y) {start = grid.get(x, y);} 
    
   /** 
     * Returns the ending node
     * @return The ending node 
     */
    public Tile getEnd() {return end;}

    /**
     * Sets the ending node 
     * @param x The x-position of the ending node
     * @param y The y-position of the ending node
     */
    public void setEnd(int x, int y) {end = grid.get(x, y);}

    /** 
     * Checks to see if a certain tile is in the open list
     * @param t The tile being checked for
     * @return True if the tile is in the open list
     */
    public boolean inOpenList(Tile t) {
        for (Tile i : openList) {
            if (t.compareTo(i) == 0) {
                return true;
            }
        }
        return false;
    }

    /** 
     * Checks to see if a certain tile is in the closed list
     * @param t The tile being checked for
     * @return True if the tile is in the closed list
     */
    public boolean inClosedList(Tile t) {
        for (Tile i : closedList) {
            if (t.compareTo(i) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets user input for important variables:
     * - Size of the grid
     * - Starting node
     * - End Node
     */
    public void setup() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the grid");
        int size = input.nextInt();
        grid = new Grid(size);
        
        System.out.println("Enter the x and y position of the starting tile.");
        int x = input.nextInt();
        int y = input.nextInt();
        start = grid.get(x, y);
        current = start;
        openList.add(start);

        System.out.println("Enter the x and y position of the ending tile.");
        x = input.nextInt();
        y = input.nextInt();
        end = grid.get(x, y);

        input.close();
    }

    /**
     * Determine which tile to move to next,
     * based on the movement cost.
     */
    public void findNext() {
        int x = current.getX();
        int y = current.getY();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!this.inOpenList(grid.get(x + j, y + i))) {
                    openList.add(grid.get(x + j, y + i));
                }
            }
        }
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Pathfinder A = new Pathfinder();
        A.setup();
        if (A.current.compareTo(A.end) == 0) {
            System.out.println(A.path);
        }
        A.grid.printGrid();
    }
}