/*
 *                    Cycle Detection
 * 
 *  
 *           (1)----(0)-----(3)
 *              \    |       |
 *                \  |       |
 *                  (2)     (4)
 */

import java.util.*;
import java.util.LinkedList;

public class CycleDetection {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 Edge
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        // 1 Edge
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2 Edge
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3 Edge
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4 Edge
        graph[4].add(new Edge(4, 3));

    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case: 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // case: 1
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // case: 2 -> do nothiing -> continue
        }
        return false;
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        // bfs(graph);
        System.out.println(detectCycle(graph));
    }
}

/*
 * Output:
 * True
 */
/*The given code is a Java program that implements cycle detection in an undirected graph. It uses depth-first search (DFS) to detect cycles in the graph. Let's break down the code and explain how it works:

1. **Edge Class**:
   ```java
   static class Edge {
       int src;
       int dest;

       Edge(int src, int dest) {
           this.src = src;
           this.dest = dest;
       }
   }
   ```
   This class represents an edge in the graph. Each edge has a source vertex (`src`) and a destination vertex (`dest`).

2. **createGraph Method**:
   ```java
   public static void createGraph(ArrayList<Edge>[] graph) {
       // ... (code to create the graph edges)
   }
   ```
   This method initializes the graph by adding edges to it. It creates an array of ArrayLists, where each ArrayList represents the adjacency list for a vertex.

3. **detectCycle Method**:
   ```java
   public static boolean detectCycle(ArrayList<Edge>[] graph) {
       // ... (code to detect cycles in the graph)
   }
   ```
   This method is responsible for detecting cycles in the graph using DFS. It iterates through all vertices in the graph and checks for cycles starting from each unvisited vertex. If it finds a cycle, it returns `true`. Otherwise, it returns `false`.

4. **detectCycleUtil Method**:
   ```java
   public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
       // ... (DFS implementation to detect cycles)
   }
   ```
   This is a helper method for DFS-based cycle detection. It uses a recursive approach to traverse the graph and detect cycles. The `vis` array is used to keep track of visited vertices. It returns `true` if a cycle is detected and `false` otherwise.

5. **bfs Method**:
   ```java
   public static void bfs(ArrayList<Edge>[] graph) {
       // ... (Breadth-First Search traversal of the graph)
   }
   ```
   This method performs a Breadth-First Search (BFS) traversal of the graph starting from vertex 0. It prints the vertices in BFS order.

6. **main Method**:
   ```java
   public static void main(String[] args) {
       int v = 5;
       ArrayList<Edge>[] graph = new ArrayList[v];
       createGraph(graph);
       System.out.println(detectCycle(graph));
   }
   ```
   In the `main` method, the graph is created, and then the `detectCycle` method is called to check if the graph contains any cycles. The result (either `true` or `false`) is printed.

**Output**:
The output of the code is `true`, indicating that there is a cycle in the given graph.

The graph in this example has the following structure:
```
(1)----(0)-----(3)
   \    |       |
     \  |       |
       (2)     (4)
```
It's a simple graph with edges connecting vertices. The code correctly detects the presence of a cycle in this graph using depth-first search.*/
