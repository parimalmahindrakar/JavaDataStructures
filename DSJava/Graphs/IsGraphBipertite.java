import java.util.*;

public class IsGraphBipertite {

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
        int level;

        Pair(int v, String psf,int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
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

        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);
        
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == -1) {
                boolean isBipartite = checkForBipartite(graph, v, visited);
                if (isBipartite) {
                    System.out.println("Is Bipartite : " + true);
                    return;
                }
            }
        }
        System.out.println("Is Bipartite : " + false);

        sc.close();

    }
    
    public static boolean checkForBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + "", 0));
        
        while (q.size() > 0) {
            
            Pair rem = q.removeFirst();
            if (visited[rem.v] != -1) {
                if (rem.level != visited[rem.v]) {
                    return false;
                }
            } else {
                visited[rem.v] = rem.level;
            }

            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == -1) {
                    q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.level + 1));
                }
            }

        }


        return true;
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
