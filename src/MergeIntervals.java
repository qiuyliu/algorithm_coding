import java.util.*;

class Interval {
    public int start;
    public int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
  }

public class MergeIntervals {
    public int length(List<Interval> intervals) {
        // Write your solution here.
        // sort intervals
        if (intervals == null || intervals.size() < 1) {
            return 0;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> res = new ArrayList<>();
        int duration = 0;
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (prev.end > cur.start) {
                prev.end = Math.max(prev.end, cur.end);
            } else {
                res.add(prev);
                prev = cur;
            }
        }
        res.add(prev);
        for (Interval t : res) {
            int d = t.end - t.start;
            duration += d;
        }

        return duration;
    }

    public static void main(String[] args) {
        MergeIntervals sol = new MergeIntervals();
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(1, 2));
        input.add(new Interval(2, 5));
        input.add(new Interval(6, 9));
        input.add(new Interval(7, 9));
        System.out.println(sol.length(input));
    }
}
