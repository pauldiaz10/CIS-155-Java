
package tablemain;
import java.util.*;

public class TableMain {

    public static void main(String[] args) {
        Customer c1 = new Customer("India", "San Bruno", 111);
        Customer c2 = new Customer("India", "San Mateo", 222);
        Customer c3 = new Customer("India", "San Bruno", 323);
        Customer c4 = new Customer("India", "San Bruno", 444);
        Customer c5 = new Customer("India", "San Mateo", 55);

        CustKey k1 = new CustKey(10);
        CustKey k2 = new CustKey(20);
        CustKey k3 = new CustKey(30);
        CustKey k4 = new CustKey(40);
        CustKey k5 = new CustKey(50);

       // int a = k1.hashCode();
        //Hastable<>
        Hashtable<CustKey, Customer> table = new Hashtable<CustKey, Customer>();

        table.put(k1, c1);
        table.put(k2, c2);

        Collection<Customer> set = table.values();
        Iterator<Customer> i = set.iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }

    }
}
