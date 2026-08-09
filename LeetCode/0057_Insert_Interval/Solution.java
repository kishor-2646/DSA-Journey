class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[] > ans = new ArrayList<>();

        int  i  = 0;
        int n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0])
        {
                ans.add(intervals[i]);
                i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);

        while(i < n)
        {
                ans.add(intervals[i]);
                i++;
        }

        int[][] ans1=new int[ans.size()][];
        for(int j=0;j<ans.size();j++){
            ans1[j]=ans.get(j);
        }
        return ans1;
    }
}