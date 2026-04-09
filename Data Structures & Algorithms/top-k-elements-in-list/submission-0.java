class Pair{
    int frequency;
    int value;
    Pair(int frequency, int value){
        this.frequency = frequency;
        this.value = value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);
        for(int num : nums){
            int count = mp.getOrDefault(num,0);
            mp.put(num, count + 1);
        }
        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            int frequency = entry.getValue();
            int value = entry.getKey();
            Pair pair = new Pair(frequency, value);
            pq.add(pair);
        }
        while(k > 0){
            ans[k-1] = pq.poll().value;
            k--;
        }
        return ans;
    }
}