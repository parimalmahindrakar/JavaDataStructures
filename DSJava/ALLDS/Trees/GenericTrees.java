import java.util.*;

public class GenericTrees {

    static Node root;

    static class Node {
        
        int data;
        ArrayList<Node> children = new ArrayList<>();

    }

    
    public static void main(String[] args) {

        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 999, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };  
        
        createTree(arr); // create the generic tree !
        // display(root); // display the tree !
        // System.out.println("Size of Generic Tree : " + size(root)); // return the size
        // System.out.println("Max in Generic Tree : " + max(root));
        // System.out.println("Height of Generic Tree : " + height(root));
        // LevelOrder(root);
        // LevelOrderLineWise(root);
        // LevelOrderZigZag(root);
        // mirror(root);
        // display(root);
        // removeLeaves(root);
        // System.out.println("Is data there : "+find(root, 998));
        // System.out.println(NodeToRootPath(root, 999));
        System.out.println(DistanceBetweenTwoNodes( root, 70, 999));
    }

    
    public static void createTree(int[] arr) {

        Stack<Node> st = new Stack<>();
        //  { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 999, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };  
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }

    }

    public static void display(Node root) {

        String str = root.data + " ==> ";
        for (Node child : root.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
        for (Node child : root.children) {
            display(child);
        }

    }
    
    public static int size(Node node) {
        int s = 0;
        for (Node child : node.children) {
            int cs = size(child);
            s += cs;
        }
        s++;
        return s;
    }

    public static int max(Node node) {
        
        int mx = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int cm = max(child);
            mx = Math.max(cm, mx);
        }
        mx = Math.max(node.data, mx);

        return mx;

    }

    public static int height(Node node) {

        int ht = -1;

        for (Node child : node.children) {
            int ch = height(child);
            ht = Math.max(ch, ht);
        }
        ht++;
        return ht;
    }


    public static void LevelOrder(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);

        while (qu.size() > 0) {
            Node n = qu.remove();
            System.out.println(n.data);

            for (Node n1 : n.children) {
                qu.add(n1);
            }
        }

    }
    
    public static void LevelOrderLineWise(Node node) {

        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        Queue<Node> cq = new ArrayDeque<>();

        while (mq.size() > 0) {

            node = mq.remove();
            System.out.print(node.data + " ");

            for (Node child : node.children) {
                cq.add(child);
            }

            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }

        }

    }

    

    public static void LevelOrderZigZag(Node node) {

        Stack<Node> ms = new Stack<>();
        ms.push(node);
        Stack<Node> cs = new Stack<>();
        int level = 1;

        while (ms.size() > 0) {
            node = ms.pop();
            System.out.print(node.data + " ");
            if (level % 2 == 1) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }

            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }

        }

    }

    

    public static void mirror(Node node) {

        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);

    }
    

    public static void removeLeaves(Node node) {

    }

    
    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        for (Node child : node.children) {
            boolean fic = find(child, data);
            if (fic) {
                return true;
            }
        }
        return false;
    }


    public static ArrayList<Integer> NodeToRootPath(Node node, int data) {

        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = NodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();

    }
    


    public static int DistanceBetweenTwoNodes(Node node, int d1, int d2) {

        ArrayList<Integer> p1 = NodeToRootPath(node, d1);
        ArrayList<Integer> p2 = NodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return i + j;
    }
    
    // whether two tree are similar 
    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if (areSimilar(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }

    
    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    public static void ceilAndFloor(Node node, int data) {
        
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }



}