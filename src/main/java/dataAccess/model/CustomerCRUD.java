package dataAccess.model;

import dataAccess.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class CustomerCRUD {

    public static List<Customer> read(long id) {
        Session sessionHibernate = HibernateUtil.getSession();
        List<Customer> customers;
        try {
            Query query = sessionHibernate.createQuery("from Customer c where c.id= :id");
            query.setParameter("id", id);
            customers = query.list();
        } finally {
            sessionHibernate.close();
        }
        return customers;
    }

    public static void updateCustomer(long idCustomer, LoanFile loanFile){
        Session sessionHibernate = HibernateUtil.getSession();
        try {
            Transaction transaction = sessionHibernate.beginTransaction();
            Query query = sessionHibernate.createQuery("from Customer c where c.id= :id");
            query.setParameter("id", idCustomer);
            List<Customer> customers = query.list();
            Customer customer = customers.get(0);
            customer.getLoanFiles().add(loanFile);
            sessionHibernate.saveOrUpdate(customer);
            transaction.commit();
        } finally {
            sessionHibernate.close();
        }


    }
}
