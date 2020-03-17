package src;

import java.util.LinkedList;

class TileList {
    private LinkedList<Tile> list = new LinkedList<Tile>();

    /** 
     * Checks to see if a certain tile is in the calling list
     * @param t The tile being checked for
     * @return True if the tile is in the  list
     */
    public boolean inList(Tile tile) {
        for (Tile t : list) {
            if(tile.compareTo(t) == 0) {
                return true;
            }
        }
        return false;
    }

    public void addTile(Tile t) {
        if(this.inList(t)) return;
        else {
            list.add(t);
        }
    }

    public void removeTile(Tile t) {
        list.remove(t);
    }

    
    /** 
     * Iterates through the list, and gets the tile with the lowest F costs
     * @return Tile
     */
    public Tile getLowestCost() {
        Tile temp = list.getFirst();
        for (Tile t : list) {
            if (temp.getCost() > t.getCost()) {
                temp = t;
            }
        }
        return temp;
    }

    /**
     * Returns a string representation of the list
     * @param list
     * @return
     */
    public String listToString() {
        StringBuilder str = new StringBuilder();
        String format = "";
        for (Tile t : list) {
            format = String.format("%4d,%d", t.getX(), t.getY());
            str.append(format + " ");
        }
        return str.toString();
    }
}