class Task{
    int time;
    int index;
    Task(int time, int index){
        this.time = time;
        this.index = index;
    }
    
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (i, j) -> {
            if (tasks[i][0] != tasks[j][0]) {
                return Integer.compare(tasks[i][0], tasks[j][0]);
            }
            return Integer.compare(tasks[i][1], tasks[j][1]);
        });
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> 
            a.time == b.time ? Integer.compare(a.index, b.index) : Integer.compare(a.time, b.time)
        );
        int enqueueTime = tasks[indices[0]][0], processingTime = tasks[indices[0]][1];
        int currentEnd = enqueueTime + processingTime, idx = 0;
        ans[idx++] = indices[0];
        for(int i = 1; i < n; i++){
            int ind = indices[i];
            enqueueTime = tasks[ind][0];
            processingTime = tasks[ind][1];
            while(currentEnd < enqueueTime && !pq.isEmpty()){
                Task task = pq.poll();
                int time = task.time;
                int index = task.index;
                ans[idx++] = index;
                currentEnd += time;
            }
            if(currentEnd < enqueueTime) {
                currentEnd = enqueueTime + processingTime;
                ans[idx++] = ind;
                continue;
            }
            pq.add(new Task(processingTime, ind));
        }
        while(!pq.isEmpty()){
            Task task = pq.poll();
            int time = task.time;
            int index = task.index;
            ans[idx++] = index;
        }
        return ans;
    }
}