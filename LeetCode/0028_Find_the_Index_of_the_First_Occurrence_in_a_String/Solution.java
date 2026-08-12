class Solution {
   
   // KMP - LPS[] array Approach T(N) = O(n + m)  S(N) = O(M)
    public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();

            int i = 0, j = 0;

            int[] lps = new int[m];

            computeLPS(lps,needle);

            while(i < n)
            {
                if(haystack.charAt(i) == needle.charAt(j))
                {
                    i++;
                    j++;

                    if(j == m)
                    {
                        return i - j;
                    }

                }
                else
                {
                    if(j != 0)
                    {
                        j = lps[j - 1];
                    }
                    else
                    {
                        i++;
                    }
                }
            }
   
   return -1;
   
   
   }

   public void computeLPS(int[] lps, String p)
   {
    int n = p.length();
    int i = 0, len = 0;

    lps[i] = 0;
    i = 1;

    while(i < n)
    {
        if(p.charAt(i) == p.charAt(len))
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
   }
   
   
   
   
   
   
   
   
   
   
   
   /*  
      Brute force T(N) = O(n × m), S(N) = O(1)

   public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for(int i = 0; i <= n - m; i++)
        {
            int j;

            for(j = 0; j < m; j++)
            {
                if(haystack.charAt(i + j) != needle.charAt(j))
                {
                    break;
                }
            }

            if(j == m)
                return i;
        }

        return -1;
    } */
}