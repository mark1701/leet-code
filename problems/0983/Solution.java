class Solution {
    public int mincostTickets(int[] days, int[] ticket) {
        int finalDay = days[days.length-1];
        int[] cost = new int[finalDay+1];
        HashSet<Integer> travelDays = new HashSet<>();
        for(int i : days)
            travelDays.add(i);
            
        for(int i = 1; i < cost.length; i++){
            if(!travelDays.contains(i)) {
                cost[i] = cost[i-1];
                continue;
            }
            
            int costTD = cost[Math.max(0, i-30)];
            int costSD = cost[Math.max(0, i-7)];
            
            cost[i] = Math.min(cost[i-1]+ticket[0], Math.min(costSD+ticket[1], costTD+ticket[2]));
        }
                               
        return cost[finalDay];
    }
}