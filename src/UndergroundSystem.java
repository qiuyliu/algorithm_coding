import java.util.*;
import javafx.util.Pair;
/*
hashmap maping check in info: id - stationName - time - <id, <name, time>>
hashmap maping trip info:  key - <start, end> , val <totaltime, count>
*/
public class UndergroundSystem {

    private Map<Integer, Pair<String, Integer>> checkInMap;
    private Map<Pair<String, String>, Pair<Double, Double>> tripMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        tripMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<String, Integer>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        String start = checkInMap.get(id).getKey();
        double duration = (double) t - checkInMap.get(id).getValue();
        Pair<String, String> tripKey = new Pair<>(start, stationName);
        Pair<Double, Double> data  = tripMap.getOrDefault(tripKey, new Pair<Double, Double>(0.0, 0.0));
        Double totalTime = duration + data.getKey();
        Double count = 1 + data.getValue();
        tripMap.put(tripKey, new Pair<Double, Double>(totalTime, count));
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String> tripKey = new Pair<>(startStation, endStation);
        Double totalTime = tripMap.get(tripKey).getKey();
        Double count = tripMap.get(tripKey).getValue();
        return totalTime / count;

    }
    public static void main(String[] args) {
        UndergroundSystem us = new UndergroundSystem();
        us.checkIn(45,"Leyton",3);
        us.checkIn(32,"Paradise",8);
        us.checkIn(27,"Leyton",10);
        us.checkOut(45,"Waterloo",15);
        us.checkOut(27,"Waterloo",20);
        us.checkOut(32,"Cambridge",22);
        System.out.println(us.getAverageTime("Paradise","Cambridge"));
        us.getAverageTime("Leyton","Waterloo");
        us.checkIn(10,"Leyton",24);
        System.out.println(us.getAverageTime("Leyton","Waterloo"));
        us.checkOut(10,"Waterloo",38);
        System.out.println(us.getAverageTime("Leyton","Waterloo"));
    }
}
