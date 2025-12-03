package Lab11;
import java.util.*;
public class KEdges   {

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

        List<Integer> verticesAtK(int start, int k) {
            boolean[] visited = new boolean[nodes];
            int[] dist = new int[nodes];
            Arrays.fill(dist, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start] = true;
            dist[start] = 0;

            while (!q.isEmpty()) {
                int node = q.remove();

                for (int neigh : adj.get(node)) {
                    if (!visited[neigh]) {
                        visited[neigh] = true;
                        dist[neigh] = dist[node] + 1;
                        q.add(neigh);
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nodes; i++)
                if (dist[i] == k)
                    result.add(i);

            return result;
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(5, 6);

        List<Integer> res1 = g.verticesAtK(0, 2);
        System.out.println("Vertices 2 edges away from 0: " + res1);

        List<Integer> res2 = g.verticesAtK(1, 1);
        System.out.println("Vertices 1 edge away from 1: " + res2);
    }
}

/*
EXPLANATION:

verticesAtK(start, k):
    BFS is used because BFS explores by levels.
    dist[] array stores distance (in number of edges) from start vertex.
    dist[start] = 0
    When visiting neighbors, dist[neighbor] = dist[node] + 1
    After BFS completes, all nodes at distance exactly k are collected.

In main():
    Graph built with 7 nodes.
    For start = 0, k = 2:
        Nodes exactly 2 edges away → [3,4,5]
    For start = 1, k = 1:
        Nodes exactly 1 edge away → [0,3,4]

This demonstrates how BFS finds nodes exactly k edges away.
*/
