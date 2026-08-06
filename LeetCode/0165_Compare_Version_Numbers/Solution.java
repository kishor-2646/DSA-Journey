class Solution {
   // optimal approach s(n) = O(1) , t(n) = O(n + m)

    public int compareVersion(String version1, String version2) {
          int n = version1.length();
          int m = version2.length();

          int i = 0, j = 0;

          while(i < n || j < m)
          {
            int d1 = 0;
            int d2 = 0;

            while(i < n && version1.charAt(i) != '.')
            {
                d1 = d1 * 10 + version1.charAt(i) - '0';
                i++;
            }

            while(j < m && version2.charAt(j) != '.')
            {
                d2 = d2 * 10 + version2.charAt(j) - '0';
                j++;
            }

            if(d1 > d2)
                return 1;

            if(d2 > d1)
                return -1;


            i++;
            j++;
          }  

            return 0;            
            
    }
    





   /* 
            Better Approach s(n) = O(n + m) , t(n) = O(n + m)

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n = Math.max(v1.length, v2.length);

        for(int i = 0; i < n; i++)
        {
            int d1 = (i < v1.length)? Integer.parseInt(v1[i]): 0;
            int d2 = (i < v2.length)? Integer.parseInt(v2[i]): 0;

            if(d1 < d2)
                return -1;

            if(d1 > d2)
                return 1;
        }

        return 0;
    } */
}