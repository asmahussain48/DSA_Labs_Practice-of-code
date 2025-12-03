package Lab11;
import java.util.*;
public class CycleExist {

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

        boolean hasCycle() {
            boolean[] visited = new boolean[nodes];

            for (int i = 0; i < nodes; i++) {
                if (!visited[i]) {
                    if (dfs(i, -1, visited)) return true;
                }
            }
            return false;
        }

        boolean dfs(int node, int parent, boolean[] visited) {
            visited[node] = true;

            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    if (dfs(neigh, node, visited)) return true;
                } else if (neigh != parent) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {

        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);

        System.out.println("Graph 1 has cycle: " + g1.hasCycle());

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);

        System.out.println("Graph 2 has cycle: " + g2.hasCycle());
    }
}

/*
EXPLANATION:

Graph:
    Uses adjacency list for an undirected graph.

addEdge(u, v):
    Adds u <-> v because graph is undirected.

hasCycle():
    Uses DFS for each unvisited node.
    If DFS detects a cycle, return true.

dfs(node, parent, visited):
    Mark node visited.
    Visit all neighbors.
    If neighbor not visited -> DFS deeper.
    If neighbor visited and neighbor != parent -> a cycle exists.

In main():
    Graph g1: Edges (0-1, 1-2, 2-0) forms a triangle -> cycle exists -> prints true.
    Graph g2: A simple chain (0-1-2-3) -> no cycle -> prints false.
*/
