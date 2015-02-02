package business;

import dataAccess.model.Customer;
import dataAccess.model.CustomerCRUD;
import java.util.List;

public class CustomerLogic {

    private CustomerCRUD customerCRUD = new CustomerCRUD();

    public Customer loadCustomerByID(long customerID){
        List<Customer> customers = customerCRUD.read(customerID);
        if(customers.size() == 0){
            return null;
        }else if(customers.size() == 1){
            return customers.get(0);
        }else{
            return null;
        }
    }
}
