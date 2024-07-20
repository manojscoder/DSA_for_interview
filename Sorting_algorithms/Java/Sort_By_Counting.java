// Time: O(n ^ 2)
// Space: O(n)
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
