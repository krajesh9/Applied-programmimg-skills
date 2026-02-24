class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(0);
        boolean visited[]=new boolean[rooms.size()];
        visited[0]=true;
        while(!pq.isEmpty()){
            int pos=pq.poll();
            for(int num:rooms.get(pos)){
                if(visited[num]==false){
                    pq.offer(num);
                    visited[num]=true;

                }
            }
        }
        for(boolean b:visited){
            if(b==false)return false;
        }
        return true;
    }
}