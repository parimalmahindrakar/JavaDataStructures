import java.util.*;

public class JavaGraphsMultiSolver3 {

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


    public static class Pair implements Comparable<Pair>  {

        int wsf;
        String psf;

        Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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
            System.out.print("Ente the wt : ");
            int wt = sc.nextInt();

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));

        }

        DisplayGraph(graph);
        // calling the display graph function

        System.out.print("Enter the src : ");
        int src = sc.nextInt();
        System.out.print("Enter the dest : ");
        int dest = sc.nextInt();
        boolean visited[] = new boolean[vtces];

        // print the smallest, largest,
        // just larger path than 40,
        // just smaller path than 40,
        // 3rd largest pat h
        int criteria = 40;
        int k = 3, wsf = 0;
        MultiSolver(graph, src, dest, visited, criteria, k, src + "", wsf);
        // calling the function and printing the output.

        System.out.println();
        System.out.println("Smallest path : " + spath + " @ " + spathwt);
        System.out.println("Largest path : " + lpath + " @ " + lpathwt);
        System.out.println("Just larger path than : " + criteria + " => " + cpath + " @ " + cpathwt);
        System.out.println("Just smaller path than : " + criteria + " => " + fpath + " @ " + fpathwt);
        System.out.println(""+k+"th largest path : " + pq.peek().psf + " @ " + pq.peek().wsf);
        System.out.println();

        sc.close();

    }

    static String spath; // smallest path
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath; // largest path
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath; // ceil path
    static Integer cpathwt = Integer.MAX_VALUE; 
    static String fpath; // floor path
    static Integer fpathwt = Integer.MIN_VALUE;

    static PriorityQueue<Pair> pq = new PriorityQueue<>();


    public static void MultiSolver(ArrayList<Edge> graph[], int src, int dest, boolean[] visited, int criteria, int k,
            String psf, int wsf) {

        if (src == dest) {
            if (wsf < spathwt) {
                spathwt = wsf;
                spath = psf;
            }
            if (wsf > spathwt) {
                lpathwt = wsf;
                lpath = psf;
            }
            if (wsf > criteria && wsf < cpathwt) {
                cpathwt = wsf;
                cpath = psf;
            }
            if (wsf < criteria && wsf > fpathwt) {
                fpathwt = wsf;
                fpath = psf;
            }
            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                } else {
                    pq.add(new Pair(wsf, psf));
                }
            }   

            return;
        }
        visited[src] = true;

        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                MultiSolver(graph, e.nbr, dest, visited, criteria, k,psf + e.nbr,wsf + e.wt);
            }
        }
        visited[src] = false;

    }

    public static void DisplayGraph(ArrayList<Edge> graph[]) {
        int count = 1;
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
