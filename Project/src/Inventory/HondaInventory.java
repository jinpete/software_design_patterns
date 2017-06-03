package Inventory;
import AutomobilePackage.Accord;
import AutomobilePackage.Automobile;

import java.util.*;

final public class HondaInventory extends Observable {
    private static int quantity = 5;
    private static HondaInventory theHondaInventory = new HondaInventory(); //singleton

    public HondaInventory() {
        super();
    }

    public static int getQuantity() {
        return quantity;
    }

    public void getInventoryInfo(Automobile anAutomobile) {
        if(anAutomobile instanceof Accord) {
            System.out.println( "Accord" + ((quantity > 1) ? "s" : "") + "  in stock " + quantity);
        }
    }

    public void addInventory(int quantity) {
        this.quantity += quantity;
        this.setChanged();
        this.notifyObservers();
    }

    public static HondaInventory getTheHondaInventory() {
        return theHondaInventory;
    }
}
