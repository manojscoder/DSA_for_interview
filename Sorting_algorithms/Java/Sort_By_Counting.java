// Time: O(n ^ 2)
// Space: O(n)
// Without duplicates
private static int[] sortByCounting(int[] arr,int len) {
  
        int[] count = new int[len];
        int[] result = new int[len];
        
        for(int idx = 0; idx < len - 1; idx++) {
            for(int i = idx + 1; i < len; i++) {
                if(arr[idx] < arr[i]) {
                    count[i] += 1;
                }
                else {
                    count[idx] += 1;
                }
            }
        }
        
        
        for(int idx = 0; idx < len; idx++) {
            result[count[idx]] = arr[idx];
        }
        
        return result;
        
}

// Time: O(n + k)
// Space: O(n + k)
// With duplicates
private static int[] sortByCount(int[] arr, int len) {
        int low = Integer.MAX_VALUE, up = Integer.MIN_VALUE;
        
        for(int num : arr) {
            low = Math.min(low, num);
            up = Math.max(up, num);
        }
        
        int[] count = new int[up - low + 1];
        int[] result = new int[len];
        
        for(int num : arr) {
            count[num - low]++;
        }
        
        for(int idx = 1; idx < count.length; idx++) {
            count[idx] += count[idx - 1];
        }
        
        for(int num : arr) {
            result[count[num - low] - 1] = num;
            count[num - low]--;
        }
        
        return result;
  }

