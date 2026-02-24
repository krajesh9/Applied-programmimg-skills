class Solution {
    public class Pair {
        int vtx;
        int color;

        public Pair(int vtx, int color) {
            this.vtx = vtx;
            this.color = color;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, List<Integer>> red = new HashMap<>();
        HashMap<Integer, List<Integer>> blue = new HashMap<>();
        for (int[] arr : redEdges) {
            int a = arr[0];
            int b = arr[1];
            red.putIfAbsent(a, new ArrayList<>());
            red.get(a).add(b);
        }

        for (int[] arr : blueEdges) {
            int a = arr[0];
            int b = arr[1];
            blue.putIfAbsent(a, new ArrayList<>());
            blue.get(a).add(b);
        }

        int level = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[][] vis = new int[n][2];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        q.add(new Pair(0, 1));
        vis[0][0] = 1;
        vis[0][1] = 1;
        while (!q.isEmpty()) {
            int N = q.size();
            while (N-- > 0) {

                Pair rv = q.poll();
                int node = rv.vtx;
                int color = rv.color;
                if (ans[node] == -1) {
                    ans[node] = level;
                }
                if (color == 0) {
                    for (int nbrs : blue.getOrDefault(node, new ArrayList<>())) {
                        if (vis[nbrs][1] == 0) {
                            q.add(new Pair(nbrs, 1));
                            vis[nbrs][1] = 1;
                        }
                    }
                } else {
                    for (int nbrs : red.getOrDefault(node, new ArrayList<>())) {
                        if (vis[nbrs][0] == 0) {
                            q.add(new Pair(nbrs, 0));
                            vis[nbrs][0] = 1;
                        }
                    }
                }
            }
            level++;
        }
        return ans;
    }
}