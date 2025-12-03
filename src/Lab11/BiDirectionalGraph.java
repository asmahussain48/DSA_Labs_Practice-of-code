package Lab11;

public class BiDirectionalGraph  {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        return dfs(source, destination, edges, visited);
    }

    private static boolean dfs(int node, int dest, int[][] edges, boolean[] visited) {
        if (node == dest) return true;
        visited[node] = true;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (u == node && !visited[v]) {
                if (dfs(v, dest, edges, visited)) return true;
            } else if (v == node && !visited[u]) {
                if (dfs(u, dest, edges, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] edges1 = { {0,1}, {1,2}, {2,0} };
        int source1 = 0;
        int destination1 = 2;
        System.out.println(validPath(n1, edges1, source1, destination1));

        int n2 = 6;
        int[][] edges2 = { {0,1}, {0,2}, {3,5}, {5,4}, {4,3} };
        int source2 = 0;
        int destination2 = 5;
        System.out.println(validPath(n2, edges2, source2, destination2));
    }
}

/*
EXPLANATION:

validPath:
    n = number of vertices (0 to n-1)
    edges = list of undirected edges
    Returns true if there is a path from source to destination.

We create a visited[] array to avoid revisiting nodes.
We call dfs starting from 'source'.

dfs(node, dest, edges, visited):
    If node == dest -> path found -> return true.
    Mark node as visited.
    For each edge:
        If node is one end of the edge (u or v),
        then the other end is its neighbor.
        If neighbor not visited, recursively DFS from neighbor.
        If any DFS call returns true, propagate true upward.
    If all neighbors explored and no path, return false.

In main:
    Example 1:
        n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
        Graph is connected -> prints: true

    Example 2:
        n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
        Two separate components -> prints: false
*/
