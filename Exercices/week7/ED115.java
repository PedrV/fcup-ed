package week7;

import java.util.Scanner;

class SupermarketSim {
    private Scanner scan;
    private MyQueue<String> queue = new LinkedListQueue<>();

    SupermarketSim (Scanner scan) {
        this.scan = scan;
    }

    public void start () {
        int flag = scan.nextInt();
        scan.nextLine(); // consume new line left by the input

        if (flag == 1) { // flag can only be 1 or 2
            clients();
        } else {
            lines ();
        }

    }

    private void clients () {

        // dispose of the number of lines available in the supermarket, in this option is always one
        scan.nextInt(); 
        scan.nextLine();

        int time_seconds = scan.nextInt();
        scan.nextLine();

        int number_clients = scan.nextInt();
        scan.nextLine();

        parseClients(number_clients);

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue()); // name of the client

            int time_of_arrival = Integer.parseInt(queue.dequeue());
            System.out.print(" " + time_of_arrival); // arrival time of each client

            int products = Integer.parseInt(queue.dequeue());
            System.out.println(" " + (products * time_seconds + time_of_arrival + 10)); // time at the end of checkout

        }

    }

    private void lines () {

        int number_of_lines = scan.nextInt();
        scan.nextLine();
        int[] line_att = new int[number_of_lines*2]; // each line has one att to represent the number of clients that passed through the line and the number of products

        MyQueue<Integer>[] lines_live = new MyQueue[number_of_lines];
        for(int i = 0; i < number_of_lines; i++) 
            lines_live[i] = new LinkedListQueue<Integer>();



        int[] time_seconds = new int[number_of_lines]; // doesn't need to be modified, neither remove or add elements, so array is probably the best choice
        for(int i = 0; i < number_of_lines; i++) {
            time_seconds[i] = scan.nextInt();
        }
        scan.nextLine();
        


        int number_clients = scan.nextInt();
        scan.nextLine();



        parseClients(number_clients);



        while (!queue.isEmpty()) { 
            boolean draw_people = false, processed = false, draw_products = false;

            // each client has a name, the time of arrival and a number of products
            queue.dequeue(); // dispose of the persons' name
            int time_of_arrival = Integer.parseInt(queue.dequeue());
            int number_products = Integer.parseInt(queue.dequeue());


            // 1º check if the client of each line is out already
            // 2º send the active client to the line with less people    
            // 2.1º if ties follow instructions
            // 3º repeat until queue is empty (profit?!)

            // 1º
            for (int i = 0; i < number_of_lines; i++) {
                if ( lines_live[i].isEmpty() ){
                    continue;
                } else if (lines_live[i].first() < time_of_arrival) {
                    lines_live[i].dequeue();
                    lines_live[i].dequeue();

                }
            }

            
            // 2º

            // fill empty lines first
            for (int i = 0, line = 0; i < number_of_lines; i++, line += 2) {
                if ( lines_live[i].isEmpty() ){
                    lines_live[i].enqueue(time_of_arrival + number_products*time_seconds[i] + 10); // queue the time that each client takes in the line
                    lines_live[i].enqueue(number_products); // queue the number of products that the client took
                    processed = true;

                    line_att[line]++;
                    line_att[line+1] += number_products;
                    
                    break;
                }
            }

            if(!processed) {

                int minimum_size = Integer.MAX_VALUE, minimum_number_of_prods = 0;

                for(int i = 0; i < number_of_lines; i++) {

                    if (lines_live[i].size() < minimum_size ) {

                        minimum_size = lines_live[i].size();
                        minimum_number_of_prods = getLast(lines_live[i]);
  
                        draw_people = false; // reset the draw count when a new minimum is discovered
                        draw_products = false;  // reset the draw count when a new minimum is discovered


                    } else if ( lines_live[i].size() == minimum_size ) { 

                        // if exists multiple lines with the minimum amount of people go for the one with less people
                        draw_people = true;

                        if (minimum_number_of_prods > getLast(lines_live[i])) {

                            minimum_number_of_prods = getLast(lines_live[i]);
                            draw_products = false; // reset the draw count when a new minimum is discovered

                        } else if ( minimum_number_of_prods == getLast(lines_live[i])) { // if exists multiple lines with the minimum amount of people and the minimum amount of products go to the first one with this attributes
                            draw_products = true;
                        }

                    }

 
                }



                if (!draw_people) { // if there was no draw just go for the line with less people

                    for(int i = 0, line = 0; i < number_of_lines; i++, line += 2) {
                        if ( lines_live[i].size() == minimum_size ) {

                            lines_live[i].enqueue(time_of_arrival + number_products*time_seconds[i] + 10); // queue the time that each client takes in the line
                            lines_live[i].enqueue(number_products); // queue the number of products that the client took

                            line_att[line]++;
                            line_att[line+1] += number_products;
                            break;  
                        } 
                    }


                } 
                // if there was a draw in the number of people in the lines with less clients, go for the line less people with the client with less products
                // this will work when the lines with less people have the same amount of products beacause, in this case its supposed to go for the first line with less people and less products of the ones tied
                else if (draw_people && !draw_products || draw_products) { // cant confirm || draw products
                    
                    for (int i = 0, line = 0; i < number_of_lines; i++, line += 2) {
                        if ( lines_live[i].size() == minimum_size ) {
                            if ( getLast(lines_live[i]) == minimum_number_of_prods ) {

                                lines_live[i].enqueue(time_of_arrival + number_products*time_seconds[i] + 10); // queue the time that each client takes in the line
                                lines_live[i].enqueue(number_products); // queue the number of products that the client took

                                line_att[line]++;
                                line_att[line+1] += number_products;
                                break;
                            }
                        }
                    }

                }

            }

            // 3º repeat (profit?!)
        }

        for (int i = 0, line = 0; i < number_of_lines; i++, line += 2) {
            System.out.println("Caixa #" + (i+1) + ":" + " " + line_att[line] + " " + line_att[line+1]);
        }

    }


    private void parseClients (int number_clients) { // split single string in multiple strings with atributes of each client 
        while ( number_clients > 0 ) {

            Scanner line = new Scanner (scan.nextLine());

            while (line.hasNext()) {
                queue.enqueue(line.next());
            }

            number_clients--;
        }
    }

    private int getLast (MyQueue<Integer> queue) { // didnt know if double ended queue was available
        MyQueue <Integer> temp = new LinkedListQueue<>();

        for (int i = 0; i < queue.size(); i++) {
            int tempint = queue.dequeue();
            temp.enqueue(tempint); 
            queue.enqueue(tempint);
        }

        while(temp.size() > 1) {
            temp.dequeue();
        }

        return temp.dequeue();
    }

}


public class ED115 {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        SupermarketSim sim = new SupermarketSim(scan);

        sim.start();

    }
}