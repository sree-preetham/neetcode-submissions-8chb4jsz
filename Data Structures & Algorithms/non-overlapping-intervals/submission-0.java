class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[1]!=b[1]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        int[] prev = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int count = 0;
        for(int[] interval: intervals){
            if(interval[0] < prev[1]) {
                count++;
                continue;
            }
            prev[0] = interval[0];
            prev[1] = interval[1];
        }
        return count;
    }
}
