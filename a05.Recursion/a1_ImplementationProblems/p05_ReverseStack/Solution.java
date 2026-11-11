package p05_ReverseStack;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty())
        {
            return;
        }

        int x = st.pop();
        reverseStack(st);
        insertAtBottom(st, x);
    }

    public static void insertAtBottom(Stack<Integer> st, int value){
        if(st.isEmpty())
        {
            st.push(value);
            return;
        }

        int x = st.pop();
        insertAtBottom(st, value);
        st.push(x);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Collections.addAll(stack,4, 1, 3, 2);
        reverseStack(stack);
        System.out.println(stack);

        Stack<Integer> stack2 = new Stack<>();
        Collections.addAll(stack2, 10, 20, -5, 7, 15);
        reverseStack(stack2);
        System.out.println(stack2);

    }
}
