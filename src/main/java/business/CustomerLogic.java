package business;

import dataAccess.model.Customer;
import dataAccess.model.CustomerCRUD;
import java.util.List;

public class CustomerLogic {


    public static Customer loadCustomerByID(long customerID){
        Customer customer = CustomerCRUD.read(customerID);
        if(customer == null){
            return null;
        }else {
            return customer;
        }
    }
}
