import java.util.LinkedList;
import java.util.Arrays;

public class HospitalGraph {
    private int vertices = 8;
    private String[] zones = {"ER", "ICU", "Surgery", "Pharmacy", "Labs", "Pediatrics", "Cardiology", "Neurology"};
    private int[][] matrix;
    private LinkedList<Integer>[] adjList;

    public HospitalGraph() {
        matrix = new int[vertices][vertices];
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<Integer>();
            Arrays.fill(matrix[i], 9999); 
            matrix[i][i] = 0; 
        }
    }

    public void addRoad(int src, int dest, int distance) {
        matrix[src][dest] = distance;
        matrix[dest][src] = distance;
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Path: ");
        DFSUtil(startVertex, visited);
        System.out.println();
    }
    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(zones[v] + " -> ");
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) DFSUtil(neighbor, visited);
        }
    }

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Path: ");
        while (queue.size() != 0) {
            int current = queue.poll();
            System.out.print(zones[current] + " -> ");
            for (int neighbor : adjList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void floydWarshall() {
        int[][] dist = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++)
            for (int j = 0; j < vertices; j++)
                dist[i][j] = matrix[i][j];

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("\nShortest Distances Between All Zones (Floyd-Warshall):");
        for (int i = 0; i < vertices; ++i) {
            for (int j = 0; j < vertices; ++j) {
                if (dist[i][j] == 9999) System.out.print("INF\t");
                else System.out.print(dist[i][j] + "km\t");
            }
            System.out.println();
        }
    }
}