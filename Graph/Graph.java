
package project8;
import java.util.*;

public class Graph<E> implements Cloneable{
    private E [] vertexlist;
    private LinkedList<EdgeNode>[]edges;
    private int howmany;
    private int [] numberOfEdges;
    
    public Graph(int n){
        vertexlist = (E[]) new Object[n];
        edges = (LinkedList<EdgeNode>[]) new LinkedList[n];
        numberOfEdges = new int[n];
        
        for(int i = 0; i < n; i++){
           edges[i] = new LinkedList();
        }
    }
    
    public boolean isEdge(int source, int target){
        boolean edge = false;
        Iterator<EdgeNode> iterator = ((LinkedList<EdgeNode>)edges[source]).iterator();
                
        while(iterator.hasNext()){
            if(target == iterator.next().getvnum()){
                edge = true;
             }
         }
        return edge; 
    }
    
    public void addEdge(int source, int target){
        edges[source].add(new EdgeNode(target));
        numberOfEdges[source]++;
    }
       
    public void removeEdge(int source, int target){
        Iterator<EdgeNode> iterator = ((LinkedList<EdgeNode>)edges[source]).iterator();
        if(target == iterator.next().getvnum()){
            ((LinkedList<EdgeNode>)edges[source]).remove();
        }  
    }
    
    public int[] neghbors(int vertex){
        int count;
        int [] temp;
                
        Iterator<EdgeNode> iterator = ((LinkedList<EdgeNode>)edges[vertex]).iterator();
                
        count = 0;
        temp = new int [numberOfEdges[vertex]];
        while(iterator.hasNext()){
            temp[count] = iterator.next().getvnum();
             count++;     
        }
        return temp;
    }
    
    public E getLabel(int vertex){
        return vertexlist[vertex];
    }
    
    public void setLabel(int vertex, E newlabel){
        vertexlist[vertex] = newlabel;
    }
    
    public int size(){
        return howmany;
    }
    
    @Override
    public Graph<E> clone()
    {
        Graph<E> cloned;
        try{ 
            cloned = (Graph<E>) super.clone();
        }catch(CloneNotSupportedException ex){
            throw new RuntimeException("cannot clone");
        }
        cloned.edges = edges.clone();
        cloned.vertexlist = vertexlist.clone();
        return cloned;
    }
    
    public void printGraph(){
        for(int i = 0; i < edges.length; i++){
            System.out.print(i + ": ");
            for(int j = 0; j < edges.length; j++){
                if(isEdge(i, j)){
                    System.out.print(" T ");
                }else{
                    System.out.print(" O ");
                }
            }
            System.out.println();                
         }
    }
}
