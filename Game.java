import java.util.*;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

class InventoryIterator implements Iterator<String> {
    private List<String> items;
    private int index = 0;

    public InventoryIterator(List<String> items) {
        this.items = items;
    }

    public boolean hasNext() {
        return index < items.size();
    }

    public String next() {
        return items.get(index++);
    }
}

class Inventory {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public InventoryIterator getIterator() {
        return new InventoryIterator(items);
    }
}

public class Game {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem("Sword");
        inventory.addItem("Shield");
        inventory.addItem("Potion");

        Iterator<String> iterator = inventory.getIterator();

        while (iterator.hasNext()) {
            System.out.println("Item: " + iterator.next());
        }
    }
}
