import java.util.Scanner;

public class ShoppingApp {
    private static final int BASKET_SIZE = 2000;

    private static Scanner input;
    private static InventoryBag<Item> inventory;
    private static ShoppingBasket basket;
    private static Fridge fridge;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        inventory = FileIO.readInventory();
        basket = new ShoppingBasket(BASKET_SIZE);
        fridge = new Fridge();

        while (true) {
            //Check fridge, if all compartments are full then exit
            if(fridge.fridgeIsFull()) {
                System.out.println("Fridge is full.");
                break;
            }
            System.out.println("Welcome to the shopping mall. What do you want to do?");
            System.out.println("1. Shop");
            System.out.println("2. Check fridge");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                shop();
            } else if (choice == 2) {
                checkFridge();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }

    private static void shop() {
        while (true) {
            System.out.println("\nShopping mode.");
            System.out.println("1. View basket");
            System.out.println("2. View inventory");
            System.out.println("3. Add item to basket");
            System.out.println("4. Remove item from basket");
            System.out.println("5. Checkout");
            System.out.println("6. Cancel shopping");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                viewBasket();
            } else if (choice == 2) {
                viewInventory();
            } else if (choice == 3) {
                viewInventory();
                System.out.print("Enter the name of the item to add: ");
                String itemName = input.nextLine();
                System.out.println("Select the compartment of the item to add: ");
                System.out.println("1. Meats Compartment");
                System.out.println("2. Vegetables and Fruits Compartment");
                System.out.println("3. Beverages Compartment");
                System.out.println("4. Snacks Compartment");
                System.out.print("Enter your choice: ");
                int compartmentChoice = input.nextInt();
                String compartment;
                switch (compartmentChoice) {
                    case 1 : compartment = "MeatsCompartment";
                    break;
                    case 2 : compartment = "VegetablesFruitsCompartment";
                    break;
                    case 3: compartment = "BeveragesCompartment";
                    break;
                    case 4 : compartment = "SnacksCompartment";
                    break;
                    default : System.out.println("Please Try Again");
                        compartment = null;
                }
                Integer weight = inventory.getWeight(itemName, compartment);
                addItemToBasket(itemName, compartment, weight, basket);
            } else if (choice == 4) {
                removeItemFromBasket();
            } else if (choice == 5) {
                checkout();
                break;
            } else if (choice == 6) {
                cancelShopping();
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewBasket() {
        System.out.println("\nShopping basket:");
        if (basket.isEmpty()) {
            System.out.println("The basket is empty.");
        } else {
            for (int i = 0; i < basket.getItemCount(); i++) {
                Item item = basket.getItem(i);
                System.out.println((i + 1) + ". " + item.getName() + ", " + item.getCompartment() + ", " + item.getWeight() + " grams");
            }
        }
    }

    private static void viewInventory() {
        System.out.println("\nInventory:");
        if (inventory.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            for (int i = 0; i < inventory.getItemCount(); i++) {
                Item item = inventory.getItem(i);
                System.out.println((i + 1) + ". " + item.getName() + ", " + item.getCompartment() + ", " + item.getWeight() + " grams");
            }
        }
    }
    private static void addItemToBasket(String itemName, String compartment, Integer weight, ShoppingBasket basket) {
        // Search the inventory for the item with the given name
        Item item = inventory.find(new Item(itemName, compartment, weight));
        boolean isFull = basket.getTotalWeight() + weight > BASKET_SIZE;
        if (item != null) {
            if (!isFull){
            // If the item is found, add it to the basket
            basket.add(item);
            System.out.println("Added 1 x " + itemName + " to the basket.");
            }
            else {
                System.out.println("Basket Size Exceeded");
                }
        } else {
            // If the item is not found, print an error message
            System.out.println("Item not found: " + itemName);
        }
    }

    private static void removeItemFromBasket() {
        if (basket.isEmpty()) {
            System.out.println("The basket is empty.");
        } else {
            viewBasket();
            System.out.println("Enter the index of the item you want to remove:");
            int index = input.nextInt();
            input.nextLine();
            if (index < 1 || index > basket.getItemCount()) {
                System.out.println("Invalid index.");
            } else {
                Item item = basket.removeByIndex(index - 1);
                if (item != null) {
                    inventory.add(item);
                    System.out.println("Item removed from basket.");
                }
            }
        }
    }

    private static void checkout() {
        if (basket.isEmpty()) {
            System.out.println("The basket is empty.");
        } else {
            System.out.println("\nChecking out...");
            while (!basket.isEmpty()) {
                Item item = basket.remove();
                if (item != null) {
                    if (!fridge.addToCompartment(item)) {
                        // If the item cannot be added to the fridge, put it back in the basket
                        basket.add(item);
                        break;
                    }
                }
            }
            System.out.println("Checkout complete.");
        }
    }

    private static void cancelShopping() {
        if (basket.isEmpty()) {
            System.out.println("The basket is empty.");
        } else {
            System.out.println("\nCancelling shopping...");
            while (!basket.isEmpty()) {
                Item item = basket.remove();
                System.out.println(item + " is removed.");
            }
            System.out.println("Shopping cancelled.");
        }
    }

    private static void checkFridge() {
        System.out.println("\nFridge status:");
        fridge.displayCompartmentStatus();
    }
}