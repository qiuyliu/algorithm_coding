import java.util.*;
import java.lang.*;
import static java.util.Arrays.asList;

public class Queue {

    public static void main(String[] args) {
//        queue
//        Queue<Integer> q = new LinkedList<Integer>();
//        Stack<Integer> s = new LinkedList<>();
//        Deque<Integer> s = new LinkedList<>();
//        int[] arr = new int[]{5,1,2,3,4};
//        int[] copy = Arrays.copyOf(arr, arr.length);
//        Arrays.sort(copy);
//        List<Integer> list = Arrays.asList(2,2,3);
//        System.out.println(Arrays.toString(copy));
//        System.out.println(list);
        List<Object> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        List<Integer> sub = new ArrayList<>();
        sub.add(3);
        sub.add(4);
        input.add(sub);
        System.out.println(input);
        List<Object> list = asList(asList(1, 2), 3, 4, asList(5, asList(6, 7)));
        List<Object> flatList = flatten(list);
        System.out.println(flatList);
    }

    public static List<Object> flatten(List<Object> input) {
        List<Object> res = new ArrayList<>();
        LinkedList<Object> stack = new LinkedList<>(input);
        while(!stack.isEmpty()) {
            Object e = stack.pop();
            if (e instanceof List<?>) {
                stack.addAll(0, (List<?>)e);
            } else {
                res.add(e);
            }
        }
        return res;
    }

}
