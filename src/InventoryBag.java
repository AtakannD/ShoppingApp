import java.util.ArrayList;

public class InventoryBag<T> implements IBag<T> {
    private ArrayList<T> items;
    public InventoryBag() {
        items = new ArrayList<>();
    }

    @Override
    public boolean add(T newItem) {
        return items.add(newItem);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        // Assume the inventory has no size limit
        return false;
    }

    @Override
    public T removeByIndex(int index) {
        return items.remove(index);
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        return items.remove(items.size() - 1);
    }

    @Override
    public T remove(T item) {
        if (items.remove(item)) {
            return item;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getIndexOf(T item) {
        return items.indexOf(item);
    }

    @Override
    public boolean contains(T item) {
        return items.contains(item);
    }

    @Override
    public void displayItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    @Override
    public void dump() {
        items.clear();
    }

    @Override
    public boolean transferTo(IBag<T> targetBag, T item) {
        if (remove(item) != null) {
            return targetBag.add(item);
        }
        return false;
    }

    public T getItem(int i) {
        if (i < 0 || i >= items.size()) {
            return null;
        }
        return items.get(i);
    }

    public T find(T target) {
        for (T item : items) {
            if (item.equals(target)) {
                return item;
            }
        }
        return null;
    }

    public int getWeight(String name, String compartment){
        ArrayList<Item> castedItems = new ArrayList<>();
        for (T item : items) {
            castedItems.add((Item) item);
        }
        for (Item item : castedItems) {
            if (item.getName().equals(name) && item.getCompartment().equals(compartment)) {
                return item.getWeight();
            }
        }
        return -1;
    }
}


