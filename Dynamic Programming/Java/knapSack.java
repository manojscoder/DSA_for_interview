// Problem name: 0/1 KnapSack
// Time: O(n * w)
// Space: O(w) where w is the knapSack bag weight
class Item {
    String name;
    int weight, value;

    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
}

public class knapSack {
    public static void main(String[] args) {
        Item[] items = new Item[4];
        items[0] = new Item("radio", 4, 3000);
        items[1] = new Item("laptop", 3, 2000);
        items[2] = new Item("guitar", 1, 1500);
        items[3] = new Item("iphone", 1, 2000);

        int knapSackCapacity = 4;
        System.out.println("Maximum profit is " + dpKnapSack(items, knapSackCapacity));
    }

    public static int dpKnapSack(Item[] items, int knapSackWeight) {
        int len = items.length;
        int[][] DP = new int[2][knapSackWeight + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= knapSackWeight; j++) {
                if (items[i - 1].weight > j) {
                    DP[1][j] = DP[0][j];
                } else {
                    DP[1][j] = Math.max(DP[0][j], items[i - 1].value + DP[0][j - items[i - 1].weight]);
                }
            }
            // Copying the current row to the previous row for the next iteration
            for (int j = 0; j <= knapSackWeight; j++) {
                DP[0][j] = DP[1][j];
            }
        }
        return DP[1][knapSackWeight];
    }
}
