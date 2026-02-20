class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> rez = new ArrayList<>(k);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        while (k-- > 0 && !heap.isEmpty()) {

            int[] top = heap.poll();
            int i = top[1];
            int j = top[2];

            rez.add(List.of(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                heap.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }

        }

        return rez;
    }
}