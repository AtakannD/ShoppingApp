public class Fridge {
    private static final int MAX_SIZE_VEGETABLES_FRUITS = 3000;
    private static final int MAX_SIZE_MEATS = 5000;
    private static final int MAX_SIZE_BEVERAGES = 4000;
    private static final int MAX_SIZE_SNACKS = 2000;

    private VegetablesFruitsCompartment vegetablesFruitsCompartment;
    private MeatsCompartment meatsCompartment;
    private BeveragesCompartment beveragesCompartment;
    private SnacksCompartment snacksCompartment;

    public Fridge() {
        vegetablesFruitsCompartment = new VegetablesFruitsCompartment();
        meatsCompartment = new MeatsCompartment();
        beveragesCompartment = new BeveragesCompartment();
        snacksCompartment = new SnacksCompartment();
    }

    public boolean addToCompartment(Item item) {
        String compartment = item.getCompartment();
        if (compartment.equals("VegetablesFruitsCompartment") && vegetablesFruitsCompartment.getTotalWeight() + item.getWeight() <= MAX_SIZE_VEGETABLES_FRUITS) {
            vegetablesFruitsCompartment.add(item);
            return true;
        } else if (compartment.equals("MeatsCompartment") && meatsCompartment.getTotalWeight() + item.getWeight() <= MAX_SIZE_MEATS) {
            meatsCompartment.add(item);
            return true;
        } else if (compartment.equals("BeveragesCompartment") && beveragesCompartment.getTotalWeight() + item.getWeight() <= MAX_SIZE_BEVERAGES) {
            beveragesCompartment.add(item);
            return true;
        } else if (compartment.equals("SnacksCompartment") && snacksCompartment.getTotalWeight() + item.getWeight() <= MAX_SIZE_SNACKS) {
            snacksCompartment.add(item);
            return true;
        } else {
            System.out.println(item.getName() + " cannot be added to the fridge.");
            return false;
        }
    }

    public void displayCompartmentStatus() {
        System.out.println("Vegetables and Fruits compartment: " + vegetablesFruitsCompartment.getTotalWeight() + " / " + MAX_SIZE_VEGETABLES_FRUITS);
        System.out.println("Meats compartment: " + meatsCompartment.getTotalWeight() + " / " + MAX_SIZE_MEATS);
        System.out.println("Beverages compartment: " + beveragesCompartment.getTotalWeight() + " / " + MAX_SIZE_BEVERAGES);
        System.out.println("Snacks compartment: " + snacksCompartment.getTotalWeight() + " / " + MAX_SIZE_SNACKS);
    }
    public boolean fridgeIsFull(){
        return meatsCompartment.isFull() && snacksCompartment.isFull() && beveragesCompartment.isFull() &&
                vegetablesFruitsCompartment.isFull();
    }
}



