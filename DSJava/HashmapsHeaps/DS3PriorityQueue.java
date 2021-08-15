import java.util.*;

public class DS3PriorityQueue {
    

    public static void main(String[] args) {

        
        int[] ranks = { 22, 99, 3, 11, 88, 4, 1 };
        display(ranks); // direct display 
        displayKLargestElements(ranks, 3); // k largest elements

        
    }
    
    // display the PriorityQueue
    public static void display(int[] ranks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : ranks) {
            pq.add(i);
        }

        while (pq.size() > 0) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
        System.out.println();
    }

    // display k largest elements 
    public static void displayKLargestElements(int[] ranks, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ranks.length; i++) {
            if (i < k) {
                pq.add(ranks[i]);
            } else {
                if (ranks[i] > pq.peek()) {
                    pq.remove();
                    pq.add(ranks[i]);
                }
            }
        }
        while (pq.size() > 0) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();
    }
    





}
