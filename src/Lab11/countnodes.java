package Lab11;
import java.util.*;
public class countnodes  {

    static class Graph {
        int nodes;
        List<List<Integer>> adj;

        Graph(int n) {
            nodes = n;
            adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int countNodes() {
            return nodes;
        }

        int countEdges() {
            int edges = 0;
            for (int i = 0; i < nodes; i++)
                edges += adj.get(i).size();
            return edges / 2;
        }

        void display() {
            for (int i = 0; i < nodes; i++)
                System.out.println(i + " -> " + adj.get(i));
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        System.out.println("Graph adjacency list:");
        g.display();

        System.out.println("Total Nodes: " + g.countNodes());
        System.out.println("Total Edges: " + g.countEdges());
    }
}

/*
EXPLANATION:

Graph(int n):
    Creates a graph with n nodes (0 to n-1)
    Initializes adjacency lists for each node.

addEdge(u, v):
    Since this is an undirected graph, add v into u's list and u into v's list.

countNodes():
    Returns total number of vertices (n).

countEdges():
    Go through each adjacency list and count total links.
    Each edge appears twice (u->v and v->u), so divide by 2.

display():
    Prints adjacency list for visualization.

In main():
    A graph with 5 nodes is created.
    Edges are added.
    Graph structure is displayed.
    Total nodes and total edges are printed.

Output example:
    Nodes: 5
    Edges: 4
*/
