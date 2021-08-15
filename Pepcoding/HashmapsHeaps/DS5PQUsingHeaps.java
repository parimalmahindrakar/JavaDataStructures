import java.util.*;

public class DS5PQUsingHeaps {

    public static class CustomPriorityQueue {
        
        ArrayList<Integer> data;

        public CustomPriorityQueue() {
            data = new ArrayList<>();
        }



        //  the add function !

        public void add(int val) {
            data.add(val);
            upheapfy(data.size()-1);
        }
    
        private void upheapfy(int i) {
            if(i == 0) {
                return ;
            }
            int parentIndex = (i - 1) / 2;
            if (data.get(i) < data.get(parentIndex)) {
                swap(i, parentIndex);
                upheapfy(parentIndex);
            }
        }

        private void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        // ------------------------------


        public int remove() {

            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);

            downheapify(0);

            return val;

        }
        
        private void downheapify(int i ) {
            int mini = i;
            
            int leftIndex = 2 * 1 + 1;
            if (leftIndex < data.size() && data.get(leftIndex) < data.get(mini)) {
                mini = leftIndex;
            }
            
            int rightIndex = 2 * 1 + 2;
            if (rightIndex < data.size() && data.get(rightIndex) < data.get(mini)) {
                mini = rightIndex;
            }
            
            if (mini != i) {
                swap(i, mini);
                downheapify(mini);
            }

        }




        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                return data.get(0);
            }

        }

        public int size() {
            return data.size() - 1;
        }

    }



    public static void main(String[] args) {
        
        

        

    }
    
}
