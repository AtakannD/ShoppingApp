import java.util.ArrayList;
import java.util.List;

public class MeatsCompartment implements IBag<Item> {
    private static final int MAX_SIZE = 5000;
    private List<Item> items;

    public MeatsCompartment() {
        items = new ArrayList<>();
    }

    @Override
    public boolean add(Item newItem) {
        if (items.size() >= MAX_SIZE) {
            return false;
        } else if (isFull()) {
            return false;
        }
        items.add(newItem);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight >= MAX_SIZE;
    }

    @Override
    public Item removeByIndex(int index) {
        return items.remove(index);
    }

    @Override
    public Item remove() {
        return items.remove(items.size() - 1);
    }

    @Override
    public Item remove(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            return item;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getIndexOf(Item item) {
        return items.indexOf(item);
    }

    @Override
    public boolean contains(Item item) {
        return items.contains(item);
    }

    @Override
    public void displayItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    @Override
    public void dump() {
        items.clear();
    }

    @Override
    public boolean transferTo(IBag<Item> targetBag, Item item) {
        if (!items.contains(item)) {
            return false;
        }
        if (!targetBag.add(item)) {
            return false;
        }
        items.remove(item);
        return true;
    }
    public  int getTotalWeight(){
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}
