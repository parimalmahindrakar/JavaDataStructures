import java.util.*;

public class JavaGraphsFindAllPaths2 {
    
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

        PrintAllPaths(graph, src, dest, visited,src+"");
        // calling the function and printing the output.

        sc.close();

    }

    public static void PrintAllPaths(ArrayList<Edge> graph[], int src, int dest, boolean[] visited, String psf) {

        if (src == dest) {
            System.out.println(psf);
            return;
        }
        
        visited[src] = true;

        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                PrintAllPaths(graph, e.nbr, dest, visited, psf+e.nbr);
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
