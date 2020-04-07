package week7;

import java.util.Scanner;

class PlaneSimulation {
    private MyQueue <String> land;
    private MyQueue <String> taking_off;
    private Scanner scan;
    private String[] placard;

    PlaneSimulation (Scanner scan) {
        this.scan = scan;
        land = new LinkedListQueue<>();
        taking_off = new LinkedListQueue<>();
    }

    public void collectData () {
        int how_may = scan.nextInt();
        scan.nextLine(); // dispose of new line left

        while (how_may > 0) {

            int taking_off = scan.nextInt();
            int land = scan.nextInt();
            scan.nextLine(); // dispose of new line left
    
            placard = new String[(taking_off+land)*2];


             for(int i = 0, j = 0; i < taking_off; i++, j += 2) {
                String name = scan.next(); // store temporarily the name of the plane beacause the form of data stored is going to be: time plane_name, not plane_name time
                String arrive = scan.next();
                this.taking_off.enqueue(arrive);
                this.taking_off.enqueue(name);
                placard[j] = name; 
                placard[j+1] = arrive; 
            }

            for(int i = 0, j = taking_off*2; i < land ; i++,j += 2) {
                String name = scan.next(); // store temporarily the name of the plane beacause the form of data stored is going to be: time plane_name, not plane_name time
                String arrive = scan.next();
                this.land.enqueue(arrive);
                this.land.enqueue(name);
                placard[j] = name;
                placard[j+1] = arrive; 
            }

            controlFlights();

            System.out.println(taking_off + " " + land);
            for(int i = 0; i < placard.length; i += 2) {
                System.out.println(placard[i] + " " + placard[i+1]);
            }

            how_may--;
        }
    }


    private void controlFlights () {
        int time = 1;
        boolean empty = false;

        while (!taking_off.isEmpty() || !land.isEmpty()) { 

            if (taking_off.isEmpty()) { // there are no planes wanting to take off

                int arrival_time = Integer.parseInt(land.dequeue());
                updatePlacard( (time-arrival_time), land.dequeue() );
                time++; // each plane takes 1 minute to land
                empty = true;

            } else if (land.isEmpty()) { // there are no planes wanting to land

                int arrival_time = Integer.parseInt(taking_off.dequeue());
                updatePlacard( (time-arrival_time), taking_off.dequeue() );
                time++; // each plane takes 1 minute to take off
                empty = true;
            }


            if (!empty) {
                 if ( Integer.parseInt(taking_off.first()) < Integer.parseInt(land.first()) ) { // the plane who arrives first gets cleared first

                    int arrival_time = Integer.parseInt(taking_off.dequeue());
                    updatePlacard( (time-arrival_time), taking_off.dequeue() );

                    time++; // each plane takes 1 minute to take off

                } else if ( Integer.parseInt(taking_off.first()) > Integer.parseInt(land.first()) ) { // the plane who arrives first gets cleared first

                    int arrival_time = Integer.parseInt(land.dequeue());
                    updatePlacard( (time-arrival_time), land.dequeue() );

                    time++; // each plane takes 1 minute to land

                } else if ( Integer.parseInt(taking_off.first()) == Integer.parseInt(land.first()) ) { // if 2 planes arrive at the same time, one landing and another taking off, whos landing has priority

                    int arrival_time = Integer.parseInt(land.dequeue());
                    updatePlacard( (time-arrival_time), land.dequeue());

                    time++; // each plane takes 1 minute to land

                }
            }

        }

    }


    private void updatePlacard (int delay, String planeName) {

        for(int i = 0; i < placard.length ; i += 2) {
            if (placard[i].equals(planeName)) {
                placard[i+1] = String.valueOf(delay); // in the placard, the delay of the plane is immediately after the name
                break;
            }
        }

    }

}


public class ED029 {

    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        PlaneSimulation simulation1 = new PlaneSimulation(scan);

        simulation1.collectData();

    }

}