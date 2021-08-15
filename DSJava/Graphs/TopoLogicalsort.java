import java.util.*;

public class TopoLogicalsort {

    public static class Edge {

        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

    }

    static class Pair implements Comparable<Pair> {
        int v;
        int av; // acquiring vertex
        int wt;

        Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the vertices : ");
        int vtces = sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[vtces];

        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        System.out.print("Enter the edges : ");
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {

            System.out.println();
            System.out.print("Ente the v1 : ");
            int v1 = sc.nextInt();
            System.out.print("Ente the v2 : ");
            int v2 = sc.nextInt();
         

            graph[v1].add(new Edge(v1, v2, 0));

        }

        DisplayGraph(graph);
        // calling the display graph function

        System.out.println();
        System.out.print("Enter the src : ");
        int src = sc.nextInt();
        System.out.println();
        // write the Topological sort's algo here.

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < vtces; i++) {
            if (visited[i] == false) {
                // code for every vertex in graph.
                TopologicalSort(graph, i, visited, st);
            }
        }

        while (st.size() > 0) {
            System.out.println("\t\t"+st.pop());
        }

        System.out.println();
        sc.close();

    }
    

    public static void TopologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {

        visited[src] = true;

        for (Edge e : graph[src])
            if (visited[e.nbr] == false)
                TopologicalSort(graph, e.nbr, visited, st);

        st.push(src);

    } 

    public static void DisplayGraph(ArrayList<Edge> graph[]) {
        int count = 0;
        System.out.println();
        for (ArrayList<Edge> e : graph) {
            System.out.printf("ArrayList %d : ", count);
            for (Edge a : e) {
                System.out.print("[ ");
                System.out.print(a.src + " => " + a.nbr + " @ " + a.wt);
                System.out.print(" ]   ");

            }
            count++;
            System.out.println();
        }
        System.out.println();
    }

}
