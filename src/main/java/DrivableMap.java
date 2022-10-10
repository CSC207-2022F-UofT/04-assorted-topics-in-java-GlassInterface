/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.*;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /* TODO: Write a method named addDrivable that takes a String (the ID)
     *       and a Drivable object. If the ID string does not appear as a key
     *       in drivable_map, then add the pair to drivable_map.
     *       Return true if the Drivable was added to drivable_map.
     */
    public boolean addDrivable(String id_string, Drivable new_object) {

        // Try to get an object using the ID string
        Drivable potential_object = drivable_map.get(id_string);

        // If the object is null such that the ID string does not appear
        // as a key, then add the inputted pair to drivable_map and return true;
        // otherwise, return false
        if (potential_object == null) {
            drivable_map.put(id_string, new_object);
            return true;
        } else {
            return false;
        }
    }

    /* TODO: Write a method named hasFasterThan that takes an int (a speed)
     *       and returns true iff there is at least one item in drivable_map
     *       that has a maxSpeed >= the speed given.
     * You may want to use drivable_map.keys() or drivable_map.values() to
     * iterate through drivable_map.
     */
    public boolean hasFasterThan(int speed) {

        // Get drivable stuff
        Collection<Drivable> drivable_stuff = drivable_map.values();

        // Iterate through each item in drivable_map
        for (Drivable drivable_item : drivable_stuff) {

            // If the item has a max speed >= speed, then return true and break loop
            if (drivable_item.getMaxSpeed() >= speed) {
                return true;
            }
        }

        // Else, loop was not broken; no item has a max speed >= speed; return false
        return false;
    }

    /* TODO: Write a method named getTradable that takes no arguments and
     *       returns a List containing all of the Tradable items in
     *       drivable_map.
     */
    public ArrayList<Tradable> getTradable() {

        // Define a list to contain tradable items; note the assumption that I am able to use
        // ArrayList as an instance of List
        ArrayList<Tradable> tradable_stuff = new ArrayList<Tradable>();

        // Get drivable stuff
        Collection<Drivable> drivable_stuff = drivable_map.values();

        // Iterate through each item in drivable_map
        for (Drivable drivable_item : drivable_stuff) {

            // If the item is tradable, add it to tradable_stuff
            if (drivable_item instanceof Tradable) {
                tradable_stuff.add((Tradable) drivable_item);
            }
        }

        // Return the list
        return tradable_stuff;
    }
}