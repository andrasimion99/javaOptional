import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Knapsack knapsack1 = new Knapsack();
        Item item1 = new Book("A beautiful tale", 300, 5);
        Item item2 = new Food("Banana", 2);
        Item item3 = new Weapon(WeaponType.Sword, 5, 10);
        Item item4 = new Book("Dragon Rising", 300, 5);
        Item item5 = new Food("Cabbage", 2);
        Item item6 = new Weapon(WeaponType.Sword, 5, 100);

        knapsack1.setCapacity(10);
        knapsack1.addItem(item1);
        knapsack1.addItem(item2);
        knapsack1.addItem(item3);
        knapsack1.addItem(item4);
        knapsack1.addItem(item5);
        knapsack1.addItem(item6);

        Collections.sort(knapsack1.getItems(), new SortByNames());
        System.out.println("capacity of the knapsack = " + knapsack1.getCapacity());
        System.out.println("available items:");
        //knapsack1.printItems();

        Knapsack knapsack2 = new Knapsack();
        List<Item> items = new ArrayList<>();
        knapsack2.setCapacity(10);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);

        System.out.println();

        GreedySolution greedy = new GreedySolution(items, knapsack2);
        System.out.println("Chosen items in greedy method: ");
        greedy.selectItems();
        greedy.getKnapsack().printItems();
        System.out.print("Suma max obtinuta: ");
        System.out.println(greedy.getMaxSum());

        System.out.println();

        Knapsack knapsack3 = new Knapsack();
        knapsack3.setCapacity(10);

        DynamicSolution dynamic = new DynamicSolution(items, knapsack3);
        System.out.println("Chosen items in dynamic programming method: ");
        dynamic.selectItems();
        dynamic.getKnapsack().printItems();
        System.out.print("Suma max obtinuta: ");
        System.out.println(dynamic.getMaxSum());

        System.out.println();

        Problem pb = new Problem(items);
        pb.randomItems();
        pb.randomCapacity();
        System.out.println("New problem with capacity: " + pb.getCapacity());
        System.out.println("And the items: ");
        //System.out.println(pb.getItems());
        for(Item item: pb.getItems()){
            System.out.println(item.getClass() + ": " + item.getName() + ", weight = " + item.getWeight() + ", value = " + item.getValue() + "(profit factor = " + item.profitFactor() + ")");
        }

    }
}
