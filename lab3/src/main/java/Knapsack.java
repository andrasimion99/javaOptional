import java.util.List;
import java.util.ArrayList;

public class Knapsack {
    private double capacity;
    private List<Item> items = new ArrayList<>();

    public Knapsack() {
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Knapsack(double capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                "capacity=" + capacity +
                ", items=" + items +
                '}';
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item.getClass() + ": " + item.getName() + ", weight = " + item.getWeight() + ", value = " + item.getValue() + "(profit factor = " + item.profitFactor() + ")");
        }
    }
}

