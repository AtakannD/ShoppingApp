// Interface for a bag that can hold items of a given type
public interface IBag<T> {
    // Add a new item to the bag
    boolean add(T newItem);

    // Check if the bag is empty
    boolean isEmpty();

    // Check if the bag is full
    boolean isFull();

    // Remove the item at the given index from the bag
    T removeByIndex(int index);

    // Remove an item from the bag
    T remove();

    // Remove a specific item from the bag
    T remove(T item);

    // Get the number of items in the bag
    int getItemCount();

    // Get the index of a specific item in the bag
    int getIndexOf(T item);

    // Check if the bag contains a specific item
    boolean contains(T item);

    // Display the items in the bag
    void displayItems();

    // Remove all items from the bag
    void dump();

    // Transfer an item from this bag to another bag
    boolean transferTo(IBag<T> targetBag, T item);
}
