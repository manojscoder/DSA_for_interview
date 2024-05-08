// Problem link: https://www.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1
// Time: O(nlogn)
// Space: O(n)
class Tree
{
    ArrayList<Integer> result;
    
    ArrayList<Integer> noSibling(Node node)
    {
        result = new ArrayList<>();
        find(node);
        
        if(result.size() == 0){
            result.add(-1);
            return result;
        }
        Collections.sort(result);
        return result;
    }
    
    private void find(Node node){
        if(node == null){
            return;
        }
        
        if(node.left == null || node.right == null){
            if(node.left != null){
                result.add(node.left.data);
            }
            else if(node.right != null){
                result.add(node.right.data);
            }
        }
        
        find(node.left);
        find(node.right);
    }
}
