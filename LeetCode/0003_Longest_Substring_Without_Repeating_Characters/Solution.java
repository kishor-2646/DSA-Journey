class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;

        if(s == null || s.length() < 2)
         return s;

        for(int i = 0; i < n; i++)
        {
            int oddLen = expand(s, i, i);

            int evenLen = expand(s, i, i + 1);

            int len = Math.max(oddLen, evenLen);

            if(len > end - start + 1)
            {
                start = i - (len - 1) / 2;
                end = i + (len ) / 2; 
            }
        }

        return s.substring(start, end + 1);
    }

    public int expand(String s, int st, int e){
        while(st >= 0 && e < s.length() && s.charAt(st) == s.charAt(e))
        {
            st--;
            e++;
        }

        return e - st - 1; 
    }
}