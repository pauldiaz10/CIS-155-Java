
package intnodemain;

public class IntNodeMain {

    public static void main(String[] args) {
       IntNode head = null;
       head = new IntNode(20, head);
       head = new IntNode(45, head);
       head = new IntNode(15, head);
       head = new IntNode(63, head);

       head.addNodeAfter(11);

       IntNode.insertAtPos(head, 2, 56);
       //System.out.println(IntNode.listPosition(head, 3));
       IntNode ptr = head.getLink();
       while(ptr != null){
            System.out.print(ptr.getData() + " ");
            ptr = ptr.getLink();
       }
       System.out.println();
       //IntNode.insertAtPos(head, 2, 56);
    }
}
