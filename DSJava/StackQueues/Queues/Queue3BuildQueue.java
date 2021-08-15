public class Queue3BuildQueue {

    public static class CustomQueue {

        int[] data;
        int front;
        int size;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }   

        void display() {

            for (int i = 0; i < data.length; i++) {
                int idx = (front + i) % data.length;
                //modulo operator performs the circular operations
                System.out.print(data[idx] + " ");
            }
            System.out.println();

        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue Overflow");
            } else {
                int rear = (front + size) % data.length;
                //modulo operator performs the circular operations
                data[rear] = val;
                size++;
            }
        }


        int peek() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return data[front];
            }
        }



        int remove() {

            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                //modulo operator performs the circular operations
                size--;
                return val;
            }            

        }


    }

    public static void main(String[] args) {

        CustomQueue queue = new CustomQueue(5);

        queue.add(15);
        queue.display();
        queue.add(35);
        queue.display();
        queue.add(5);
        queue.display();

        System.out.println("Peek : " + queue.peek());
        queue.add(35);
        queue.display();
        queue.add(45);
        queue.display();
        queue.add(65);  // Queue Overflow
        queue.display();

        queue.remove();
        queue.remove();
        queue.remove();
        queue.display();
        System.out.println("Peek : " + queue.peek());

        queue.remove();
        queue.remove();
        queue.remove();
        queue.display();
        System.out.println("Peek : " + queue.peek());





    }
}










