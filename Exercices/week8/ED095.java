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


    public void startEvents (Scanner scan, int flag) {
        String events = "START";                                                                                    
        int number_of_events = 0;

        //----------------------------------------//
        if (flag == 2)
            System.out.println("Bombeiros Destacados");
        //----------------------------------------//
        

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
                    boolean nondeployed = true;


                    //----------------------------------------//
                    if (flag == 2) 
                        System.out.println("EVENTO " + code);
                    //----------------------------------------//


                    // Dispatch the number of ff necessary
                    for (int i = 0; i < howM; i++) {
                        
                        if (!firefighters.isEmpty()) {

                            nondeployed = false;

                            preprationPhase = firefighters.dequeue();               // Put firefighter in "preparationPhase", dequeue him of the ff in the Station queue
                            preprationPhase.event_code = code;                      // Give the ff the code of the event that he is going to be dispatched 
                            preprationPhase.start_time_of_event = dispatch_hour;    // Give him the hour that he left the Station
                            preprationPhase.events_in++;                            // Add one more event to the ff career

                            ffDeployed.addLast(preprationPhase);                    // Transition the ff from "preparationPhase" to the deployed List
                            
                            
                            //----------------------------------------//
                            if (flag == 2) {
                                System.out.println(preprationPhase.name);
                            } 
                            //----------------------------------------//

                        } 
                    }


                    //----------------------------------------------------//
                    if (firefighters.isEmpty() && flag == 2 && nondeployed)
                        System.out.println("Nenhum");
                    //----------------------------------------------------//
                    

                } else if (temp.equals("CHEGADA")) {

                    String code = eventDetails.next();                                  // Get the code of the event that ended
                    int arrive_time = Integer.parseInt(eventDetails.next());            // Get the end time of the event that ended
                    int size_copy = ffDeployed.size();

                    // The "j" variable is needed to avoid accessing positions in the list no longer available. Ex. Starting with 4 elements in the list, once we removed 2, 
                    // the size of the list was going to be 2, the positions availabe would be 0 and 2. If "i" was our only variable, at this point of the loop it would be 3,
                    // and trying to access position 3 of the list, even though at the start it was accessible, now it wont be, because, once again the size is 2, resulting in a NullPointerExpection
                    for (int i = 0, j = 0; i < size_copy; i++, j++) {                   // Search for the ffs that arrived from that event 
                        FireFighter f = ffDeployed.get(j);

                        if (f.event_code.equals(code)) {                                // If the ff has the code of the event given
                            f.minutes_worked += (arrive_time - f.start_time_of_event);  // Update the time worked
                            firefighters.enqueue(ffDeployed.remove(j));                 // Put him in the Station queue for the next event
                            j--;
                        }
                    }

                }

            }

            eventDetails.close();
        }

        //-----------------------------------------------------------------//
        if (flag == 1) {
            System.out.println("Ocorreram " + number_of_events + " eventos");
        }
        //-----------------------------------------------------------------//
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
        station1.displayFirefighters();
           
    }
        
}