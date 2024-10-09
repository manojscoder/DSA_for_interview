// Time for build: O(n)
// Time for query: O(log n)
// Space: O(4 * n)
public class maximumRange {
    int[] segment;
    int size;

    public maximumRange(int[] arr) {
        this.size = arr.length;
        this.segment = new int[4 * this.size];
        this.build(0, 0, this.size - 1, arr);
    }

    public void build(int index, int low, int high, int[] arr) {
        if(low == high) {
            this.segment[index] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        this.build(2 * index + 1, low, mid, arr);
        this.build(2 * index + 2, mid + 1, high, arr);
        this.segment[index] = Math.max(this.segment[2 * index + 1], this.segment[2 * index + 2]);
    }

    public int query(int index, int low, int high, int l, int r) {
        if(low >= l && high <= r) {
            return this.segment[index];
        }
        else if(high < l || low > r) {
            return Integer.MIN_VALUE;
        }
        int mid = (low + high) / 2;
        int left = this.query(2 * index + 1, low, mid, l, r);
        int right = this.query(2 * index + 2, mid + 1, high, l, r);
        return Math.max(left, right);
    }


    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 1, 4, 5, 3, 9, 6, 10};
        maximumRange DS = new maximumRange(arr);
        System.out.println("Maximum value in range 3 and 8 is: " + DS.query(0, 0, DS.size - 1, 3, 8));
        System.out.println("Maximum value in range 2 and 5 is: " + DS.query(0, 0, DS.size - 1, 2, 5));
        System.out.println("Maximum value in range 1 and 9 is: " + DS.query(0, 0, DS.size - 1, 1, 9));
    }
}
