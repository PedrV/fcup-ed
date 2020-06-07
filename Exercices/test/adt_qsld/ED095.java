package test.adt_qsld;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class FireFighter {
    private String name;
    private int events;
    private int worked_hours;
    private String eventID;

    FireFighter (String name) {
        this.name = name;
        events = 0;
        worked_hours = 0;
        eventID = "";
    }

    /**
     * @return the events
     */
    public int getEvents() {
        return events;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the worked hours
     */
    public int getWorkedHours() {
        return worked_hours;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(int events) {
        this.events = events;
    }

    /**
     * @param worked_hours the worked_hours to set
     */
    public void setWorkedHours(int worked_hours) {
        this.worked_hours = worked_hours;
    }

    /**
     * @param eventID the eventID to set
     */
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    /**
     * @return the eventID
     */
    public String getEventID() {
        return eventID;
    }

}

class HeadQuarters {
    private Queue<FireFighter> ffighters;
    private Queue<FireFighter> depolyed;
    private HashMap<String,Integer> events;
    
    HeadQuarters (Queue<FireFighter> ffighters) {
        this.ffighters = ffighters;
        depolyed = new LinkedList<>();
        events = new HashMap<>();
    }

    public void startEvent (String eventID, int ff_needed, int start_time) {

        for (int i = 0; i < ff_needed; i++) {
            FireFighter startPrep = ffighters.poll();

            if (startPrep == null) 
                return;
            
            startPrep.setEventID(eventID);
            startPrep.setEvents(startPrep.getEvents()+1);
            events.put(eventID, start_time);
            depolyed.add(startPrep);
        }
    }

    public void endEvent (String eventID, int end_time) {
        int size = depolyed.size();

        for (int i = 0; i < size ; i++) {
            FireFighter ff = depolyed.poll();
            if (eventID.equals(ff.getEventID())) {
                ff.setEventID("");
                ff.setWorkedHours(ff.getWorkedHours() + end_time - events.get(eventID));
                ffighters.add(ff);
            } else {
                depolyed.add(ff);
            }
        }
        
    }

    public void atEvent (String eventID) {
        boolean dep = false;

        System.out.println("EVENTO " + eventID);
        for (FireFighter ff : depolyed) {
            if (eventID.equals(ff.getEventID())) {
                System.out.println(ff.getName());
                dep = true;
            }
        }

        if (!dep)
            System.out.println("Nenhum");
    }

    public void ffightersDetails () {
        for (FireFighter ff : ffighters) 
            System.out.println(ff.getName() + " " + ff.getEvents() + " " + ff.getWorkedHours());
    }

} 

public class ED095 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<FireFighter> ff = new LinkedList<>();
        int flag = scan.nextInt();
        int total_events = 0;
        int fn = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < fn; i++) {
            FireFighter f = new FireFighter(scan.nextLine());
            ff.add(f);
        }

        HeadQuarters hq = new HeadQuarters(ff);

        String[] s = {"START"};
        while (!s[0].equals("FIM")) {
            s = scan.nextLine().split(" ");

            if (s[0].equals("PARTIDA")) {
                hq.startEvent(s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));
                total_events++;
            } else if (s[0].equals("CHEGADA")) {
                hq.endEvent(s[1], Integer.parseInt(s[2]));
            }

            if (flag == 2 && s[0].equals("PARTIDA")) 
                hq.atEvent(s[1]);

        }

        scan.close();

        if (flag == 1) {
            System.out.printf("Ocorreram %d eventos\n", total_events);
        } else if (flag == 3) {
            System.out.println("Listagem de Bombeiros");
            hq.ffightersDetails();
        }
    }
}