package dataAccess.model;

import dataAccess.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class CustomerCRUD {

    public static Customer read(long id) {
        Session sessionHibernate = HibernateUtil.getSession();
        Customer customer;
        try {
            Query query = sessionHibernate.createQuery("from Customer c where c.id= :id");
            query.setParameter("id", id);
            customer = (Customer) query.uniqueResult();
        } finally {
            sessionHibernate.close();
        }
        return customer;
    }


}
