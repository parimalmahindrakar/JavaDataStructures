import java.util.*;

public class JavaGraphsGetConnectedComponents4 {
    
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

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        //calling the function
        boolean visited[] = new boolean[vtces];
        for(int v = 0; v <  vtces; v++) {
            if(visited[v] == false ) {
                ArrayList<Integer> comp = new ArrayList<>();
                DrawTree(graph, v, comp, visited);
                comps.add(comp);
            }
        }

        System.out.println("All connected components : " + comps);
        boolean b = comps.size() == 1 ? true : false;
        System.out.println("Is graph all connected ? : "+b);

    }
    

    public static void DrawTree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
        
        visited[src] = true;
        comp.add(src);
        for(Edge e : graph[src] ) {
            if(visited[e.nbr] == false)  {
                DrawTree(graph, e.nbr, comp, visited);
            }
        }

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
