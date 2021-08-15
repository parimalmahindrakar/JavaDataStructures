import java.util.*;

public class BreadthFirstSearchJava {
    

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
        System.out.print("Enter the src : ");
        int src = sc.nextInt();

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));
        boolean visited[] = new boolean[vtces];

        System.out.println();

        while (queue.size() > 0) {

            // r m* w a*
            Pair rem = queue.removeFirst();

            if(visited[rem.v] == true) 
                continue;
                
            visited[rem.v] = true;
            System.out.println("[ "+rem.v + " @ " + rem.psf+" ]");
            
            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }

        }
        
       
        System.out.println();
        sc.close();

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
