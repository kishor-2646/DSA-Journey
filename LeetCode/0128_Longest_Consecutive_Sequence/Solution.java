class Solution {
        // using HashMap
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums)
        {
            if(map.containsKey(num))
                continue;

            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);

            int len = left + right + 1;

            map.put(num, len);
            map.put(num - left, len);
            map.put(num + right, len);
            max = Math.max(max, len);
        }
        return max;











    }
    /* 
            Using HashSet
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums)
        {
            set.add(num);
        }
        int max = 0;
        for(int num: set)
        {
            if(!set.contains(num - 1))
            {
                int length = 1;
                int curr = num;

                while(set.contains(curr+1))
                {
                    length++;
                    curr++;
                }

                max = Math.max(max, length);
            }
        }

        return max;
    } */
}