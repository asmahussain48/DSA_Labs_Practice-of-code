package Lab11;
import java.util.*;
public class PossiblePaths  {

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

        void printAllPaths(int source, int dest) {
            boolean[] visited = new boolean[nodes];
            List<Integer> path = new ArrayList<>();
            dfs(source, dest, visited, path);
        }

        void dfs(int u, int dest, boolean[] visited, List<Integer> path) {
            visited[u] = true;
            path.add(u);

            if (u == dest) {
                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i));
                    if (i + 1 < path.size()) System.out.print(" -> ");
                }
                System.out.println();
            } else {
                for (int v : adj.get(u)) {
                    if (!visited[v]) dfs(v, dest, visited, path);
                }
            }

            path.remove(path.size() - 1);
            visited[u] = false;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("All paths from 0 to 4:");
        g.printAllPaths(0, 4);
    }
}

/*
EXPLANATION:

Graph:
    Undirected graph stored with adjacency lists.

addEdge(u, v):
    Connects u and v in both directions.

printAllPaths(source, dest):
    Prepares visited[] and an empty path list, then calls dfs.

dfs(u, dest, visited, path):
    1. Mark current node u visited and add it to path.
    2. If u == dest, print the current path.
    3. Otherwise, explore each unvisited neighbor v with recursive dfs.
    4. After exploring, remove u from path (backtrack) and unmark visited[u].

Backtracking ensures:
    - No vertex is repeated in a single path.
    - All distinct simple paths from source to dest are printed.

In main():
    Graph:
        0 connected to 1, 2
        1 and 2 both connect to 3
        3 connects to 4
    Paths from 0 to 4:
        0 -> 1 -> 3 -> 4
        0 -> 2 -> 3 -> 4
*/
