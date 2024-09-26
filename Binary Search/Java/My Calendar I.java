// Problem link: https://leetcode.com/problems/my-calendar-i/description
// Time: O(n)
// Space: O(n)
class MyCalendar {

    List<int[]> store;

    public MyCalendar() {
        this.store = new ArrayList<>();
        
    }
    
    public boolean book(int start, int end) {
        int left = 0, right = this.store.size() - 1, mid, st, ed;

        while(left <= right) {
            mid = (left + right) / 2;

            st = this.store.get(mid)[0];
            ed = this.store.get(mid)[1];

            if(!(end <= st || start >= ed)) {
                return false;
            }

            if(ed <= start) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        this.store.add(left, new int[] {start, end});
        return true;
    }
}
