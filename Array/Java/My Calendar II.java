// Problem link: https://leetcode.com/problems/my-calendar-ii/description
// Time: O(n)
// Space: O(n)
class MyCalendarTwo {

    List<int[]> store, overlap;

    public MyCalendarTwo() {
        this.overlap = new ArrayList<>();
        this.store = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] time : this.overlap) {
            if(!(end <= time[0] || start >= time[1])) {
                return false;
            }
        }

        for(int[] time : this.store) {
            if(!(end <= time[0] || start >= time[1])) {
                this.overlap.add(new int[] {Math.max(start, time[0]), Math.min(end, time[1])});
            }
        }

        this.store.add(new int[] {start, end});
        return true;
    }
}
