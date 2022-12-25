public class Item {
    // Class to represent an item in the inventory
    private String name;
    private String compartment;
    private int weight;

    public Item(String name, String compartment, int weight) {
        this.name = name;
        this.compartment = compartment;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getCompartment() {
        return compartment;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (" + compartment + ", " + weight + " grams)";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Item)) return false;
        Item other = (Item) obj;
        return name.equals(other.name) && compartment.equals(other.compartment) && weight == other.weight;
    }
}
