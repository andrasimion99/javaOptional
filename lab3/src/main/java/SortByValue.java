import java.util.Comparator;

public class SortByValue implements Comparator<Item> {
    public int compare(Item item1, Item item2) {
        return new Double(item1.profitFactor()).compareTo(new Double(item2.profitFactor()));
    }
}
