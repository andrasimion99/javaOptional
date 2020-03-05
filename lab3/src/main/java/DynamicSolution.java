import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.List;

public class DynamicSolution {
    List<Item> itemList = new ArrayList<>();
    Knapsack knapsack = new Knapsack();
    double maxSum = 0;

    public DynamicSolution(List<Item> itemList, Knapsack knapsack) {
        this.itemList = itemList;
        this.knapsack = knapsack;
    }

    public double getMaxSum() {
        return maxSum;
    }

    public void selectItems() {
        int m[][] = new int[itemList.size() + 1][(int) Math.round(knapsack.getCapacity() + 1)];
        for (int i = 0; i <= itemList.size(); i++) {
            for (int j = 0; j <= knapsack.getCapacity(); j++) {
                if (i == 0 || j == 0) {
                    m[i][j] = 0;
                } else if (itemList.get(i - 1).getWeight() <= j) {
                    m[i][j] = Math.max((int) itemList.get(i - 1).getValue() + m[i - 1][(int) Math.round(j - itemList.get(i - 1).getWeight())], (int) Math.round(m[i - 1][j]));
                    System.out.println(itemList.get(i-1).getName());
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
        }
        maxSum = m[itemList.size()][(int) knapsack.getCapacity()];
    }
}
