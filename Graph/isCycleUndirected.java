package Graph;
import java.util.*;

class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


public class isCycleUndirected {
    static boolean cycleeDetact(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int parent[]) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s] = true;


        while (!q.isEmpty()) {
            // source node
            int node = q.peek().first;
            int par = q.peek().second; //its parent node
            q.remove();

            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {   // go to all the adjacent nodes
                    q.add(new Node(it, node));
                    vis[it] = true;
                }

                // if adjacent node is visited or parent same ni h toh cycke h
                else if (par != it) return true;
            }
        }
        return false;
    }

    // function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++)
            if (vis[i] == false)
                if (cycleeDetact(adj, i, vis, parent))
                    return true;

        return false;
    }
}
