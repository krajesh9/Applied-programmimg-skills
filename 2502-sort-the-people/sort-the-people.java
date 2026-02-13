class Pair {
    private String name;
    private int height;
    public Pair(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            new Comparator<>() {
                @Override 
                public int compare(Pair a, Pair b) {
                    return b.getHeight() - a.getHeight();
                }
            }
        );

        int index = 0;
        while(index < names.length) {
            maxHeap.add(new Pair(names[index], heights[index]));
            index++;
        }

        index = 0;
        
        String[] result = new String[names.length];
        while(!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll().getName();
        }

        return result;
    }
}