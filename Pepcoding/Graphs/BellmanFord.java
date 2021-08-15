import java.util.*;

public class BellmanFord {

    public static class Edge {
        int src, dest, wt;

        Edge() {
            src = dest = wt = 0;
        }
    }

    static int v, e;
    static Edge edge[];

    BellmanFord(int v1, int e1) {

        v = v1;
        e = e1;

        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    public static void BellmanFordAlgo(BellmanFord graph, int src) {

        int vertices = v;
        int edges = e;
        int dist[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < v; i++) {
            for (int j = 0; j < edges; j++) {

                int u = edge[j].src;
                int v = edge[j].dest;
                int wgt = edge[j].wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wgt < dist[v])
                    dist[v] = dist[u] + wgt;

            }
        }

        for (int j = 0; j < edges; j++) {

            int u = edge[j].src;
            int v = edge[j].dest;
            int wgt = edge[j].wt;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wgt < dist[v]) {
                System.out.println("Graph contains negative wt cycle.");
                return;
            }

        }

        printArr(dist, v);

    }
    
    public static void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }


    public static void main(String[] args) {
        
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph


        BellmanFord graph = new BellmanFord(V, E);

        // add edge 0-1 (or A-B in above figure)
        edge[0].src = 0;
        edge[0].dest = 1;
        edge[0].wt = -1;

        // add edge 0-2 (or A-C in above figure)
        edge[1].src = 0;
        edge[1].dest = 2;
        edge[1].wt = 4;

        // add edge 1-2 (or B-C in above figure)
        edge[2].src = 1;
        edge[2].dest = 2;
        edge[2].wt = 3;

        // add edge 1-3 (or B-D in above figure)
        edge[3].src = 1;
        edge[3].dest = 3;
        edge[3].wt = 2;

        // add edge 1-4 (or A-E in above figure)
        edge[4].src = 1;
        edge[4].dest = 4;
        edge[4].wt = 2;

        // add edge 3-2 (or D-C in above figure)
        edge[5].src = 3;
        edge[5].dest = 2;
        edge[5].wt = 5;

        // add edge 3-1 (or D-B in above figure)
        edge[6].src = 3;
        edge[6].dest = 1;
        edge[6].wt = 1;

        // add edge 4-3 (or E-D in above figure)
        edge[7].src = 4;
        edge[7].dest = 3;
        edge[7].wt = -3;

        BellmanFordAlgo(graph, 0);



    }

}