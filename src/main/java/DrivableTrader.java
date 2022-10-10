/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;

class DrivableTrader extends Trader<Drivable> {

    /**
     * Construct a DrivableTrader, giving them the
     * given inventory, wishlist, and money.
     *
     * @param inventory Objects in this Trader's inventory
     * @param wishlist  Objects in this Trader's wishlist
     * @param money     The Trader's money
     */
    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist, int money) {
        super(inventory, wishlist, money);
    }

    /**
     * Construct a DrivableTrader, giving them the
     * given money and an empty wishlist and inventory.
     *
     * @param money     The Trader's money
     */
    public DrivableTrader(int money) {
        super(money);
    }

    /**
     * Take a Drivable object and return its selling price as
     * object price + object max speed, if Tradable.
     * If not, return Tradable.MISSING_PRICE.
     *
     * @param checked_object    The item to add to the wishlist
     * @return object_price     The possible price, if it exists
     */
    @Override
    public int getSellingPrice(Drivable checked_object) {

        // Call the parent price to get either object price or missing price value
        int super_price = super.getSellingPrice(checked_object);

        // If the missing price value was received, then return it since checked_object must not be Tradable
        if (super_price == Tradable.MISSING_PRICE) {
            return super_price;

        // Else, the object price was received, so return selling price as object price + object max speed
        } else {
            return super_price + checked_object.getMaxSpeed();
        }
    }

}
