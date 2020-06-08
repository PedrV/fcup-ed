import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {
    private int time_needed;
    private String name;
    private int time_end;
    private int time_start;

    Process (String name, int time_needed) {
        this.name = name;
        this.time_needed = time_needed;
        time_end = 0;
        time_start = Integer.MIN_VALUE;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the time_end
     */
    public int getTime_end() {
        return time_end;
    }

    /**
     * @return the time_start
     */
    public int getTime_needed() {
        return time_needed;
    }

    /**
     * @return the time_start
     */
    public int getTime_start() {
        return time_start;
    }

    /**
     * @param time_end the time_end to set
     */
    public void setTime_end(int time_end) {
        this.time_end = time_end;
    }

    /**
     * @param time_start the time_start to set
     */
    public void setTime_start(int time_start) {
        this.time_start = time_start;
    }

    /**
     * @param time_needed the time_needed to set
     */
    public void setTime_needed(int time_needed) {
        this.time_needed = time_needed;
    }
}

class RoundRobin {
    private int cpu;
    private Queue<Process> rr;
    private ArrayList<Process> ff;

    RoundRobin (int cpu, Queue<Process> rr) {
        this.cpu = cpu;
        this.rr = rr;
        ff = new ArrayList<>(rr.size());
    }

    public void execute () {
        int time = 0;

        while (!rr.isEmpty()) {
            Process p = rr.remove();
            
            if (p.getTime_start() == Integer.MIN_VALUE) 
                p.setTime_start(time);

            int next_time = p.getTime_needed()-cpu;
            if (next_time <= 0) {
                time += p.getTime_needed();
                p.setTime_end(time);
                ff.add(p);
                continue;
            }

            if (p.getTime_needed() <= 0) {
                p.setTime_end(time);
                ff.add(p);
            } else {
                p.setTime_needed(next_time);
                rr.add(p);
            }

            time += cpu;
        }

        printer();
    }

    private void printer () {
        for (Process process : ff) {
            System.out.println(process.getName() + " " + process.getTime_start()+ " " + process.getTime_end());
        }
    }

}


public class ED237 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<Process> rr = new LinkedList<>();

        int cpu = scan.nextInt();
        int p = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < p; i++) {
            String[] temp = scan.nextLine().split(" "); 
            Process ptemp = new Process(temp[0], Integer.parseInt(temp[1]));
            rr.add(ptemp);
        }

        scan.close();

        RoundRobin start = new RoundRobin(cpu, rr);
        start.execute();
    }
}