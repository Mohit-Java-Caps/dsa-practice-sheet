class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0]-b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxEvents = 0;
        int i = 0, currentDay = 0;
        int n = events.length;
        while(i < n || !minHeap.isEmpty()){
            if(minHeap.isEmpty()){
                currentDay = events[i][0];
            }

            while(i < n && events[i][0] == currentDay){
                minHeap.offer(events[i][1]);
                i++;
            }

            // Attend the events with the first end day
            if(!minHeap.isEmpty()){
                minHeap.poll();
                maxEvents++;
            }

            currentDay++;

            while(!minHeap.isEmpty() && minHeap.peek() < currentDay){
                minHeap.poll();
            }
        }
        return maxEvents;
    }
}
