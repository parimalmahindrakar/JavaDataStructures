import java.util.*;

public class IsGraphCyclic {
    

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

    static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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
            graph[v2].add(new Edge(v2, v1, 0));

        }

        DisplayGraph(graph);
        // calling the display graph function

        System.out.println();


        boolean[] visited = new boolean[vtces];
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                boolean isCyclic = IsCyclic(graph, v, visited);
                if(isCyclic) {
                    System.out.println("Is Cyclic : " + true);
                    return;
                }
            }
        }

        System.out.println("Is Cyclic : " + false);

        System.out.println();
        sc.close();

    }



    public static boolean IsCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {


        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + ""));

        while (q.size() > 0) {
            
            Pair rem = q.removeFirst();
            
            if (visited[rem.v] == true)
                return true;
            
            visited[rem.v] = true;

            for (Edge e : graph[rem.v])
                if (visited[e.nbr] == false)
                    q.add(new Pair(e.nbr, rem.psf + e.nbr));

        }

        return false;
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
