public class BinarySearchTree {

    public static class Node {

        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }

    public static Node construct(int[] arr, int low, int high) {

        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        int data = arr[mid];
        Node lc = construct(arr, low, mid - 1);
        Node rc = construct(arr, mid + 1, high);
        Node node = new Node(data, lc, rc);
        return node;
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
        if (node == null) {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        return ls + rs + 1;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int leftsum = sum(node.left);
        int rightsum = sum(node.right);
        int total = leftsum + rightsum + node.data;
        return total;
    }

    public static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static int min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }

    public static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data, null, null);
        }
        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        } else {
            // nothing to do
        }
        return node;
    }


    public static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            // work
            if (node.left != null && node.right != null) {
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    static int sum = 0;

    public static void ReplaceWithSumofLarger(Node node) {
        if (node == null) {
            return;
        }
        ReplaceWithSumofLarger(node.right);
        int original = node.data;
        node.data = sum;
        sum += original;
        ReplaceWithSumofLarger(node.left);
    }

    public static int LowestCommonAncestor(Node node, int d1, int d2) {
        if (d1 < node.data && d2 < node.data) {
            return LowestCommonAncestor(node.left, d1, d2);
        } else if (d1 > node.data && d2 > node.data) {
            return LowestCommonAncestor(node.right, d1, d2);
        } else {
            return node.data;
        }
    }

    public static void PrintInRange(Node node, int d1, int d2) {
        if (node == null) {
            return;
        }
        if (d1 < node.data && d2 < node.data) {
            PrintInRange(node.left, d1, d2);
        } else if (d1 > node.data && d2 > node.data) {
            PrintInRange(node.right, d1, d2);
        } else {
            PrintInRange(node.left, d1, d2);
            System.out.println(node.data);
            PrintInRange(node.right, d1, d2);
        }
    }

    public static void TargetSumPair(Node root, Node node, int target) {
        if (node == null) {
            return;
        }
        TargetSumPair(root,node.left, target);
        int complement = target - node.data;
        if (node.data < complement) {
            if (find(root, complement) == true) {
                System.out.println(node.data + " " + complement);
            }
        }
        TargetSumPair(root, node.right, target);
    }


    public static void main(String[] args) {

        int[] arr = { 12,  25, 37, 50, 62, 75, 87 };
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
        System.out.println("Size : " + size(root));
        System.out.println("Sum : " + sum(root));
        System.out.println("Max : " + max(root));
        System.out.println("Min : " + min(root));
        System.out.println(find(root, 75));


    }

}



