package practices;

import java.util.*;

public class TopKFrequency {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        if (combo == null || combo.length < 1 || k < 1 || k > combo.length) {
            return new String[]{};
        }
        // hashmap to contain <str, freq>
        HashMap<String, Integer> strMap = new HashMap<>();
        for (String str : combo) {
            if (!strMap.containsKey(str)) {
                strMap.put(str, 1);
            }
            strMap.put(str, strMap.get(str) + 1);
        }

        // k size min heap with map entry to sort out the top k freq
        PriorityQueue<Map.Entry<String, Integer>> countHeap = new PriorityQueue<>(k, (a, b) ->
                a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> i : strMap.entrySet()) {
            if (countHeap.size() < k) {
                countHeap.offer(i);
            } else if (i.getValue() > countHeap.peek().getValue()) {
                countHeap.poll();
                countHeap.offer(i);
            }
        }
        String[] res = new String[countHeap.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = countHeap.poll().getKey();
        }
//
//        List<String> res = new ArrayList<>();
//        if (words == null || words.length == 0 || k > words.length || k < 1) {
//            return res;
//        }
//
////         freq map for mapping words: count
//        HashMap<String, Integer> freqMap = new HashMap<>();
//        for (String s : words) {
//            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
//        }

//         k size minheap, push freqmap entry into minheap
//         size < k, keep push
//         else: if entry > minheap.top(), pop and push
//        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, (a, b) ->
//                a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue());
//
//        for (Map.Entry<String,Integer> cur : freqMap.entrySet() ) {
//            if (minHeap.size() < k) {
//                minHeap.offer(cur);
//            } else if (cur.getValue() > minHeap.peek().getValue()) {
//                minHeap.poll();
//                minHeap.offer(cur);
//            }
//        }
//
//        for (Map.Entry<String,Integer> entry : freqMap.entrySet() ) minHeap.add(entry);
//        while (res.size() < k) {
//            res.add(minHeap.poll().getKey());
//        }
//        List<String> res = new ArrayList<String>();
//        Map<String, Integer> map = new HashMap<String, Integer>();    //o(n)
//
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word,0) + 1);
//        }
//        //System.out.println(map);
//        //max-heap
//        PriorityQueue<Map.Entry<String,Integer>> maxHeap = new PriorityQueue<>(k, (a,b) ->
//                a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue());
//        // if same frequency, then sort alphabetical .
//
//        for (Map.Entry<String,Integer> entry : map.entrySet() ) maxHeap.add(entry);
//
//        while (res.size() < k) res.add(maxHeap.poll().getKey());  //add top k
        return res;
    }

    public int missing(int[] array) {
        // Write your solution here
        if (array == null|| array.length < 1) {
            return 1;
        }
        boolean[] miss = new boolean[array.length + 1];
        for (int i : array) {
            miss[i] = true;
        }
        for (int j = 1; j < miss.length; j++) {
            if (false) {
                return j;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        TopKFrequency tk = new TopKFrequency();
        String[] combo = {"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        int k = 5;
        System.out.println(tk.topKFrequent(combo, k));
        int[] arr = {12,11,10,9,4,5,6,7,2,3,8};
//        System.out.println(tk.missing(arr));
    }
}
