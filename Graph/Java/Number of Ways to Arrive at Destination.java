class Solution {
    public int countPaths(int numIntersections, int[][] roads) {
        ArrayList<ArrayList<Node>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numIntersections; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int intersection1 = road[0], intersection2 = road[1], travelTime = road[2];
            adjacencyList.get(intersection1).add(new Node(travelTime, intersection2));
            adjacencyList.get(intersection2).add(new Node(travelTime, intersection1));
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>((x, y) -> Long.compare(x.distanceFromSource, y.distanceFromSource));
        long[] distanceFromSource = new long[numIntersections];
        int[] numWaysToReach = new int[numIntersections];
        for (int i = 0; i < numIntersections; i++) {
            distanceFromSource[i] = Long.MAX_VALUE;
            numWaysToReach[i] = 0;
        }
        distanceFromSource[0] = 0;
        numWaysToReach[0] = 1;
        minHeap.add(new Node(0, 0));
        int modulo = (int) (1e9 + 7);
        while (!minHeap.isEmpty()) {
            long currentDistance = minHeap.peek().distanceFromSource;
            int currentIntersection = minHeap.peek().intersection;
            minHeap.remove();
            for (Node neighbor : adjacencyList.get(currentIntersection)) {
                long neighborIntersection = neighbor.intersection;
                long travelTimeToNeighbor = neighbor.distanceFromSource;
                if (currentDistance + travelTimeToNeighbor < distanceFromSource[(int) neighborIntersection]) {
                    distanceFromSource[(int) neighborIntersection] = currentDistance + travelTimeToNeighbor;
                    minHeap.add(new Node(currentDistance + travelTimeToNeighbor, (int) neighborIntersection));
                    numWaysToReach[(int) neighborIntersection] = numWaysToReach[currentIntersection];
                } else if (currentDistance + travelTimeToNeighbor == distanceFromSource[(int) neighborIntersection]) {
                    numWaysToReach[(int) neighborIntersection] = (numWaysToReach[(int) neighborIntersection] + 
                                                                 numWaysToReach[currentIntersection]) % modulo;
                }
            }
        }
        return numWaysToReach[numIntersections - 1] % modulo;
    }
    class Node {
        long distanceFromSource;
        int intersection;
        Node(long distanceFromSource, int intersection) {
            this.distanceFromSource = distanceFromSource;
            this.intersection = intersection;
        }
    }
}
