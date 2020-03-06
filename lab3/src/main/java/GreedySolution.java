import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedySolution implements Algorithm {
    private List<Item> itemList = new ArrayList<>();
    private Knapsack knapsack = new Knapsack();
    private double maxSum = 0;

    public List<Item> getItemList() {
        return itemList;
    }

    public Knapsack getKnapsack() {
        return knapsack;
    }

    public double getMaxSum() {
        return maxSum;
    }

    public GreedySolution(List<Item> itemList, Knapsack knapsack) {
        this.itemList = itemList;
        this.knapsack = knapsack;
    }

    public void selectItems() {
        Collections.sort(itemList, new SortByValue());
        Collections.reverse(itemList);
       // knapsack.setItems(itemList);

        for (Item item : itemList) {
            if (knapsack.getCapacity() - item.getWeight() >= 0) {
                knapsack.setCapacity(knapsack.getCapacity() - item.getWeight());
                maxSum += item.getValue();
                knapsack.addItem(item);
                //System.out.println(item.getClass() + ": " + item.getName() + ", weight = " + item.getWeight() + ", value = " + item.getValue() + "(profit factor = " + item.profitFactor() + ")");
            } else {
                break;
            }
        }
    }

}
