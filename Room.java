import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description, item;
    private HashMap<String, Room> location;
    private double peso;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String item, double peso) 
    {
        this.description = description;
        location = new HashMap<>();
        this.item = item;
        this.peso = peso;

    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direction, Room neighbor){
        location.put(direction, neighbor);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return The item in the room.
     */
    public String getItem()
    {
        return item;
    }
    
    /**
     * @return The description of the room.
     */
    public double getPeso()
    {
        return peso;
    }    

    /**
     * Toma como par�metro una cadena que representa una direcci�n.
     * @return el objeto de la clase Room asociado a esa salida o null si no hay salida.
     */
    public Room getExit(String direccion){
        Room out = null;
        for(Room a : location.values()){
            if(direccion.equals(a.getDescription()))
            {
                out = a;
            }
        }
        return out;
    }
    
    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString(){
        String localizacion = "";
        for(Room a : location.values()){
            localizacion = localizacion + a.getDescription() + "  ";
        } 
        return localizacion; 
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription(){
        String longDescription = "You are in the " + description +"\nExits: "+ getExitString();
        return longDescription;
    }
}
