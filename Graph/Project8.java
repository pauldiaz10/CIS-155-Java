
package project8;

public class Project8 {

    public static void main(String[] args) {
        
        Graph graph = new Graph(10);
        graph.addEdge(0, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 3);
        graph.addEdge(4, 2);
        graph.addEdge(3, 4);
        graph.addEdge(7, 5);
        
        graph.printGraph();
        
        System.out.println(graph.isEdge(0, 3));
        System.out.println(graph.isEdge(4, 2));
        System.out.println(graph.isEdge(5, 0));
        System.out.println(graph.isEdge(9, 4));
        
        /*graph.removeEdge(0, 3);
        graph.removeEdge(3, 2);
        graph.removeEdge(3, 3);
        graph.removeEdge(4, 2);
        graph.removeEdge(3, 4);*/
        
        System.out.print("\nNeighbors: ");
        int []neigh = graph.neghbors(3);
        
        for(int i = 0; i < neigh.length; i++){
            System.out.print(neigh[i] + " ");
        }
        System.out.println("\n");
        
        
        //System.out.print("\nNeighbors: ");
        //graph.neghbors(7);
        //System.out.println("\n");
        
        graph.printGraph();
    }
}
