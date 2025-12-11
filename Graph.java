import java.util.List;
import java.util.ArrayList;

class Graph{
    private int vertices;
    private List<List<Integer>> adjList;
    public Graph(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for(int i =0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printGraph() {
       for(int i =0;i<vertices;i++){
        System.out.print(i + " -> ");
        List<Integer> neig = adjList.get(i);
        for(int j =0;j<neig.size();j++){
            System.out.print(neig.get(j) + " ");
        }
        System.out.println();
       }
    }

    public static void main(String[]args){

        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);

        graph.printGraph();
    }
}