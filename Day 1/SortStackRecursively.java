import java.util.Stack;
public class SortStackRecursively {
    /*
     * Problem: Sort a stack using recursion only.
     * Approach: Remove all elements, insert each in sorted order recursively.
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        sortStack(stack);
        insertSorted(stack, top);
    }
    private static void insertSorted(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || stack.peek() <= val) {
            stack.push(val);
            return;
        }
        int top = stack.pop();
        insertSorted(stack, val);
        stack.push(top);
    }
}
