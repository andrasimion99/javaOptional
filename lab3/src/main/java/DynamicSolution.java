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
                    //System.out.println(itemList.get(i-1).getName());
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
        }
        maxSum = m[itemList.size()][(int) knapsack.getCapacity()];
        for (int i = itemList.size(); i > 0 && maxSum > 0; i--) {
            int elementWeight = (int) this.itemList.get(i - 1).getWeight();
            int elementValue = (int) this.itemList.get(i - 1).getValue();
            if (maxSum == m[i - 1][(int) knapsack.getCapacity()])
                continue;
            else {
                //this.knapsack.addItem(this.itemList.get(i - 1));
                System.out.println(itemList.get(i - 1).getClass() + ": " + itemList.get(i - 1).getName() + ", weight = " + itemList.get(i - 1).getWeight() + ", value = " + itemList.get(i - 1).getValue() + "(profit factor = " + itemList.get(i - 1).profitFactor() + ")");
                maxSum -= elementValue;
                knapsack.setCapacity(knapsack.getCapacity() - elementWeight);
            }
        }
    }
}
