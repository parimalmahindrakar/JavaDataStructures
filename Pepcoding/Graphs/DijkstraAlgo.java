import java.util.*;

public class DijkstraAlgo {



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

        int v;
        String psf;
        int wsf;

        Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
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
       
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src + "", 0));
        boolean[] visited = new boolean[vtces];

        while (pq.size() > 0) {
            
            Pair rem = pq.remove();
            if(visited[rem.v])
                continue;
            
            visited[rem.v] = true;
            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

            for (Edge e : graph[rem.v]) {

                // Edge e : graph[rem.v] this means,
                // for every "Edge e" in the ArrayList returned by graph[rem.v]
                /*
                    ArrayList 0 : [ 0 => 1 @ 10 ]   [ 0 => 3 @ 40 ]   
                    ArrayList 1 : [ 1 => 0 @ 10 ]   [ 1 => 2 @ 10 ]   
                    ArrayList 2 : [ 2 => 1 @ 10 ]   [ 2 => 3 @ 10 ]   
                    ArrayList 3 : [ 3 => 0 @ 40 ]   [ 3 => 2 @ 10 ]   [ 3 => 4 @ 2 ]   
                    ArrayList 4 : [ 4 => 3 @ 2 ]   [ 4 => 5 @ 3 ]   [ 4 => 6 @ 8 ]   
                    ArrayList 5 : [ 5 => 4 @ 3 ]   [ 5 => 6 @ 5 ]   
                    ArrayList 6 : [ 6 => 5 @ 5 ]   [ 6 => 4 @ 8 ] 
                */

                if (visited[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }

        }

        sc.close();

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


