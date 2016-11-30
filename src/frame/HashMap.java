package frame;

import java.awt.Color;
import java.util.Hashtable;

/**
 * Class to check the colors.
 */
public class HashMap {

    private Color colorObject;
    private int colorInt;
    
    /**
     * Constructor for the hashmap.
     * @param colorInt The delivered number of the color.
     * @param colorObject The delivered color as a colorobject.
     */
    public HashMap(int colorInt, Color colorObject) {
        this.colorInt = colorInt;
        this.colorObject = colorObject;
        
        Hashtable<Integer, Color> ht = new Hashtable<Integer, Color>();

        ht.put(0, Color.ORANGE);
        ht.put(1, Color.GREEN);
        ht.put(2, Color.BLUE);
        ht.put(3, Color.YELLOW);
        ht.put(4, Color.PINK);
        ht.put(5, Color.ORANGE);

    }
    
    /**
     * Methode to get the colorobject.
     * @param num The int of the colorslot.
     * @param name The name of the colorslot.
     * @return The colorobject of the colorslot.
     */
    public Color getName(int num, Color name) {
        return this.colorObject;
    }
    
    /**
     * Methode to get the number of the colorobject.
     * @param num The number of the colorslot.
     * @param name The name of the colorslot.
     * @return The int of the colorslot
     */
    public int getInt(int num, Color name) {
        return this.colorInt;
    }
}