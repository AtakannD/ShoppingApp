public class PlasticTrashBag implements IBag<Item> {
    @Override
    public boolean add(Item newItem) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean isFull() { return true; }

    @Override
    public Item removeByIndex(int index) {
        return null;
    }

    @Override
    public Item remove() {return null; }

    @Override
    public Item remove(Item nullObj) {
        return null;
    }

    @Override
    public int getItemCount() {
        return -1;
    }

    @Override
    public int getIndexOf(Item item) {
        return -1;
    }

    @Override
    public boolean contains(Item item) { return true;}

    @Override
    public void displayItems() {}

    @Override
    public void dump() {}

    @Override
    public boolean transferTo(IBag<Item> targetBag, Item item) {
        return true;
    }
}

