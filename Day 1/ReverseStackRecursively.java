import java.util.Stack;
public class ReverseStackRecursively {
    /*
     * Problem: Reverse a stack using recursion only.
     * Approach: Remove all elements, insert each at the bottom recursively.
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }
    private static void insertAtBottom(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, val);
        stack.push(top);
    }
}
