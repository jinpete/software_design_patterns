public class InventoryIteratorTester {

    public static void main(String[] args) {
        InventorySetup inv = new InventorySetup();
        ItemIterator inventoryIterator = inv.createIterator();
        while(inventoryIterator.hasNext()) {
            InventoryItem inventoryItem = inventoryIterator.next();
            System.out.println(inventoryItem.toString());

        }

    }

}
