package Graph;
import java.util.List;

public class findPath {
    public static boolean findPath(
            int src,
            int dest,
            boolean[] visited,
            List<List<Integer>> adj) {

        if (src == dest) return true;

        visited[src] = true;

        for (int nei : adj.get(src)) {
            if (!visited[nei]) {
                if (findPath(nei, dest, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }


}
