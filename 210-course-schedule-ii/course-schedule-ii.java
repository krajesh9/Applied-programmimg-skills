class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for(int i = 0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            graph.get(v).add(u);
            inDegree[u]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i<numCourses;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        int completed = 0;
        int[] res = new int[numCourses];

        while(!queue.isEmpty()){
            int current = queue.poll();
            res[completed] =  current;
            completed++;

            for(int neighbour: graph.get(current)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

        if(completed != numCourses){
            return new int[0];
        }
        
        return res;
    }
}