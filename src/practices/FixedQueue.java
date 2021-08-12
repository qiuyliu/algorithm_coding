package practices;

public class FixedQueue {
    private int capacity;
    private int count;
    private int head;
    private int tail;
    private Object[] headArr;
    private Object[] tailArr;

    public FixedQueue(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = 0;
        this.tail = 0;
        this.headArr = new Object[capacity];
        this.tailArr = headArr;
    }

    public void offer(int num) {
        if (tail == capacity - 1) {
            Object[] newarr = new Object[capacity];
            newarr[0] = num;
            tailArr[capacity - 1] = newarr;
            tailArr = newarr;
            tail = 0;
        } else {
            tailArr[tail] = num;
        }
        tail++;
        count++;
    }

    public int poll() {
        if (count == 0) {
            return -1;
        }
        int num = (int) headArr[head];
        head++;
        count--;

//        if head is on last index
        if (head == capacity - 1) {
            headArr = (Object[]) headArr[capacity - 1];
            head = 0;
        }

        return num;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        FixedQueue sol = new FixedQueue(5);
        sol.size();
        sol.offer(1);
        sol.offer(2);
        sol.offer(3);
        sol.offer(4);
        sol.offer(5);
        sol.offer(6);
        sol.poll();
        sol.poll();
        sol.poll();
        sol.poll();
        sol.poll();
        sol.offer(1);
        System.out.println(sol.poll());
//        System.out.println(solution.findAnagrams(s, p));
    }
}
