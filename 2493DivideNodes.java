class Solution {
    public int magnificentSets(int n, int[][] edges){
        List<Integer>graph[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++)graph[i]=new ArrayList<>();
    
        for(int edge[]:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        
        int color[]=new int[n+1];
        Arrays.fill(color,-1);
        List<List<Integer>>components=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            if(color[i]==-1){ 
                List<Integer>component=new ArrayList<>();
                if(!isBipartiteBFS(i,graph,color,component))return -1;
                components.add(component);
            }
        }

       
        int maxGroups=0;
        for(List<Integer>component:components){
            maxGroups+=getMaxBFSDepth(component,graph);
        }
        
        return maxGroups;
    }

  
    private boolean isBipartiteBFS(int start, List<Integer>graph[],int color[],List<Integer>component) {
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(start);
        color[start]=0;
        component.add(start);
        
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int neighbor:graph[node]){
                if(color[neighbor]==-1){  
                    color[neighbor]=1-color[node]; 
                    queue.offer(neighbor);
                    component.add(neighbor);
                } 
                else if(color[neighbor]==color[node]){
                    return false; 
                }
            }
        }
        return true;
    }

    
    private int getMaxBFSDepth(List<Integer>component,List<Integer>graph[]) {
        int maxDepth=0;
        
        for(int node:component) {
            maxDepth=Math.max(maxDepth,bfsDepth(node,graph));
        }
        return maxDepth;
    }

   
    private int bfsDepth(int start,List<Integer>graph[]){
        Queue<Integer>queue=new LinkedList<>();
        Map<Integer,Integer>depth=new HashMap<>();
        
        queue.offer(start);
        depth.put(start,1);
        int maxDepth=1;
        
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int neighbor:graph[node]){
                if(!depth.containsKey(neighbor)){
                    depth.put(neighbor, depth.get(node) + 1);
                    maxDepth = Math.max(maxDepth, depth.get(neighbor));
                    queue.offer(neighbor);
                }
            }
        }
        return maxDepth;
    }
}
