import java.util.*;
public class BT1__Prob1 {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }



    public static void display(Node node) {

        if (node == null) {
            return;
        }

        // node self work
        String str = "";
        str += node.left == null ? " . " : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? " . " : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);


    }


    public static int size(Node node) {
        if(node == null ) 
            return 0;
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }

    
    public static int sum(Node node) {
        if(node == null ) 
            return 0;
        int lsm = sum(node.left);
        int rsm = sum(node.right);
        int tsm = lsm + rsm + node.data;
        return tsm;
    }


    public static int max(Node node) {

        if (node == null)
            return Integer.MIN_VALUE;

        int lm = max(node.left);
        int rm = max(node.right);
        int tm = Math.max(node.data, Math.max(lm, rm));
        return tm;

    }
    

    public static int height(Node node) {

        if (node == null) {
            return -1;
            // -1 in terms of edges
            // 0 in terms of nodes
        }

        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;
    }


    public static void preorder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }


    public static void postorder(Node node) {
        if(node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }


    public static void levelorder(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (mq.size() > 0) {
            int count = mq.size();
            for (int i = 0; i < count; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    mq.add(node.left);
                }
                if (node.right != null) {
                    mq.add(node.right);
                }
            }
            System.out.println();
        }
    }


    public static void printPath(Node root) {
        ArrayList<Integer> path = new ArrayList<>();
        find(root, 12, path);
        System.out.println("Path : "+path);

    }

    public static boolean find(Node node, int data, ArrayList<Integer> path) {

        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path.add(node.data);
            return true;
        }

        boolean filc = find(node.left, data, path);
        if (filc) {
            path.add(node.data);
            return true;
        }
        boolean firc = find(node.right, data, path);
        if (firc) {
            path.add(node.data);
            return true;
        }
        return false;

    }
    

    public static void printKLevelsDows(Node node, int k) {

        if(node == null || k < 0 )
            return;
        if(k == 0)
            System.out.println(node.data);
        
        printKLevelsDows(node.left, k - 1);
        printKLevelsDows(node.right, k - 1);
               
        
    }


    public static void printSingleChildNodes(Node node, Node parent) {

        if (node == null) {
            return;
        }

        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.data);
        } else if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }



    public static Node removeLeaves(Node node) {

        if (node == null) {
            return null;    
        }
        
        if (node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;

    }










    public static void main(String[] args) {
        
        Integer arr[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null };

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        
        Stack<Pair> st = new Stack<>();
        st.push(rtp);


        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {

                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;

            } else {
                st.pop();
            }
        }
        

        // display(root);
        // System.out.println("size : "+size(root));
        // System.out.println("sum : "+sum(root));
        // System.out.println("max : "+max(root));
        // System.out.println("height : " + height(root));
        // System.out.print("Preorder : ");
        // preorder(root);
        // System.out.println();
        // System.out.print("Inorder : ");
        // inorder(root);
        // System.out.println();
        // System.out.print("Postorder : ");
        // postorder(root);
        // System.out.println();
        // levelorder(root);

        // System.out.println("Arraylist : "+path);
        // find(root, 70);
        // System.out.println("Arraylist : "+path);

        printPath(root);

    }


}