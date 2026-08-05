import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean valid = true;

        Stack<Character> stack = new Stack<>();

        int ans = 0;
        int cnt = 0;
        for(char ch: str.toCharArray())
        {

            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else
            {
                if(ch == ')' && stack.pop() == '(') {
                    cnt++;
                    ans = Math.max(cnt,ans);

                }
                else if(ch == ']' && stack.pop() == '[')
                {
                    cnt++;
                    ans = Math.max(cnt,ans);
                }
                else if(ch == '}' && stack.pop() == '{')
                {
                    cnt++;
                    ans = Math.max(cnt,ans);
                }
                else
                {
                    cnt = 0;
                    stack.pop();
                }
            }
        }
        System.out.println(ans * 2);
    }
}
