class Solution {
    public String longestPrefix(String s) {
        int i = 0, len = 0;
        int n = s.length();

        int[] lps = new int[n];

        lps[i] = 0;
        i = 1;

        while(i < n)
        {
            if(s.charAt(i) == s.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if(len != 0)
                {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return s.substring(n - lps[n - 1]);
    }
}