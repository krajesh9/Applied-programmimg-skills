class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public void preOrder(TreeNode root, int y, int x, Map<Integer, List<int[]>> hm){
        if(root == null) return;

        hm.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{x, root.val});
        preOrder(root.left, y-1, x+1, hm);
        preOrder(root.right, y+1, x+1, hm);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> hm = new TreeMap<>();

        preOrder(root, 0, 0, hm);

        for(List<int[]> vals : hm.values()){
            // sort by row (x) asc, then value asc
            Collections.sort(vals, (a, b) -> {
                if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            List<Integer> col = new ArrayList<>();
            for(int[] pair : vals) col.add(pair[1]);
            list.add(col);
        }

        return list;
    }
}
