class Solution {
    private boolean findCycle(int index, int[] visited, int[][] graph) {
        if (visited[index] == 2) {
            return false;
        }
        
        if (visited[index] == 1) {
            return true;
        }
        
        
        visited[index] = 1;
        for (int neighbor : graph[index]) {
            if (findCycle(neighbor, visited, graph)) {
                return true;
            }
        }

        
        visited[index] = 2;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
       
        int[] visited = new int[graph.length];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!findCycle(i, visited, graph)) {
                result.add(i);
            }
        }
        return result;
    }
}
