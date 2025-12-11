package Graph;

import java.util.*;

public class Traversal {
    
    public static void Bfs(int start, List<List<Integer>> adj){
        boolean visisted[] = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        visisted[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node +" ");
            for(int nei: adj.get(node)){
                if(!visisted[nei]){
                    visisted[nei] = true;
                    queue.add(nei);
                }
            
            }
        }

    }

    //visited[] is created fresh in every recursive call. 
    // So DFS never remembers previously visited nodes → leads to infinite recursion / stack overflow or repeated visits.
    //DFS should use one shared visited array, not new inside recursion
    public static void dfs(int start, List<List<Integer>> adj, boolean visisted[]){
        visisted[start] = true;
        System.out.print(start + " ");
        for(int nei: adj.get(start)){
            if(!visisted[nei]){
                dfs(nei, adj, visisted);
            }
        }
    }


    public static void main(String[] args) {
         Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("BFS Traversal starting from node 0:");    
        Bfs(0, g.getAdj());
        System.out.println("DFS Traversal starting from node 0:");


       boolean[] visited = new boolean[g.getAdj().size()];
       dfs(0, g.getAdj(), visited);

    }
    
}
