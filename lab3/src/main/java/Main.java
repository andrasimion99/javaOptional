import org.graalvm.compiler.api.runtime.GraalRuntime;

import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String args[]) {
        Knapsack knapsack1 = new Knapsack();
        Item item1 = new Book("A beautiful tale", 300, 5);
        Item item2 = new Food("Banana", 2);
        Item item3 = new Weapon(WeaponType.Sword, 5, 10);
        Item item4 = new Book("Dragon Rising", 300, 5);
        Item item5 = new Food("Cabbage", 2);
        Item item6 = new Weapon(WeaponType.Sword, 5, 100);

        knapsack1.setCapacity(40);
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
        knapsack2.setCapacity(10);
        knapsack2.addItem(item1);
        knapsack2.addItem(item2);
        knapsack2.addItem(item3);
        knapsack2.addItem(item4);
        knapsack2.addItem(item5);

        System.out.println();

        GreedySolution greedy = new GreedySolution(knapsack2.getItems(), knapsack2);
        System.out.println("Chosen items in greedy method: ");
        greedy.selectItems();
        System.out.print("Suma max obtinuta: ");
        System.out.println(greedy.getMaxSum());

        System.out.println();

        Knapsack knapsack3 = new Knapsack();
        knapsack3.setCapacity(10);
        knapsack3.addItem(item1);
        knapsack3.addItem(item2);
        knapsack3.addItem(item3);
        knapsack3.addItem(item4);
        knapsack3.addItem(item5);
        DynamicSolution dynamic = new DynamicSolution(knapsack3.getItems(), knapsack3);
        System.out.println("Chosen items in dynamic programming method: ");
        dynamic.selectItems();
        System.out.print("Suma max obtinuta: ");
        System.out.println(dynamic.getMaxSum());
    }
}
