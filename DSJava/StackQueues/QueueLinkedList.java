public class QueueLinkedList<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    

    Node front, rear;

    QueueLinkedList() {
        this.front = this.rear = null;
    }

    void enqueue(T data) {
        Node temp = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }


    void dequeue() {
        if (this.front == null) {
            return;
        }
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
    }
    
    void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        
    }



    public static void main(String[] args) {
        QueueLinkedList<Integer> qu = new QueueLinkedList<>();
        qu.enqueue(1);
        qu.enqueue(2);
        qu.enqueue(3);
        qu.enqueue(4);
        qu.enqueue(5);
        qu.display();
        qu.dequeue();
        qu.dequeue();
        qu.display();
        System.out.println("Front : " + qu.front.data);
        System.out.println("Rear : "+qu.rear.data);
        


    }

}
