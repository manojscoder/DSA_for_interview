// Problem link: https://leetcode.com/problems/design-a-number-container-system/description/
// Time: O(log n)
// Space: O(n)
class NumberContainers {

    Map<Integer, Integer> index_mapping;
    Map<Integer, TreeSet<Integer>> mapping;

    public NumberContainers() {
        this.index_mapping = new HashMap<>();
        this.mapping = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(this.index_mapping.containsKey(index)) {
            int num = this.index_mapping.get(index);
            this.mapping.get(num).remove(index);
            if(this.mapping.get(num).size() == 0) {
                this.mapping.remove(num);
            }
        }

        this.mapping.putIfAbsent(number, new TreeSet<>());
        this.mapping.get(number).add(index);
        this.index_mapping.put(index, number);
    }
    
    public int find(int number) {
        if(this.mapping.containsKey(number)) {
            return this.mapping.get(number).first();
        }
        return -1;
    }
}
