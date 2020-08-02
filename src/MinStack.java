import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int ele) {
        stack.offerFirst(ele);
        if (minStack.isEmpty() || ele < minStack.peekFirst()) {
            minStack.offerFirst(ele);
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        Integer res = stack.pollFirst();
        if (minStack.peekFirst().equals(res)) {
            minStack.pollFirst();
        }
        return res;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }

    public static void main(String[] args) {
        MinStack sol = new MinStack();
        sol.push(1);
        sol.push(2);
        System.out.println(sol.min());
        System.out.println(sol.top());
        sol.pop();
        System.out.println(sol.top());
        System.out.println(sol.min());
        sol.pop();
        System.out.println(sol.top());
        System.out.println(sol.min());
    }
}
