import java.util.*;


public class DS4MedianPriorityQueue {


    public static class MedianPriorityQueue {
        
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }


        }

        public int remove() {

            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }else if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }

        }

        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }else if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            return left.size() + right.size();
        }


    }

    public static void main(String[] args) {
        
        MedianPriorityQueue q = new MedianPriorityQueue();

        q.add(2);
        q.add(15);
        q.add(4);
        q.add(41);
        q.add(51);


        System.out.println("Before removing  : "+q.peek());
        q.remove(); // removing
        System.out.println("After removing  : "+q.peek());




    }
    
}
