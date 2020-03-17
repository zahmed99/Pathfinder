import java.util.LinkedList;
import java.util.Scanner;

/* To Do:
Create add method that checks if item is already in list
Encapsulates list method in a custom linked list class: TileList
*/

/**
 * 
 */
class Pathfinder {
    /** Vertical position of the pathfinder */
    private int xPos = 0;
    /** Horizontal position of the pathfinder */
    private int yPos = 0;
    /** List that holds the optimal path to the end node */
    private TileList path = new TileList();
    /** List of tiles currently available for evaluation */
    private TileList openList = new TileList(); 
    /** List of tiles that are not available for evaluation */
    private TileList closedList = new TileList();
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
    public void setXpos(int x) {
        xPos = x;
    }
    
    /** 
     * Returns the current vertical position of the pathfinder 
     * @return The current vertical position of the pathfinder
     */
    public int getXpos() {
        return xPos;
    }
    
    /** 
     * Sets the horizontal positon of pathfinder
     * @param x The horizontal positon of pathfinder
     */
    public void setYpos(int y) {
        yPos = y;
    }
    
    /** 
     * Returns the current horizontal position of the pathfinder 
     * @return The horitonal position of the pathfinder
     */ 
    public int getYpos() {
        return yPos;
    }
    
    /** 
     * Returns the starting node
     * @return The starting node 
     */
    public Tile getStart() {
        return start;
    }

    /**
     * Sets the starting node 
     * @param x The x-position of the starting node
     * @param y The y-position of the starting node
     */
    public void setStart(int x, int y) {
        start = grid.get(x, y);
    }
    
   /** 
     * Returns the ending node
     * @return The ending node 
     */
    public Tile getEnd() {
        return end;
    }

    /**
     * Sets the ending node 
     * @param x The x-position of the ending node
     * @param y The y-position of the ending node
     */
    public void setEnd(int x, int y) {
        end = grid.get(x, y);
    }

    public TileList path() {
        return path;
    }

    public TileList openList() {
        return openList;
    }

    public TileList closedList() {
        return closedList;
    }

    public Grid grid() {
        return grid;
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
        input.nextLine();
        grid = new Grid(size);
        
        //Get the starting node, and add it to the closed list.
        System.out.println("Enter the x and y position of the starting tile.");
        int x = input.nextInt();
        int y = input.nextInt();
        input.nextLine();
        start = grid.get(x, y);
        current = start;
        closedList.addTile(start);

        //Get the ending node
        System.out.println("Enter the x and y position of the ending tile.");
        x = input.nextInt();
        y = input.nextInt();
        input.nextLine();
        end = grid.get(x, y);

        input.close();
    }

    /**
     * Determine which tile to move to next,
     * based on the movement cost.
     */
    public void findNext() {
        Tile temp = null;
        int x = current.getX();
        int y = current.getY();

        // Calculate f-costs for each neighbor, and add them to the open list
        // if they are not already in the open list.
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    temp = grid.get(x + j, y + i);
                    temp.calculateCost(current, end);
                    if (!(closedList.inList(temp))) {
                        openList.addTile(temp);
                    }
                    if (temp.wall()){
                        closedList.addTile(temp);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        } 

        //Find the lowest fcost in the open list, and move pathfinder to that node
        //add pathfinder's last position to the closed list.
        closedList.addTile(current);
        path.addTile(current);
        current = openList.getLowestCost();
        openList.removeTile(current);
        closedList.addTile(current);
        
        System.out.println("Any key to continue... ");
        try {
            System.in.read();
        }
        catch (Exception e) {}
    }

    /** 
     * Main Method for testing
     * @param args Command Line Arguments Unused
     */
    public static void main(String[] args) {
        Pathfinder A = new Pathfinder();
        A.setup();

        while (A.current.compareTo(A.end) != 0) {
            A.findNext();
        }

        A.path.addTile(A.end);

        A.grid.printGrid();
        System.out.println("Open List: " + A.openList.listToString());
        System.out.println("Closed List: " + A.closedList.listToString());
        System.out.println("Path: " + A.path.listToString());
    }
}