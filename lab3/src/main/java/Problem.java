import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Item> items = new ArrayList<>();
    double capacity;

    public Problem(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void randomItems() {
        int range = items.size();
        int n = (int) (Math.random() * range) + 1;

        for (int i = 0; i < n; i++) {
            range = items.size();
            int index = (int) (Math.random() * range) ;
            items.remove(items.get(index ));
        }
    }

    public void randomCapacity(){
        capacity = (int) (Math.random() * 50) + 1;
    }
}

