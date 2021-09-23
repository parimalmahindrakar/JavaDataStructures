public class StackLinkedList<T> {
 
    class Node {
        T data;
        Node next;
    }

    Node top;

    StackLinkedList() {
        this.top = null;
    }

    public void push(T data) {

        Node temp = new Node();
        temp.data = data;
        temp.next = top;
        top = temp;

    }
    
    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if(!isEmpty()) 
            return top.data;
        else {
            return null;
        }
    }
    
    public void pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return;
        } 
        top = top.next;
    }


    public void display() {
        if (top == null) {
            System.out.println("Stack Underflow ");
            return;
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.print( " => "+temp.data);
                temp = temp.next;
            }
        }
        System.out.println();
    }
    

    public static void main(String[] args) {

        StackLinkedList<Integer> st = new StackLinkedList<>();

        st.push((int)'a');
        st.push((int)'b');
        st.push((int)'c');
        st.display();
        st.pop();
        st.display();
        System.out.println(st.peek());

    }

}



