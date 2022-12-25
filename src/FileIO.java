import java.io.*;

public class FileIO {
    private static final String INVENTORY_FILE;

    static {
        INVENTORY_FILE = "C:\\Users\\AtakanDalkiran\\IdeaProjects\\Project\\src\\inventory.txt";
    }

    public static InventoryBag<Item> readInventory() {
        InventoryBag<Item> inventory = new InventoryBag<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String compartment = parts[1];
                int weight = Integer.parseInt(parts[2]);
                Item item = new Item(name, compartment, weight);
                inventory.add(item);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
        return inventory;
    }
}

