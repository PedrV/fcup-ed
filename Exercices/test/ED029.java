package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class PairComp implements Comparator<Pair<String,Integer>> {

    public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
        return o1.getYvalue()-o2.getYvalue();
    }
}

class ControlAirport {
    private PriorityQueue<Pair<String,Integer>> land;
    private PriorityQueue<Pair<String,Integer>> takeoff;
    private int airplanes_takeoff;
    private int airplanes_land;
    private ArrayList<Pair<String,Integer>> landed;
    private ArrayList<Pair<String,Integer>> onair;

    ControlAirport (PriorityQueue<Pair<String,Integer>> land, PriorityQueue<Pair<String,Integer>> takeoff) {
        this.land = land;
        this.takeoff = takeoff;
        airplanes_takeoff = takeoff.size();
        airplanes_land = land.size();
        landed = new ArrayList<>(land.size());
        onair = new ArrayList<>(takeoff.size());
    }

    public void initLandingZone () {
        int timer = 1;

        // There are planes wanting to take off and planes wanting to land
        while (land.peek() != null && takeoff.peek() != null) {
            if (land.peek().getYvalue() <= takeoff.peek().getYvalue()) {
                Pair<String,Integer> p = land.remove();
                p.setYvalue(timer-p.getYvalue());
                landed.add(p);

            } else {
                Pair<String,Integer> p = takeoff.remove();
                p.setYvalue(timer-p.getYvalue());
                onair.add(p);
            }

            timer++;
        }

        // Is only planes wanting to take off or wanting to land
        while (land.peek() != null || takeoff.peek() != null) {
            if (land.peek() != null) {
                Pair<String,Integer> p = land.remove();
                p.setYvalue(timer-p.getYvalue());
                landed.add(p);

            } else {
                Pair<String,Integer> p = takeoff.remove();
                p.setYvalue(timer-p.getYvalue());
                onair.add(p);
            }

            timer++;
        }

        result();
    }

    private void result () {
        System.out.println(airplanes_takeoff + " " + airplanes_land);

        for (Pair<String,Integer> p : onair) 
            System.out.println(p.getXvalue() + " " + p.getYvalue()); 

        for (Pair<String,Integer> p : landed) 
            System.out.println(p.getXvalue() + " " + p.getYvalue());
    }
}

public class ED029 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        PriorityQueue<Pair<String,Integer>> minHeapTakeOff = new PriorityQueue<>(new PairComp());
        PriorityQueue<Pair<String,Integer>> minHeapLand = new PriorityQueue<>(new PairComp());

        while (n > 0) {

            int levantar = scan.nextInt();
            int aterrar = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < levantar; i++) {
                String[] temp = scan.nextLine().split(" ");
                Pair<String,Integer> pt = new Pair<>(temp[0], Integer.parseInt(temp[1]));
                minHeapTakeOff.add(pt);
            }

            for (int i = 0; i < aterrar; i++) {
                String[] temp = scan.nextLine().split(" ");
                Pair<String,Integer> pt = new Pair<>(temp[0], Integer.parseInt(temp[1]));
                minHeapLand.add(pt);
            }

            ControlAirport a1 = new ControlAirport(minHeapLand, minHeapTakeOff);
            a1.initLandingZone();


            // 99.9% sure is not necessary because all planes must go somewhere at the end but, better safe than sorry
            // We dont want to mess with planes..
            minHeapLand.clear();
            minHeapTakeOff.clear();
            n--;
        }
        
        scan.close();
    }
}