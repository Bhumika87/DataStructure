package Graph;
import java.util.List;

import static Graph.Traversal.dfs;

public class countConnComp {

    public static int countConnectComponents(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        int count = 0;

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

}
