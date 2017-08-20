
package tablemain;

public class Customer {
    private String name;
    private String address;
    private int customerId;

    public Customer(String name, String address, int custoId){
        this.name = name;
        this.address = address;
        this.customerId = custoId;
    }

    public String getName(){
        return name;
    }
    public String address(){
        return address;
    }
    public int getCustomerId(){
        return customerId;
    }
}
