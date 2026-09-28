class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                stack.push(ch);
                depth++;
                if(depth > max)
                {
                    max = depth;
                }
            }
            else if(ch == ')')
            {
                stack.pop();
                depth--;
            }
           
        }
        return max;
    }
}