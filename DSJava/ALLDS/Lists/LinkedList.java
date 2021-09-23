
public class LinkedList {
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node root = null;

    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        Node temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    
    public void addFirst(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        Node temp = root;
        root = node;
        root.next = temp;
    }

    public void addMiddle(Node node) {

        if (root == null) {
            root = node;
            return;
        }
        Node fast, slow;
        fast = slow = root;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        node.next = slow.next;
        slow.next = node;

    }       

    // -------------------------------------------


    public int delete() {
        if (root == null) {
            System.out.println("Empty");
            return -1;
        }
        Node temp = root;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = null;
        return data;
    }

    public int deleteFirst() {
        if (root == null) {
            System.out.println("Empty");
            return -1;
        }
        int data = root.data;
        root = root.next;
        return data;
    }

    public int deleteMiddle() {

        Node fast, slow, temp;
        fast = temp =slow = root;

        while (fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        int data = slow.data;
        temp.next = slow.next;
        return data;
    }
    // ---------------------------------

    public void display() {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    

    public int size() {
        int cnt = 0;
        Node temp = root;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }



    // Write a Program to reverse the Linked List. (Both Iterative and recursive)

    public void reverseIterative() {

        Node prev = null;
        Node current = root;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root = prev;

    } // Iterative

    public Node reverseRecursive(Node head) {

        if (head == null || head.next == null)
            return head;

        Node rest = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return rest;

    } // recursive

    // Given a linked list, write a function to reverse every k nodes

    /**
     *  Input: 1->2->3->4->5->6->7->8->NULL, K = 3 
        Output: 3->2->1->6->5->4->8->7->NULL 
        Input: 1->2->3->4->5->6->7->8->NULL, K = 5 
        Output: 5->4->3->2->1->8->7->6->NULL 
     */

    public Node reverseKNode(Node head, int k) {
        if(head == null) 
            return null;
        Node curr = head;
        Node next = null;
        Node prev = null;

        int cnt = 0;
        while (cnt < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        if (next != null) {
            head.next = reverseKNode(next, k);
        }
        return prev;
    }
    
    // ------------------------------------------------------------


    // Write a program to Detect loop in a linked list.

    public void detectLoop() {
        Node fast, slow;
        fast = slow = root;
        int flag = 0;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Loop found");
        } else {
            System.out.println("Loop not found");
        }
    } 

    // Remove Duplicates in a sorted Linked List.

    public Node removeDuplicatesFromSortLL(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next != null) {
            if (head.data == head.next.data) {
                head.next = head.next.next;
                removeDuplicatesFromSortLL(head);
            } else {
                removeDuplicatesFromSortLL(head.next);
            }
        }
        return head;
    }

    public void removeDuplicatesFromUnsortLL() {

        Node pt1 = root, pt2 = null;

        while (pt1 != null && pt1.next != null) {
            pt2 = pt1;
            while (pt2.next != null) {
                if (pt1.data == pt2.next.data) {
                    pt2.next = pt2.next.next;
                } else {
                    pt2 = pt2.next;
                }
            }
            pt1 = pt1.next;
        }

    }
    //--------------------------------------------------
    

    // Write a Program to Move the last element to Front in a Linked List.

    public void moveToFront() {
        if (root == null || root.next == null) {
            return;
        }
        Node secLast = null;
        Node last = root;
        while (last.next != null) {
            secLast = last;
            last = last.next;
        }
        secLast.next = null;
        last.next = root;
        root = last;

    }

    //----------------------------------------------
    // Add 1 to a number represented as linked list 

    public int addOneToList(Node node) {
        if (node == null)
            return 1;
        int res = node.data + addOneToList(node.next);
        node.data = res % 10;
        return res / 10;

    }
    
    public Node addOne(Node node) {
        int c = addOneToList(node);
        if (c == 1) {
            Node head = new Node(1);
            return head;
        }
        return node;
    }

    //----------------------------------------------
    // Add two numbers represented by linked lists.

    public static Node addTwoLinkedLists(Node root1, Node root2) {
        
        Node dummy = new Node(0);

        Node p = root1, q = root2, curr = dummy;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0)
            curr.next = new Node(carry);

        return dummy.next;
    }

    //------------------------------------------------------
    // Intersection of two Sorted Linked List.
    /*
        First linked list: 1->2->3->4->6
        Second linked list be 2->4->6->8, 
        Output: 2->4->6.
    */





    //------------------------------------------------------
    // merge sort of linkedlist

    public Node getMiddle(Node root_) {
        Node fast, slow;
        fast = slow = root_;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public Node mergesort(Node root_) {

        if (root_.next == null || root_ == null) {
            return root_;
        }

        Node middle = getMiddle(root_);
        Node nextofmiddle = middle.next;

        middle.next = null;
        Node left = mergesort(root_);
        Node right = mergesort(nextofmiddle);

        Node sortedlist = sortedMerge(left, right);
        return sortedlist;

    }

    public Node sortedMerge(Node a, Node b) {
        Node res = null;

        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data < b.data) {
            res = a;
            res.next = sortedMerge(a.next, b);
        } else {
            res = b;
            res.next = sortedMerge(a, b.next);
        }
        return res;
    }

    //------------------------------------------------------
    // is linkedlist circular ?
    public boolean isCircular(Node head) {
        if (head == null)
            return true;
        Node node = head.next;
        while (node != null && node != head) {
            node = node.next;
        }
        return node == head;
    }
    // --------------------------------------------
    // is LinkedList palindrome ?

    // boolean isPalindrome(Node root) {

    // }

    //--------------------------------------------


    public static void main(String[] args) {
    
        LinkedList ls = new LinkedList();
        ls.add(new Node(5));
        ls.add(new Node(8));
        // ls.add(new Node(9));
        // ls.add(new Node(9));

        // ls.add(new Node(3));
        // ls.add(new Node(3));
        // ls.add(new Node(4));
        // ls.add(new Node(5));
        // ls.add(new Node(5));
        // ls.add(new Node(5));
        // ls.add(new Node(6));
        // ls.add(new Node(7));
        // ls.add(new Node(8));
        // ls.add(new Node(9));
        ls.display();
        
        
        

        
        
        /*  1. ====> reverse Interative and Recursive both
            -----------------------------------------------
            ls.reverseIterative();   // [OR]
            ls.root = ls.reverseRecursive(ls.root);
            ls.root = ls.reverseKNode(ls.root, 3);
            ls.display();
        
            2. ====> remove duplicates from sorted LL
            -----------------------------------------------
            ls.removeDuplicatesFromSortLL(ls.root); [OR]
            ls.removeDuplicatesFromUnsortLL();
            ls.display();
        
            3. ====> Move last element to first 
            -----------------------------------------------
            ls.moveToFront();
            ls.display();
            
            4. ====> Add one to the linkedlist
            -----------------------------------------------
            ls.root = ls.addOne(ls.root);
            ls.display();
        
            5. ====> Add two linkedlists
            -----------------------------------------------
            LinkedList ls2 = new LinkedList();
            ls2.add(new Node(5));
            // ls2.add(new Node(8));
            // ls2.add(new Node(9));
            ls2.display();
            
            Node newroot = addTwoLinkedLists(ls.root, ls2.root);
            Node temp = newroot;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
            


        
        */


        




    }


}
