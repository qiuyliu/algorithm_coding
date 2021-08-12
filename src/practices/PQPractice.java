package practices;

import java.util.PriorityQueue;

class Cell {
    int x;
    int y;
    int value;
    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

public class PQPractice {

    public static void main(String[] args) {
        PQPractice p = new PQPractice();
        PriorityQueue<Integer> pq = new PriorityQueue<>(6, (Integer a, Integer b) -> b - a);
        pq.offer(1);
        pq.offer(2);
        System.out.println(pq.peek());
    }
}
