package Graph;
import java.util.List;


public class hasCycleDir {
    public static boolean hasCycleDirected(
            int node,
            boolean[] visited,
            boolean[] recStack,
            List<List<Integer>> adj) {

        visited[node] = true;
        recStack[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                if (hasCycleDirected(nei, visited, recStack, adj)) {
                    return true;
                }
            }
            else if (recStack[nei]) {
                return true;
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }

}
