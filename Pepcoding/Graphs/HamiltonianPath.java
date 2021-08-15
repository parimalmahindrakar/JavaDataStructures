import java.util.*;

public class HamiltonianPath {


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

            graph[v1].add(new Edge(v1, v2, 0));
            graph[v2].add(new Edge(v2, v1, 0));

        }

        DisplayGraph(graph);
        // calling the display graph function

        System.out.print("Enter the src : ");
        int src = sc.nextInt();

        HashSet<Integer> visited = new HashSet<>();
        Hamiltonian(graph, src, visited, src + "",src);

        sc.close();

    }


    public static void Hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc) {


        if (visited.size() == graph.length - 1) {
            
            System.out.print(psf);
            boolean closingEdgeFound = false;

            for (Edge e : graph[src]) {
                if (e.nbr == osrc) {
                    closingEdgeFound = true;
                    break;
                }
            }

            if (closingEdgeFound == true) {
                System.out.println("*");
                // if it is hamiltonial cycle
            } else {
                System.out.println(".");
                // if it not hamiltonial cycle
            }

            return;            

        }

        visited.add(src);

        for (Edge e : graph[src]) {
            if (visited.contains(e.nbr) == false) {
                Hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
            }
        }

        visited.remove(src);


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




/*


        if (visited.size() == graph.length - 1) {

            System.out.print(psf);

            boolean closingEdgeFound = false;
            for (Edge e : graph[src]) {
                if (e.nbr == osrc) {
                    closingEdgeFound = true;
                    break;
                }
            }
            
            if (closingEdgeFound == true) {
                System.out.println("*");
                // if it is hamiltonial cycle
            } else {
                System.out.println(".");
                // if it not hamiltonial cycle
            }

            return;
        }

        visited.add(src);

        //  ArrayList 0 : [ 0 => 1 @ 10 ]   [ 0 => 3 @ 40 ]   
        //  ArrayList 1 : [ 1 => 0 @ 10 ]   [ 1 => 2 @ 10 ]   
        //  ArrayList 2 : [ 2 => 1 @ 10 ]   [ 2 => 3 @ 10 ]   
        //  ArrayList 3 : [ 3 => 0 @ 40 ]   [ 3 => 2 @ 10 ]   [ 3 => 4 @ 2 ]   
        //  ArrayList 4 : [ 4 => 3 @ 2 ]   [ 4 => 5 @ 3 ]   [ 4 => 6 @ 8 ]   
        //  ArrayList 5 : [ 5 => 4 @ 3 ]   [ 5 => 6 @ 5 ]   
        //  ArrayList 6 : [ 6 => 5 @ 5 ]   [ 6 => 4 @ 8 ] 
      

        for (Edge e : graph[src]) {
            if (visited.contains(e.nbr) == false) {
                Hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
            }
        }

        visited.remove(src);



*/