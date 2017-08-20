
package project8;

public class EdgeNode {
    private int vertexNum;
    
    public EdgeNode(int vnum){
        vertexNum = vnum;
    }
    
    public void setvnum(int vnum){
        
        vertexNum = vnum;
    }
    
    public int getvnum(){
        return vertexNum;
    }
    
    public boolean equals(Object obj){
        return vertexNum == ((EdgeNode)obj).getvnum();
    }
}
