// Problem link: https://www.geeksforgeeks.org/problems/reverse-level-order-traversal/1
// Time: O(n)
// Space: O(n)
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            Node n = queue.poll();
            result.add(n.data);
            if(n.right != null){
                queue.add(n.right);
            }
            if(n.left != null){
                queue.add(n.left);
            }
        }
        
        Collections.reverse(result);
        return result;
    }
} 
