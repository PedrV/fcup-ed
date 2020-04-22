package week8;

import java.util.Scanner;

// Note: Static methods cannot call non-Static methods, even inside the same class
//     : Non-Static methods can call Static methods
//     : Static methods can be called from a different class without the creation of an instance of the class that the given method belongs to
//     : To call non-Static methods from one class, another should create an instance of the class with the method to be called


class FireFighter {
    String name;                    // Name of the firefighter
    int events_in;                  // The number of events that the firefighter was in
    int minutes_worked;             // The amount of minutes total from each event that the firefighter was in
    int start_time_of_event;
    String event_code;

    FireFighter (String name) {
        this.name = name;
        events_in = 0;
        minutes_worked = 0;
        start_time_of_event = 0;
        event_code = "";
    }
}


class Station {
    private MyQueue<FireFighter> firefighters;
    private DoublyLinkedList<FireFighter> ffDeployed;
    private int number_of_firefighters;

    // Initialize the Station
    Station (int number_of_firefighters) {
        firefighters = new LinkedListQueue<>();
        ffDeployed = new DoublyLinkedList<>();
        this.number_of_firefighters = number_of_firefighters;
    }

    // Read from the Stdin the names of the firefighters from that station
    public void readNames (Scanner scan) {
        for (int i = 0; i < number_of_firefighters; i++) {
          FireFighter f = new FireFighter(scan.nextLine());
          firefighters.enqueue(f); 
        }
    } 


    // Show the Firefighters of the Station and their events and time on events -- Needed for flag 3
    public void displayFirefighters () {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < number_of_firefighters; i++) {
            System.out.printf("%d: %6s | %6d events | %6d time in events\n", i+1, firefighters.first().name, firefighters.first().events_in, firefighters.first().minutes_worked);

            FireFighter temp = firefighters.dequeue();      // The firefighters are represent by a queue, so its impossible to see whats behind the first
            firefighters.enqueue(temp);                     // without getting him out of the way. This 2 actions take the first and them puts im back at the end of the queue
        }
        System.out.println("-------------------------------------------------");
    }

    public void simulateEvents (DoublyLinkedList<String> evd, int flag) {
        
        
    }

    public void startEvents (Scanner scan, int flag) {
        String events = "START";                                                                                    
        int number_of_events = 0;

        while (!events.equals("FIM")) {
            events = scan.nextLine();

            Scanner eventDetails = new Scanner(events);
            while (eventDetails.hasNext()) {
                String temp = eventDetails.next();


                if (temp.equals("PARTIDA")) {
                    String code = eventDetails.next();                              // add to the archive of each event the code of that event
                    int howM = Integer.parseInt(eventDetails.next());               // see how many firefighters we need to dispatch
                    int dispatch_hour = Integer.parseInt(eventDetails.next());      // add to the archive of each event the starting hour of that event
                    number_of_events++;

                    FireFighter preprationPhase;

                    if (flag == 2) {
                        System.out.println("Bombeiros Destacados");
                    }
                    boolean nondeployed = true;

                    for (int i = 0; i < howM; i++) {
                        
                        if (!firefighters.isEmpty()) {

                            nondeployed = false;

                            if (flag == 2) {
                                System.out.println("EVENTO " + code);
                            }

                            preprationPhase = firefighters.dequeue();
                            preprationPhase.event_code = code;
                            preprationPhase.start_time_of_event = dispatch_hour;

                            ffDeployed.addLast(preprationPhase);
                                                    
                            if (flag == 2) {
                                System.out.println(preprationPhase.name);
                            } 

                        } else if (!firefighters.isEmpty() && flag == 2 && nondeployed) {
                            System.out.println("Nenhum");
                        }


                    }
                    

                } else if (temp.equals("CHEGADA")) {

                    String code = eventDetails.next();                              // Get the code of the event
                    int arrive_time = Integer.parseInt(eventDetails.next());        // Get the end time of the event

                    for (int i = 0; i < ffDeployed.size(); i++) {
                        FireFighter f = ffDeployed.get(i);

                        if (f.event_code.equals(code)) {
                            f.minutes_worked += (arrive_time - f.start_time_of_event);
                            firefighters.enqueue(ffDeployed.remove(i));
                        }
                    }

                }

            }

            eventDetails.close();
        }

        if (flag == 1) {
            System.out.println("Ocorreram " + number_of_events + " eventos");
        }
    }

}


public class ED095 {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        int flag = scan.nextInt();
        int number_of_firefighters = scan.nextInt();
        scan.nextLine();

        Station station1 = new Station(number_of_firefighters);

        station1.readNames(scan);
        station1.startEvents(scan, flag);
           
    }
        
}